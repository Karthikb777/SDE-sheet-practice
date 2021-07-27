package DSAprep;

/*
*   given a 2d matrix representing an image, rotate by 90deg (clockwise), do it in place.
* */
public class D2RotateMatrix {
    public static void method1(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int[][] cpy = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = cpy[colSize - 1 - j][rowSize - 1 - i];
            }
        }
        matrix = cpy;
    }

    public static void method2(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
//        TODO
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        System.out.println("before rotation");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        method2(matrix);
        System.out.println("after rotation");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
