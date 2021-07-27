package DSAprep;

/*
*       problem type 1: the rows are sorted.
*       problem type 2: both the rows and columns are sorted.
* */

public class D3Search2DArray {
//    brute force method: perform a linear search
//    TC O(nxm), SC O(1)
    public static boolean method1(int[][] m, int query) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == query) return true;
            }
        }
        return false;
    }

//    optimized: perform a binary search on all rows
//    TC O(nlogm), SC O(1)
    public static boolean method2(int[][] m, int query) {
        int low, high, mid;

        for (int[] row : m) {
            low = 0;
            high = row.length - 1;
            while(low <= high) {
                mid = (low + high) / 2;
                if(row[mid] == query) return true;
                if (row[mid] < query) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }

//    further optimized:
    /*
    *       place a pointer at the last element of the first row.
    *       if the element is equal to the search query, return true.
    *       if the element is less than the search query, move the pointer one step to the left.
    *       if the pointer is greater than the search query, move the pointer one step to the right.
    * */
    public static boolean method3(int[][] m, int query) {
        int col = m[0].length;
        int i = 0, j = col - 1;
        int pointer = m[i][j];

//        while() {
//            TODO
//        }
        return false;
    }

//    most optimized: perform binary search on the matrix
//    TODO

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 6},
                {8, 9, 10 ,12},
                {15, 18 ,21, 24}
        };
        if (method2(arr, 11)) System.out.println("element found");
        else System.out.println("element not found");
    }
}
