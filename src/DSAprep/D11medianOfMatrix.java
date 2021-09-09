package DSAprep;

/*
*       median of a row wise sorted matrix:
*           brute force method:
*               add all the elements of the matrix into a list
*               sort the list
*               return the middle element
*           TC - O(nxm) for adding all the elements to the list
*              + O(nxm log(nxm)) for sorting
*           SC - O(nxm) to hold all the matrix elements
*
*           optimal method:
*               using binary search
*                   find the number of elements LTE to mid, based on that, adjust the search space
*
*                   take low = 1, high = integer's max value
*                   while low doesn't cross mid
*                       calculate mid
*                       find out how many elements in the matrix is LTE than mid = count
*                       if count <= nm/2, move the low pointer to mid + 1
*                       else move the high pointer to mid - 1
*                   return low
*
*               TC - log(2^32) because of the search space x n for finding out the no. of elements LTE in all rows
*               x log(m) for another binary search to find no. lTE in all rows
*               TC - log(2^32) n log(m)
*
*               SC - O(1)
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D11medianOfMatrix {
//    brute force method
    public static int bruteForce(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        for (int[] row: matrix) {
            for (int ele : row) {
                list.add(ele);
            }
        }

        Collections.sort(list);

        return list.get(list.size() / 2);
    }

//    performing binary search on the individual rows to find the no. of elements LTE to the number m
    public static int noOfeleLTE(int[] row, int m) {
        int low = 0, high = row.length - 1;
        int mid = 0;

        while(low <= high) {
            mid = (low + high) / 2;
            if (row[mid] <= m) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

//    optimal method using binary search
    public static int optimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int high, low, mid;
        low = 1;
        high = Integer.MAX_VALUE;

        while (low <= high) {
            mid = (low + high) / 2;

//            find the number of elements LTE to mid in the matrix
            int count = 0;
            for (int[] row : matrix) {
                count += noOfeleLTE(row, mid);
            }

//            if the number of elements is less LTE nm/2, move low to mid + 1
            if (count <= (n*m)/2) {
                low = mid + 1;
            }
//            else move high to mid - 1
            else high = mid - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 6},
                {2, 6, 9},
                {3, 6, 9},
        };

        System.out.println(optimal(mat));
    }
}
