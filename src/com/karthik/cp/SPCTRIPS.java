package com.karthik.cp;

public class SPCTRIPS {
    public static int spctriplets(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n ; j++) {
                for (int k = 1; k <=n ; k++) {
                    if ((i % j == k) && (j % k == 0)) count++;
//                    System.out.println(i + " " + j + " " + k);
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(spctriplets(n));
    }
}
