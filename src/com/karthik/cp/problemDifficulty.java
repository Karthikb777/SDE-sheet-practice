package com.karthik.cp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class problemDifficulty {

    public static int noOfSets(int[] diff) {
//        generate all combinations
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < diff.length; i++) {
            for (int j = 0; j < diff.length; j++) {
                if (i != j) {
                    int a = diff[i];
                    int b = diff[j];

                }
            }
        }
//        for (int[] set: sets) {
//            for (int i: set) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
        return 0;
    }
    public static void main(String[] args) {
        int[] diff = {1 ,2, 3, 4};
        noOfSets(diff);
    }
}
