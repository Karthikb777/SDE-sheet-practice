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

    public static int minOperations(int n, int k, int[] a) {
        int min = 0;

        int x = 1;
        int flag = 1;

        int p = 0;
        int ind = 0;

        while(flag < a.length) {

            for(int i = ind; i < p && p <=k; i++) {
                int y = (int) Math.pow(2, p);
                a[i] = a[i] ^ y;
                p++;
                if(a[i] == 0) {
                    flag++;
                    min++;
                    p--;
                    ind = i;
                }
            }

        }
        p++;


        return min;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while(t-- > 0) {
            // your code goes here
            int n = fr.nextInt();
            int k = fr.nextInt();

            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
            }

            int minOp = minOperations(n, k, arr);
            System.out.println(minOp);

        }

    }
}
