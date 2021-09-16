package com.karthik.cp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d2cfirstques {
//    generate all permutations of the substring
//    find the palindromes of the substring and then get the first palindrome

    public static List<String> getAllPerms(int start, int end, String s) {
        List<String> ans = new ArrayList<>();

//        call the recursive method here
        recur(start, end, s, ans);
        return ans;
    }

//    is palindrome method
    public static boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    private static void recur(int start, int end, String s, List<String> ans) {
//        base case - if start == end, add s to ans and return
        if (start == end) {
            ans.add(s);
            return;
        }

//        generate permutations by swapping
        for (int i = start; i < end; i++) {
            s = swap(start, i, s);
//            call the recur method for +1
            recur(start+ 1, end, s, ans);
//            swap back the chars to get the original string
            s = swap(start, i, s);
        }
    }

    private static String swap(int a, int b, String st) {
        char[] s = st.toCharArray();
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int len = 4;
        String str = "mmcs";
//        String str = s.next();
        int q = 1;

        while(q-- > 0) {
            int l = 1;
            int r = 3;
            List<String> ans = getAllPerms(l-1, r, str);
            for (String i : ans) {
                if (isPalindrome(l-1, r-1, i))
                    System.out.println(i);
            }

        }

        s.close();
    }
}
