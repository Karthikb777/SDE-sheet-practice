package basicPrograms;

// is palindrome check
public class palindrome {
    public static boolean isPalindrome(String s) {
        int n = s.length() - 1;
        int i = 0;
        while(i <= n) {
            if (s.charAt(i++) != s.charAt(n--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ababaabbaababa";
        System.out.println(isPalindrome(s));

    }
}
