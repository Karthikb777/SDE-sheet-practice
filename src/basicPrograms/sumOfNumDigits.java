package basicPrograms;

// sum of all the digits in a number
public class sumOfNumDigits {
    public static void main(String[] args) {
        int num = 123;

        int sum = 0;
        while(num != 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }

        System.out.println(sum);
    }
}
