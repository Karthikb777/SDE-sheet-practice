package basicPrograms;

// checking if a 3 digit number is an armstrong number or not

public class armstrong {
    public static void main(String[] args) {
        int num = 153;
        int original = num;
        int res = 0;

        while(num != 0) {
            int rem = num % 10;
            res += Math.pow(rem, 3);
            num = num / 10;
        }

        if (original == res) System.out.println("is an armstrong number");
        else System.out.println("not an armstrong number");
    }
}
