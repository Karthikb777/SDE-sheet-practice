package DSAprep;

/*
*       minimum number of platforms required for a railway station:
*           greedy algorithm solution:
*               sort both the arrival and departure arrays
*               for every arrival,
*                   check if the arrival time is less than or equal to departure time of the previous train
*                       if yes, then we need a new platform
*                       so do count++
*                       also increment i to move on to the next arriving train
*                   else, check if the arrival time is greater than the departure time of the previous train
*                       if yes, then we can remove one platform
*                       so do count--
*                       also increment j so we can move on to the next departing train
*                   finally, check if count is greater than platforms
*                       if yes, update platforms with count
*               return platforms
*
*               TC - O(2nlogn) for sorting the arrays
*                  + O(2n) for iterating
*               [2 is because there are 2 arrays]
*
*               SC - O(1)
*
* */

import java.util.Arrays;

public class D8minNoOfPlatforms {

    public static int minPlatforms(int[] arr, int[] dep) {
        int platforms = 1, count = 1;
//        first sort both arr and dep arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0, n = arr.length;
//        for every arrival, check if the arriving time is less than or equal to the
//        departure time of the previous train
//        if yes, then we need a new platform
        while(i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            }
//            if arrival time is greater than the departure time of the previous train,
//            we can remove a platform coz we can accomodate both trains in the same platform
            else if(arr[i] > dep[j]) {
                count--;
                j++;
            }
//          update the max no. of platforms
            if(count > platforms) platforms = count;
        }

        return platforms;
    }

    public static void main(String[] args) {
//        arrival and departure times
        int[] arr = {900, 948, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        int platforms = minPlatforms(arr, dep);
        System.out.println("max no. of platforms required: " + platforms);
    }
}
