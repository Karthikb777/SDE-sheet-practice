package basicPrograms;

//  binary to octal converison, do binary to decimal conversion first using binary to decimal logic and then do decimal to octal
public class binToOct {
    public static void main(String[] args) {
        int n = 100100;
        int dec = Integer.parseInt(String.valueOf(n), 2);
        System.out.println(dec);

        int i = 0;
        int oct = 0;
        while(dec != 0) {
            int rem = dec % 8;
            oct += rem * Math.pow(10, i++);
            dec /= 8;
        }

        System.out.println(oct);
    }

}
