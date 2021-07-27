package DSAprep;

import java.util.HashMap;

public class D4LargestSubArrayWithZeroSum {

    /*
    *       optimized method: using hashmap
    *       declare a hashmap
    *       set sum = 0, maxi = 0
    *       iterate over the array, for every element ele,
    *           sum += ele
    *           check if sum == 0, if yes, maxi = i + 1
    *           else
    *               check if sum is in hashmap, if yes, maxi = max(maxi, diff between i and map.get(sum))
    *               if no, add the sum and the current index into the hashmap
    *
    *       understanding the algorithm:
    *           keep track of the prefix sum.
    *           if sum = 0, then the maxi is the length of the sub-array from the starting index 0.
    *           if sum is in the hashmap, then maxi is the max of maxi's current value and the difference between
    *           current index and the value of sum in hashmap, i.e the index at which the prefix sum was obtained.
    *
    *       TC - O(NlogN) for traversing + hashmap
    *       SC - O(N)
    *
    *
    *       the brute force method is to just generate all the sub-arrays and calculate the longest sub-array with sum = 0
    *
    * */

    public static int longestSubArray(int[] arr) {
        int maxi = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = arr.length;

//        iterate over array elements
        for (int i = 0; i < n; i++) {
//            compute the sum
            sum += arr[i];

//            check if sum == 0
            if(sum == 0) {
                maxi = i + 1;
            }

            else {
//                check if sum is in the hashmap
                if(hashMap.containsKey(sum)) {
                    maxi = Math.max(maxi, i - hashMap.get(sum));
                }
                else {
                    hashMap.put(sum, i);
                }
            }
        }

        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        System.out.printf("Longest sub-array length with sum = 0 is: %d%n", longestSubArray(arr));
    }
}
