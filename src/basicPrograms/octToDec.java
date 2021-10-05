package basicPrograms;

// octal to decimal conversion
public class octToDec {
    public static void main(String[] args) {
        int oct = 44;
        int dec = 0;

        int n = 0;
        while(oct != 0) {
            int rem = oct % 10;
            dec += rem * Math.pow(8, n++);
            oct /= 10;
        }

        System.out.println(dec);
    }
}
