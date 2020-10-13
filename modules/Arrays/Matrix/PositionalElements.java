package Arrays.Matrix;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-number-of-positional-elements/
public class PositionalElements {

    public static void main(String[] args) {
        int[][] mat = {{1, 3, 4}, {5, 2, 9}, {8, 7, 6}};
        int[][] mat1 = {{1, 1}, {1, 1}, {1, 1}};

        System.out.println(countPositionalElements(mat));
        System.out.println(countPositionalElements(mat1));
    }

    /**
     * {
     *      {1, 3, 4},
     *      {5, 2, 9},
     *      {8, 7, 6}
     * }
     * minRow = [col 0, col 1, col 2]
     * maxRow = [col 2, col 2, col 0]
     *
     * minCol = [row 0, row 1, row 0]
     * maxCol = [row 2, row 2, row 1]
     * @param mat
     * @return
     */
    public static int countPositionalElements(int[][] mat) {
        if (mat.length == 0)
            return 0;
        int m = mat.length;
        int n = mat[0].length;

        int[] rowMin = new int[m];
        int[] rowMax = new int[m];
        int[] colMin = new int[n];
        int[] colMax = new int[n];

        for (int i = 0; i < m; i++) {
            int rowMinLocal = Integer.MAX_VALUE;
            int rowMaxLocal = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] < rowMinLocal) {
                    rowMinLocal = mat[i][j];
                }
                if (mat[i][j] > rowMaxLocal) {
                    rowMaxLocal = mat[i][j];
                }
            }
            rowMin[i] = rowMinLocal;
            rowMax[i] = rowMaxLocal;
        }

        for (int i = 0; i < n; i++) {
            int colMinLocal = Integer.MAX_VALUE;
            int colMaxLocal = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (mat[j][i] < colMinLocal) {
                    colMinLocal = mat[j][i];
                }
                if (mat[j][i] > colMaxLocal) {
                    colMaxLocal = mat[j][i];
                }
            }
            colMin[i] = colMinLocal;
            colMax[i] = colMaxLocal;
        }

        int positionalElemCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (
                        mat[i][j] == rowMin[i] ||
                        mat[i][j] == rowMax[i] ||
                        mat[i][j] == colMin[j] ||
                        mat[i][j] == colMax[j]

                ) {
                    positionalElemCount++;
                }
            }
        }
        return positionalElemCount;
    }
}
