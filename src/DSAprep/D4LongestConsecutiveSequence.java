package DSAprep;

import java.util.Arrays;
import java.util.HashSet;

/*
*       optimized solution - using hashset
*       steps:
*           put all the elements into a hashset
*           iterate over the array and for every element 'num',
*               check if num - 1 exists in the hashset, if yes, continue
*               if no, check if num + 1 exists in the hashset,
*                   if yes, increment currentLongest by 1 and check the above condition again
*                   do this until the above condition becomes false
*           return the max longest consecutive sequence.
*
*       NOTE - we are checking for num - 1 to get the lowest number in the sequence.
*               once we get the lowest number, we can easily get the longest sequence.
*
*          TC = O(N) for putting elements into hashset + O(N) for iterating over the array + O(N) for checking if num + 1 exists in the hashset
*          TC = O(3N)
*          SC = O(N)
* */

/*
*       brute force solution - sort the array and find the longest consecutive sequence
*       TC = O(NlogN) + O(N)
* */

public class D4LongestConsecutiveSequence {

    public static int longest(int [] arr) {
        int longestSequence = 0;
//        put all the array elements in a hashset
        HashSet<Integer> hashSet = new HashSet<>();
        for(int ele: arr) {
            hashSet.add(ele);
        }

//        iterate over the array
        for(int num: arr) {
//            check if hashset doesn't contain num - 1
            if (!hashSet.contains(num - 1)) {
                int currentLongest = 1;
                int currentNum = num;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLongest += 1;
                }

                longestSequence = Math.max(longestSequence, currentLongest);
            }
        }

        return longestSequence;
    }

    public static int longestBruteForce(int [] arr) {
        int longest = 0;

        Arrays.sort(arr);

        int temp = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i+1] - arr[i] == 1) temp++;
            else temp = 0;
            longest = Math.max(longest, temp);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 102, 103, 101, 2, 3, 4, 6, 5, 1};
        System.out.println(String.format("the longest sequence is (brute force method): %d", longestBruteForce(arr)));
        System.out.println(String.format("the longest sequence is: %d", longest(arr)));
    }
}
