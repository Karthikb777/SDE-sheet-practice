package DSAprep;

/*
*  given an integer array nums, find the contiguos subarray (containing at least one number) which has the largest sum and return it's sum
* */
public class D1MaximumSubarray {
//    brute force method
    public static int max(int[] arr) {
        return 0;
    }
/*    kadane's algorithm
*       intuition: we carry a sub array sum as long it gives a positive sum
*  */
    public static int maxSum(int[] arr) {
        int sum = 0;
        int maxi = arr[0];
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > maxi) maxi = sum;
            if(sum < 0) sum = 0;
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSum(arr));
    }
}
