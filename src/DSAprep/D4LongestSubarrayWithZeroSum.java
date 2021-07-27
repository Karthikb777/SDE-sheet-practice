package DSAprep;

import java.util.HashMap;

public class D4LongestSubarrayWithZeroSum {

    /*
    *   most optimized solution using hashing:
    *       keep track of prefix sum,
    *       whenever sum = 0, the sub-array from index 0 to current index has the sum 0.
    *       whenever sum s is in the hashmap,
    *           then sum = current index - the index of prefix sum in the hashmap.
    *
    *       TC: O(NlogN), for traversal and hashing
    *       SC: O(N)
    *
    *   understanding:
    *       if the sum of all elements is S and the sum of elements up to a certain index i is S,
    *       then we cam say that the sum of elements from index i+1 till the end is 0.
    *
    *   brute force method:
    *       generate all sub-arrays and return the length of the longest subarray with the sum of 0.
    * */

    public static int longestSubArray(int[] arr) {
        int longest = 0;
        int sum = 0;
//        declare a hashmap
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int n = arr.length;

//        iterate over the array
        for (int i = 0; i < n; i++) {
//            calculate the sum
            sum += arr[i];

//            check if sum == 0
            if (sum == 0) {
                longest = i + 1;
            }
            else {
//          check if sum exists in the hashmap, if yes, send longest as the diff between current index and index of prefix sum
                if (hashMap.get(sum) != null) {
                    longest = Math.max(longest, i - hashMap.get(sum));
                }
                else {
//                    if no, put the prefix sum into the hashmap
                    hashMap.put(sum, i);
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 2};
        System.out.printf("the longest sub-array with zero sum is %d%n", longestSubArray(arr));
    }
}
