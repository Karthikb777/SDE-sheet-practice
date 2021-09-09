package DSAprep;

import java.util.ArrayList;
import java.util.List;

/*
*       given a 2d matrix, print it's elements in a spiral form
*           steps:
*               print the boundaries of the matrix and shrink the boundaries
*           loop while ans.size() < size of matrix:
*               first print the top row and shrink the top pointer
*               then print the last column and shrink the right pointer
*               then print the last row and shrink the bottom pointer
*               then print the first column and then shrink the left pointer
*
*           finally return the answer
*
* */

public class SpiralMatrix {

    public static List<Integer> spiral(int[][] a) {
        List<Integer> ans = new ArrayList<>();

        int top, bottom, left, right;

        top = 0;
        bottom = a.length - 1;
        left = 0;
        right = a[0].length - 1;

        int size = a.length * a[0].length;

        while (ans.size() < size) {

//            print the top row
            for (int i = left; i <= right && ans.size() < size; i++) {
                ans.add(a[top][i]);
            }
            top++;

//            print the last column
            for (int i = top; i <= bottom && ans.size() < size; i++) {
                ans.add(a[i][right]);
            }
            right--;

//            print the last row
            for (int i = right; i >= left && ans.size() < size; i--) {
                ans.add(a[bottom][i]);
            }
            bottom--;

//            print the first column
            for (int i = bottom; i >= top && ans.size() < size; i--) {
                ans.add(a[i][left]);
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },

        };

        List<Integer> res = spiral(arr);
        for (int i:
             res) {
            System.out.print(i + " ");
        }
    }
}
