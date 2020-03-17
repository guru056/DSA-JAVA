package Arrays.Matrix;

import Utils.MatrixUtils;

public class InPlaceRotationBy180Degrees {

//    https://www.geeksforgeeks.org/rotate-matrix-180-degree/
    public static void main(String[] args) {
        int mat[][] = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                    };
        rotateBy180Degrees(mat);
        MatrixUtils.printMatrix(mat);
    }

    //swap rows and then reverse elements of each row
    public static void rotateBy180Degrees(int[][] mat)
    {
        int N = mat.length;
        int temp;

        for (int i = 0 ; i < N / 2; i++){
            for (int j = 0; j < N; j++){
                temp = mat[i][j];
                mat[i][j] = mat[N - 1 -i][N - 1 - j] ;
                mat[N - 1 -i][N - 1 - j] = temp;
            }
        }

    }
}
