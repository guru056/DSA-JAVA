package Utils;

public class MatrixUtils {

    public static void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++){
            ArrayUtils.printArr(mat[i]);
        }
    }

    public static void transposeOfSquareMatrix(int[][] mat){
        int N = mat.length;
        int temp;
        for (int i = 0 ; i < N - 1 ; i++){
            for (int j = i + 1; j < N ; j++){
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void reverseColumnsOfMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int temp;

        for (int i = 0 ; i < n ; i++){
            for (int j = 0; j < m /2 ; j++){
                temp = mat[j][i];
                mat[j][i] = mat[m - 1 - j][i];
                mat[m - 1 - j][i] = temp;
            }
        }
    }

    public static void reverseRowsOfMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int temp;

        for (int i = 0 ; i < m ; i++){
            for (int j = 0; j < n /2 ; j++){
                temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }
}
