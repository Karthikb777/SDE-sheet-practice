package DSAprep;

import java.util.ArrayList;
import java.util.List;

/*
*       palindrome partitioning:
*           recursive solution:
*               TODO
* */

public class D9PalindromePartitioning {

    private static void recur(int index, String s, List<List<String>> ans, List<String> ds) {
//        base case
        if (index == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

//        loop
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i+1));
                recur(index+1, s, ans, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public static List<List<String>> solve(String s) {
        List<List<String>> ans = new ArrayList<>();
        recur(0, s, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        String a = "aab";
        List<List<String>> ans = solve(a);
        for (List<String> substr : ans) {
            for (String s : substr) {
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }
}
