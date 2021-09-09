package com.karthik.cp;// Java program to print a given matrix in spiral form
import java.io.*;


class spiralMatrix {

    // Function print matrix in spiral form
    static void spiralPrint(int down, int right, int a[][])
    {
        int i, left = 0, top = 0;

		/* left - starting row index
		down - ending row index
		top - starting column index
		right - ending column index
		i - iterator
		*/

        while (left < down && top < right) {
            // Print the first row from the remaining rows
            for (i = top; i < right; ++i) {
                System.out.print(a[left][i] + " ");
            }
            left++;

            // Print the last column from the remaining
            // columns
            for (i = left; i < down; ++i) {
                System.out.print(a[i][right - 1] + " ");
            }
            right--;

            // Print the last row from the remaining rows */
            if (left < down) {
                for (i = right - 1; i >= top; --i) {
                    System.out.print(a[down - 1][i] + " ");
                }
                down--;
            }

            // Print the first column from the remaining
            // columns */
            if (top < right) {
                for (i = down - 1; i >= left; --i) {
                    System.out.print(a[i][top] + " ");
                }
                top++;
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int R = 3;
        int C = 3;
        int a[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        // Function Call
        spiralPrint(R, C, a);
    }
}

// Contributed by Pramod Kumar
