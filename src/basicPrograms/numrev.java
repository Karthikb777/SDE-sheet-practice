package basicPrograms;

// reverse a number
public class numrev {
    public static int revnum(int num) {
        int rem = 0;
        int rev = 0;

        while(num != 0) {
            rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int num = 1234;
        System.out.println(revnum(num));
    }
}
