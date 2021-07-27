package DSAprep;

import java.util.HashMap;

public class D4longestSubStringWithoutRepeatingCharacters {

    /*
    *   most optimized solution using hashmap
    *       in the loop,
    *           check if char at index right exists in the hashmap
    *               if yes, check if the last found index is greater than the left index
    *                   if yes, update the last found index of the char to last found + 1
    *               calculate the longest sequence = right - left + 1
    *               if char exists in hashmap, update the last found index to be right index
    *               else put char in hashmap along with last found index as the right index
    *
    *       TC: O(N) and SC: O(N)
    *
    *       refer the notes for less optimized and brute force solution
    * */

    public static int solve(String s) {
        int longest = 0;

//        take 2 pointers left and right, set them to zero
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int n = s.length();

        while (right < n) {
//            check if the char at index right exists in the hashmap
            if (hashMap.get(s.charAt(right)) != null)
//                if yes, and if the last found index of char is greater than left,
//                move the left pointer to last found index + 1 position
                left = Math.max(left, hashMap.get(s.charAt(right)) + 1);

//            compute longest
            longest = Math.max(longest, right - left + 1);
//            put or update the last found index of the char
            hashMap.put(s.charAt(right), right);
//            increment right by 1
            right++;

        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "abcaabcdbb";
        System.out.println(solve(s));
    }
}
