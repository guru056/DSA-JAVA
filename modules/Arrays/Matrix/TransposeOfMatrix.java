package Arrays.Matrix;

import Utils.MatrixUtils;

public class TransposeOfMatrix {
//    https://www.geeksforgeeks.org/program-to-find-transpose-of-a-matrix/

    public static void main(String[] args) {
        int[][] mat = {
                            {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}
                        };
        printTransposeOfSquareMatrix(mat);

        int[][] matRect = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        printTransposeOfRectangularMatrix(matRect);
    }

    //square matrix
    public static void printTransposeOfSquareMatrix(int[][] mat){
        int N = mat.length;
        int temp;
        for (int i = 0 ; i < N - 1 ; i++){
            for (int j = i + 1; j < N ; j++){
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        MatrixUtils.printMatrix(mat);
    }

    public static void printTransposeOfRectangularMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int[][] transpose = new int[n][m];

        for (int i = 0 ; i < n ; i++){
            for (int j = 0; j < m ; j++){
                transpose[i][j] = mat[j][i];
            }
        }
        MatrixUtils.printMatrix(transpose);
    }
}
