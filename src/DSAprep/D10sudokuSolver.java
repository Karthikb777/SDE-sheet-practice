package DSAprep;

/*
*       sudoku solver:
*           recursive method:
*               take 2 for loops, iterate over every cell
*                   if we find an empty cell
*                       start looping from i = 1 to 9 and try inserting i to that cell by checking if
*                       we can insert it
*                           if we can, insert it to the cell
*                           call recur, if it returns true, we got a solution, so return true
*                           else, remove the added number to facilitate for the next number
*                       if we found an empty cell but couldn't fill it, then we couldn't solve the sudoku, so return false
*              if we iterated all cells and found no empty ones, then the board is already solved, so return true
*
*           isValid method:
*               run a for loop 9 times
*                   check if the num exists in the row, if yes, return false
*                   check if the num exists in the col, if yes, return false
*                   check if the num exists in the sub matrix of 3x3, if yes, return false
*               finally return true
*
*                   formula to check for sub-matrix =
*                       [3 * (row/3) + i / 3][3 * (col/3) + i % 3]
*                   do a dry run to get the idea of the above formula
* */


public class D10sudokuSolver {

    public static boolean solve(char[][] sudoku) {
//        start from the cell (0, 0) and iterate over every cell
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
//                check for an empty space
                if (sudoku[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(sudoku, k, i, j)) {
                            sudoku[i][j] = k;
//                            call the recursive method, if it returns true, then we got one answer, so return true
                            if(solve(sudoku)) return true;
//                            make sure to remove the added number to facilitate for the next iteration
                            else sudoku[i][j] = '.';
                        }
                    }
//                    we tried all the numbers and couldn't fill the cell, so return false
                    return false;
                }
            }
        }
//        if we made it this far, we can say that the sudoku is already solved
//        so return true
        return true;
    }

    private static boolean isValid(char[][] sudoku, char num, int row, int col) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][col] != '.' && sudoku[i][col] == num) return false;
            if (sudoku[row][i] != '.' && sudoku[row][i] == num) return false;
            if (sudoku[3 * (row/3) + i / 3][3 * (col/3) + i % 3] != '.' &&
                    sudoku[3 * (row/3) + i / 3][3 * (col/3) + i % 3] == num) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = {
                {'5', '3', '.', '6', '7', '8', '9', '.', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'.', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '.', '4', '8', '5', '6'},
                {'9', '6', '.', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'},
        };

        System.out.println("can it be solved? " + solve(sudoku));
        System.out.println("solved board:");

        for (char[] row: sudoku) {
            System.out.print("\t");
            for (char i : row) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }

    }
}
