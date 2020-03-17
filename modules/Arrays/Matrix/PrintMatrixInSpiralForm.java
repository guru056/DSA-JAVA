package Arrays.Matrix;

public class PrintMatrixInSpiralForm {
//    https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
    public static void main(String[] args) {
        int mat[][] = {
                                { 1, 2, 3, 4, 5, 6 },
                                { 7, 8, 9, 10, 11, 12 },
                                { 13, 14, 15, 16, 17, 18 }
                    };
        printSpiral(mat);
        printSpiralRecursiveUtil(mat);
    }

    public static void printSpiral(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int row = 0;
        int col = 0;
        while (row < m && col < n){

            // Print the first row from the remaining rows
            for (int i = col; i < n; i++){
                System.out.print(mat[row][i] + " ");
            }
            row++;

            // Print the last column from the remaining columns
            for (int i = row; i < m ; i++){
                System.out.print(mat[i][n-1] + " ");
            }
            n--;

            // Print the last row from the remaining rows
            // if Last and First Row are not same */
            if (row < m){
                for (int i = n-1; i>=col; i--){
                    System.out.print(mat[m-1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining columns */
            // if Last and First Columns are not same */
            if (col < n){
                for (int i = m - 1; i >= row; i--){
                    System.out.print(mat[i][col] + " ");
                }
                col++;
            }
        }
        System.out.println();
    }

    public static void printSpiralRecursiveUtil(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        printSpiralRecursive(mat, 0 , 0 , m , n);

    }


    // Function for printing matrix in spiral
    // form row, col: Start index of matrix, row
    // and column respectively m, n: End index
    // of matrix row and column respectively
    public static void printSpiralRecursive(int[][] mat, int row, int col, int m, int n)
    {
        if (row >= m || col >= n){
            return;
        }

        //Print first row
        for (int i = col; i < n; i++){
            System.out.print(mat[row][i] + " ");
        }
        row++;

        //Print last column
        for (int i = row ; i < m; i++){
            System.out.print(mat[i][n-1] + " ");
        }
        n--;

        // Print the last row from the remaining rows
        // if Last and First Row are not same */
        if (row < m){
            for (int i = n-1; i>=col; i--){
                System.out.print(mat[m-1][i] + " ");
            }
        }
        m--;

        // Print the first column from the remaining columns */
        // if Last and First Columns are not same */
        if (col < n){
            for (int i = m - 1; i >= row; i--){
                System.out.print(mat[i][col] + " ");
            }
        }
        col++;

        printSpiralRecursive(mat, row, col, m, n );
    }
}
