package DSAprep;

import java.util.HashMap;

public class D4NumberOfSubarraysWithGivenXOR {

    /*
    *   most optimized solution using hashmap:
    *       initialize xor = 0 and count = 0
    *       iterate over the array, for every element ele,
    *           compute xor = xor ^ ele
    *           compute y = xor ^ k
    *           check if y exists in hashmap,
    *               if yes, then update count with count + the frequency of the prefix xor in the hashmap
    *           check if xor == k
    *               if yes, do count++
    *           check if xor is in hashmap
    *               if yes, increment the frequency of the xor in hashmap by 1.
    *               if no, put the xor in hashmap with frequency as 1.
    *
    *   TC: O(N)
    *   SC: O(N)
    *
    *   Understanding:
    *       if xor is the prefix sum and k is the target xor of the elements,
    *       if we find y = xor ^ x, then y is the number of sub-arrays with the xor of k.
    *       refer to the dry run in the notes to get a better understanding.
    *
    *   Brute force:
    *       generate all sub-arrays and find the number of sub-arrays with xor of k.
    *
    * */

    public static int solve(int[] arr, int x) {
        int n = arr.length;
        int xor = 0;
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];

            if(hashMap.get(xor ^ x) != null) {
                count = count + hashMap.get(xor ^ x);
            }

            if (xor == x) {
                count += 1;
            }

            if (hashMap.get(xor) != null) {
                hashMap.put(xor, hashMap.get(xor) + 1);
            }
            else {
                hashMap.put(xor, 1);
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int [] arr = {4, 2, 2, 6, 4};
        int x = 6;
        System.out.printf("the number of subarrays with xor %d is %d%n", x, solve(arr, x));
    }
}
