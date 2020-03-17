package Arrays.Matrix;

import Utils.MatrixUtils;

public class RotateMatrixElementsClockwise {

//    https://www.geeksforgeeks.org/rotate-matrix-elements/
    public static void main(String[] args) {
        int mat[][] = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 }
        };
        rotateClockwise(mat);
        MatrixUtils.printMatrix(mat);
    }


    public static void rotateClockwise(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        int row = 0;
        int col = 0;
        int prev ;
        int curr;
        while (row < m && col < n){

            //break if first row and last row are same or first column and last column are same
            //while printing spiral matrix the condition is row >=m || col >= n because in that case we need to iterate the last row/column also to print
            if (row >= m  - 1 || col  >= n - 1)
                break;

            prev = mat[row + 1][col];

            for (int i = col; i < n; i++){
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            for (int i = row; i < m ; i++){
                curr = mat[i][n-1];
                mat[i][n-1] = prev;
                prev = curr;
            }
            n--;

            if (row < m){
                for (int i = n-1; i>=col; i--){
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            if (col < n){
                for (int i = m - 1; i >= row; i--){
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }
    }
}
