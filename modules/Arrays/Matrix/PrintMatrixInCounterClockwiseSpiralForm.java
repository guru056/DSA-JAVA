package Arrays.Matrix;

public class PrintMatrixInCounterClockwiseSpiralForm {

//    https://www.geeksforgeeks.org/print-given-matrix-counter-clock-wise-spiral-form/
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printCounterClockwiseSpiral(mat);

        int mat1[][] = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 }
        };

        printCounterClockwiseSpiral(mat1);

    }

    public static void printCounterClockwiseSpiral(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int row = 0;
        int col = 0;
        while (row < m && col < n){

            // Print the first row from the remaining rows
            for (int i = row; i < m; i++){
                System.out.print(mat[i][col] + " ");
            }
            col++;

            // Print the last column from the remaining columns
            for (int i = col; i < n ; i++){
                System.out.print(mat[m-1][i] + " ");
            }
            m--;

            // Print the last row from the remaining rows
            // if Last and First Row are not same */
            if (col < n){
                for (int i = m-1; i>=row; i--){
                    System.out.print(mat[i][n-1] + " ");
                }
            }
            n--;

            // Print the first column from the remaining columns */
            // if Last and First Columns are not same */
            if (row < m){
                for (int i = n - 1; i >= col; i--){
                    System.out.print(mat[row][i] + " ");
                }
            }
            row++;
        }
        System.out.println();
    }
}
