package DSAprep;

/*
*  given an integer array nums, find the contiguous sub-array (containing at least one number)
*  which has the largest sum and return it's sum
* */
public class D1MaximumSubarray {
//    TODO: brute force method
    public static int max(int[] arr) {
        return 0;
    }

/*    kadane's algorithm
*       intuition: we carry a sub array sum as long it gives a positive sum
*  */
    public static int maxSum(int[] arr) {
//        initially set sum = 0
        int sum = 0;
//        take the first element of the array as the maximum element
        int maxi = arr[0];
//        iterate over the array
        for(int i = 0; i < arr.length; i++) {
//            add the array element to sum
            sum += arr[i];
//            check if sum is greater than maximum, if yes, set maximum = sum
            if(sum > maxi) maxi = sum;
//            check if sum < 0, if yes, set sum = 0
//            this is kadane's algorithm, we carry a sub array sum as long it is greater than 0
            if(sum < 0) sum = 0;
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSum(arr));
    }
}
