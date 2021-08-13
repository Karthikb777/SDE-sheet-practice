package DSAprep;

/*
*       find the maximum number of consecutive 1's in an array:
*           initialize 2 variables, maximum and count
*           iterate over the array
*               if the element is 1, do count++ and set maximum to max(maximum, count)
*               else set count to 0
*           return maximum
*       TC - O(n)
*       SC -O(1)
* */

public class D7maxConsecutiveOnes {

    public static int maxOnes(int[] arr) {
//        count and maximum vars
        int count = 0;
        int maximum = 0;

//        iterate over the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count += 1;
                maximum = Math.max(maximum, count);
            } else count = 0;
        }

        return maximum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1};
        System.out.println(maxOnes(arr));
    }
}
