package basicPrograms;

// lcm of 2 nums
public class lcm {
    public static void main(String[] args) {
        int a = 120, b = 72;

        int gcd = 0;

//        find gcd first
        for (int i = 1; i <= a || i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

//        then calculate lcm by following formula
        int lcm = (a*b) / gcd;
        System.out.println(lcm);
    }
}
