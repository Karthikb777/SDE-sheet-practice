package DSAprep;

import java.util.Arrays;

/*
*       given a nxn matrix, if an element is 0, set it's entire row and column to zero. do it in place.
* */
public class D2SetMatrixZeros {
//    optimized
    public static void method2(int[][] matrix) {
        int size = matrix.length;
        int[] row = new int[size];
        int[] col = new int[size];
        Arrays.fill(row, 1);
        Arrays.fill(col, 1);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(row[i] == 0 || col[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

//    further optimized
    public static void method3(int[][] matrix) {
//        TODO
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
        };
        System.out.println("before setting zeros");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        method2(matrix);

        System.out.println("after setting zeros");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
