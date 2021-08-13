package com.karthik.cp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class problemDifficulty {

    public static int noOfSets(int[] diff) {
//        generate all combinations
        HashSet<int[]> set = new HashSet<>();

        for (int i = 0; i < diff.length; i++) {
            for (int j = 0; j < diff.length; j++) {
                if (diff[i] != diff[j]) {
                    int[] a = {diff[i], diff[j]};
                    set.add(a);
                }
            }
        }

        ArrayList<Integer> vis = new ArrayList<>();
        int count = 0;
        HashSet<int[]> x = new HashSet<>();

        for (int[] s: set) {
            if (!(vis.contains(s[0]) && vis.contains(s[1]))) {
                count++;
                vis.add(s[0]);
                vis.add(s[1]);
                x.add(new int[]{s[0], s[1]});
            }
        }

        for (int[] a : x) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        return count;
    }
    public static void main(String[] args) {
        int[] diff = {1 ,4, 3, 2};
        System.out.println(noOfSets(diff));
    }
}
