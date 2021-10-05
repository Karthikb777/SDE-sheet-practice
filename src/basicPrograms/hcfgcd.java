package basicPrograms;


// finding hcf or gcd of 2 numbers
public class hcfgcd {
    public static void main(String[] args) {
        int a = 625, b = 125, hcf = 0;
        for (int i = 1; i <= a || i <= b; i++) {
            if (a % i == 0 && b % i == 0) hcf = i;
        }
        System.out.println(hcf);
    }
}
