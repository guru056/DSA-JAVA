package Arrays.Matrix;

import Utils.MatrixUtils;

public class RotateBy90Degrees {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotateBy90Degrees(mat);
        rotateBy90DegreesSet2(mat);
//        rightRotateBy90Degrees(mat);
    }

//    https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
    public static void rotateBy90Degrees(int[][] mat){
        int N = mat.length;
        int temp;

        for (int i = 0 ; i < N/2; i++){
            for (int j = i; j < N - 1 - i; j++){
                temp = mat[i][j];
                mat[i][j] = mat[j][N - 1 - i];
                mat[j][N - 1 - i] = mat[N - 1 - i][N - 1 - j];
                mat[N - 1 - i][N - 1 - j] = mat[N - 1 - j][i];
                mat[N - 1 - j][i] = temp;
            }
        }

        MatrixUtils.printMatrix(mat);
    }

//    https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
    public static void rotateBy90DegreesSet2(int[][] mat){
        MatrixUtils.transposeOfSquareMatrix(mat);
        MatrixUtils.reverseColumnsOfMatrix(mat);
        MatrixUtils.printMatrix(mat);
    }

    public static void rightRotateBy90Degrees(int[][] mat){
        MatrixUtils.transposeOfSquareMatrix(mat);
        MatrixUtils.reverseRowsOfMatrix(mat);
        MatrixUtils.printMatrix(mat);
    }


}
