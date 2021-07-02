package com.karthik.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//  preferred way of io in cp in java
public class fastio {
    static class fastReader {
        BufferedReader br;
        StringTokenizer st;

        public fastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
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

    public static int binExp(int a, int b) {
        int res = 1;
        while (b > 0) {
            if((b & 1) != 0) res = res * a;
            b = b >> 1;
            a = a*a;
        }
        return res;
    }


    public static void main(String[] args) {
        int a = 9;
        int b = 5;

        int x = 0b1100;
        int y = 0b0001;
        System.out.println(x&y);

//        int c = binExp(a, b);
//        System.out.println(c);
    }
}
