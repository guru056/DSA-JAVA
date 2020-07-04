package Arrays.Matrix;

import Utils.MatrixUtils;

//https://leetcode.com/problems/set-matrix-zeroes/
//Similar to above : https://www.geeksforgeeks.org/a-boolean-matrix-question/
public class BooleanMatrixPuzzle {


    public static void main(String[] args) {
        int[][] mat = {
                        {0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}
                    };
        int[][] mat1 = {
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                     };

        MatrixUtils.printMatrix(mat);
        System.out.println();
        setMatrixZeroesV3(mat);
        System.out.println();
        MatrixUtils.printMatrix(mat);
        System.out.println();

        MatrixUtils.printMatrix(mat1);
        System.out.println();
        setMatrixZeroesV3(mat1);
        System.out.println();
        MatrixUtils.printMatrix(mat1);
        System.out.println();

    }

    public static void setMatrixZeroes(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        int maxVal = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (mat[i][j] > maxVal)
                    maxVal = mat[i][j];
            }
        }
        maxVal += 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    setZeroesForElement(mat, i, j, maxVal);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == maxVal) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    private static void setZeroesForElement(int[][] mat, int i, int j, int maxVal)
    {
        //setting rows
        for (int k = 0; k < mat.length; k++) {
            if (mat[k][j] != 0)
                mat[k][j] = maxVal;
        }

        //setting columns
        for (int k = 0; k < mat[i].length; k++) {
            if (mat[i][k] != 0)
                mat[i][k] = maxVal;
        }
    }





    public static void setMatrixZeroesV2(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++){
                if (mat[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++){
                if (row[i] == 1 || col[j] == 1){
                    mat[i][j] = 0;
                }
            }
        }
    }


    public static void setMatrixZeroesV3(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        boolean changeFirstRow = false;
        boolean changeFirstColumn = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++){

                if (mat[i][j] == 0){
                    if (i == 0)
                        changeFirstRow = true;
                    if (j == 0)
                        changeFirstColumn = true;
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1 ; j < n; j++){
                if (mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }
        if (changeFirstRow){
            for (int i = 0 ; i < n; i++) {
                mat[0][i] = 0;
            }
        }
        if (changeFirstColumn) {
            for (int i = 0 ; i < m; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
