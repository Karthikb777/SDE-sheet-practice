package basicPrograms;

//  binary to decimal conversion
public class binToDec {
    public static void main(String[] args) {
        int num = 1111;
        int dec = 0;
        int n = 0;
        while(num != 0) {
            int rem = num % 10;
            dec += rem * Math.pow(2, n++);
            num /= 10;
        }
        System.out.println(dec);
    }
}
