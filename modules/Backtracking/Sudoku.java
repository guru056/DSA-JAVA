package Backtracking;

import Utils.MatrixUtils;

//https://www.geeksforgeeks.org/sudoku-backtracking-7/
public class Sudoku {
    final static int BOARD_SIZE = 9;
    final static int MIN_VAL = 1;
    final static int MAX_VAL = 9;

    public static void main(String[] args) {
        int[][] matrix = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        System.out.println(solveSudoku(matrix));
        MatrixUtils.printMatrix(matrix);
    }

    /**
     * Time complexity: O(9^(n*n)).
     * For every unassigned index, there are 9 possible options so the time complexity is O(9^(n*n)). The time complexity remains the same but there will be some early pruning so the time taken will be much less than the naive algorithm but the upper bound time complexity remains the same.
     * Space Complexity: O(n*n).
     * To store the output array a matrix is needed.
     * @param matrix
     * @return
     */
    public static boolean solveSudoku(int[][] matrix) {
        int row = -1;
        int col = -1;
        boolean emptySpacesPresent = false;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (matrix[i][j] > 0)
                    continue;
                row = i;
                col = j;
                emptySpacesPresent = true;
                break;
            }
            if (emptySpacesPresent)
                break;
        }
        if (!emptySpacesPresent)
            return true;

        for (int i = MIN_VAL; i <= MAX_VAL; i++) {
            if (isSafeConfig(matrix, row, col, i)) {
                matrix[row][col] = i;
                if (solveSudoku(matrix)) {
                    return true;
                } else {
                    matrix[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafeConfig(int[][] matrix, int row, int col, int val) {
        //check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (matrix[row][i] == val)
                return false;
        }

        //check cols
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (matrix[i][col] == val)
                return false;
        }

        //check 3x3 square
        int sqrt = (int)Math.sqrt(BOARD_SIZE);
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;
        for (int i = startRow; i < startRow + sqrt; i++) {
            for (int j = startCol; j < startCol + sqrt; j++) {
                if (matrix[i][j] == val)
                    return false;
            }
        }
        return true;
    }
}
