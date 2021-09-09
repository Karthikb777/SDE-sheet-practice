package DSAprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
*       NQueens - LeetCode hard problem
*           given a no. n, in a chess board of size nxn, insert n queens such that:
*               1. every row must contain a queen
*               2. every column must contain a queen
*               3. no queen should clash with any other queen
*               (reminder: a queen can travel in all the 8 directions)
*
*           recursive solution: using hashing
*               base case: if the col number is equal to n, then all queens have been inserted,
*                           so, build the answer and return
*               try to insert a queen for every row in a given column
*                   while inserting, make sure to pass all the 3 conditions
*                   insert a queen and then call the recursive function again for the next column
*                   make sure to remove the queen added to facilitate for the next row
*
*               refer to the notes for the recursion tree and a detailed explanation
* */

public class D10Nqueens {

//    recursive method
    public static void recur(int col, int n, char[][] board,
                             List<List<String>> ans, int[] left, int[] topDiagonal, int[] bottomDiagonal) {
//        base case
        if (col == n) {
            ans.add(buildResult(board));
        }

//        try to insert a queen at every row in a column
        for (int row = 0; row < n; row++) {

//            conditions for checking if a queen attacks another queen
            if (left[row] == 0 && topDiagonal[n - 1 + col - row] == 0 && bottomDiagonal[row + col] == 0) {

//                mark all the directions as inserted
                left[row] = 1;
                topDiagonal[n - 1 + col - row] = 1;
                bottomDiagonal[row + col] = 1;

//                add the queen to the board
                board[row][col] = 'Q';

//                call the recursive function
                recur(col + 1, n, board, ans, left, topDiagonal, bottomDiagonal);

//                make sure to remove the queen added
                board[row][col] = '.';
                left[row] = 0;
                topDiagonal[n - 1 + col - row] = 0;
                bottomDiagonal[row + col] = 0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
//        preparing the board
        char[][] board = new char[n][n];

//        fill the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

//        answer list
        List<List<String>> ans = new ArrayList<>();

//        arrays to keep track of queens
        int[] left = new int[n];
        int[] topDiagonal = new int[(2*n) - 1];
        int[] bottomDiagonal = new int[(2*n) - 1];

//        call the recursive function
        recur(0, n, board, ans, left, topDiagonal, bottomDiagonal);

        return ans;
    }

//    method to convert the char array board into a List<String>
    public static List<String> buildResult(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<String>> ans = solveNQueens(n);

        System.out.println("the different ways to place the queens are:");
        for (List<String> row: ans) {
            for (String pos: row) {
                for (int i = 0; i < pos.length(); i++) {
                    System.out.print(pos.charAt(i) + " ");
                }
                    System.out.println();
            }
            System.out.println();
        }
    }
}
