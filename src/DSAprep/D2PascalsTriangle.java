package DSAprep;

import java.util.ArrayList;
import java.util.List;

public class D2PascalsTriangle {
    /*
    * problem type 1: print the pascal's triangle for the given number of rows.
    * explanation:
    *       we initialize a new list to store the pascal's triangle, and 2 variables called pre and row to null
    *       we iterate numRows times and for every row to be added, we do the following
    *       we iterate j<=i times, if j is equal to 0 or i, we set value at index j as 1
    *       else we set the value at index j as the sum of the pre array's 2 elements as per the pascal's triangle law
    *       after a row has been completed, we set pre to row and add pre to the pascal's triangle.
    *
    *       TC O(n^2), SC O(n^2)
    * */
    public static void method1(int numRows) {
        List<List<Integer>> pt = new ArrayList<>();
        List<Integer> row, pre = null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
                pre = row;
                pt.add(row);
        }

        for (List<Integer> a : pt) {
            for (int i: a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*
    *   problem type 2:
    *       given a row index and a col index, return the value at the pascal's triangle at the specified row and col index.
    *   explanation:
    *       we can use the formula for combination i.e nCr to calculate the value
    *
    *   TC O(n), SC O(1)
    * */
    public int method2(int row, int col) {
        return 0;
    }

    /*
    *   problem type 3:
    *       given a row number, print the pascal's triangle in that row
    *   explanation:
    *       we can use the formula for combination i.e nCr to print the row of the pascal's triangle
    *
    *   TC O(n) SC O(n)
    * */
    public int method3(int row) {
        return 0;
    }

    public static void main(String[] args) {
        method1(7);
    }
}
