package basicPrograms;

import java.util.Scanner;

// prime number or not
public class isPrime {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number to do a prime check:");
        num = sc.nextInt();
        sc.close();
        boolean flag = false;

        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        if (flag) System.out.println("not a prime number");
        else System.out.println("is a prime number");
    }
}
