package basicPrograms;

// decimal to binary conversion program
public class decimalToBin {
    public static void decToBin(int num) {
        if (num >= 1) {
            decToBin(num / 2);
            System.out.print(num % 2);
        }
    }
    public static void main(String[] args) {
        int num = 8;
        decToBin(num);

//        binary to decimal conversion
        int binnum = 1010;
        System.out.println("\n" + Integer.parseInt(String.valueOf(binnum), 2));
    }
}
