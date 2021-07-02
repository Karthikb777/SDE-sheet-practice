package com.karthik.cp;

/*
*       Binary exponential: method to calculate exponential in logn time:
*       rules -> a^n =
*                       1 if n == 0
*                       ( a ^ (n/2) ) ^ 2  if n > 0 and n is even
*                       ( ( a ^ ((n - 1) / 2) ) ^ 2 ) * a if n > 0 and n is odd
*       Here is the iterative implementation
* */

public class BinaryExponential {
    public static long binExp(long a, long b) {
        long res = 1;

        while (b > 0) {
//            check if b is odd, if yes multiply res and a
            if((b & 1) != 0) res = res * a;
//            right shift b, now b = b/2
            b = b >> 1;
            a = a * a;
        }
        return res;
    }
    public static void main(String[] args) {
        long a = 25;
        long b = 5;
        System.out.println(binExp(a, b));
    }
}
