package DSAprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
*   Given a collection of intervals, merge all overlapping sub-intervals
* */

public class D1MergeOverlappingSubIntervals {
//    brute force solution
//    TODO

//    optimal solution
    public static ArrayList<int[]> merge(int[][] arr) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int start = arr[0][0];
        int end = arr[0][1];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i][0] <= end) {
                end = Math.max(end, arr[i][1]);
            } else {
                res.add(new int[] {start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        res.add(new int[] {start, end});
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3},
                {8, 10},
                {2, 6},
                {9, 9},
                {15, 18},
        };
        ArrayList<int[]> res = merge(arr);
        for (int[] a : res) {
                System.out.println(a[0] + "..." + a[1]);
        }
    }
}
