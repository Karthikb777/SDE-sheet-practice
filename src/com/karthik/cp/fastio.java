/* package codechef; // don't place package name! */
package com.karthik.cp;

import java.util.*;
import java.lang.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* Name of the class has to be "Main" only if the class is public. */
class fastio
{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static boolean isSqrt(int n) {
        int sqrt = (int) Math.sqrt(n);
        int res = sqrt * sqrt;
        return (res == n);
    }

    public static long megaSquare(int n, int a) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        long x = 0;

        if(isSqrt(n)) x = n;
        else {
            while (!isSqrt(n)) {
                x = n;
                n--;
            }
            x--;
        }

        long res = (long) Math.sqrt(x) * a;
        return res;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while(t-- > 0) {
            int n = fr.nextInt();
            int a = fr.nextInt();
            System.out.println(megaSquare(n, a));
        }

    }
}
