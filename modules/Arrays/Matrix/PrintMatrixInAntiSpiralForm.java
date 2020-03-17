package Arrays.Matrix;

import java.util.Stack;

public class PrintMatrixInAntiSpiralForm {

//    https://www.geeksforgeeks.org/print-matrix-antispiral-form/
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printAntiSpiral(mat);

        int mat1[][] = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 }
        };

        printAntiSpiral(mat1);
    }


    public static void printAntiSpiral(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        int row = 0;
        int col = 0;
        Stack<Integer> st = new Stack<Integer>();
        while (row < m && col < n){

            // Print the first row from the remaining rows
            for (int i = col; i < n; i++){
               st.push(mat[row][i]);
            }
            row++;

            // Print the last column from the remaining columns
            for (int i = row; i < m ; i++){
                st.push(mat[i][n-1]);
            }
            n--;

            // Print the last row from the remaining rows
            // if Last and First Row are not same */
            if (row < m){
                for (int i = n-1; i>=col; i--){
                    st.push(mat[m-1][i]);
                }
                m--;
            }

            // Print the first column from the remaining columns */
            // if Last and First Columns are not same */
            if (col < n){
                for (int i = m - 1; i >= row; i--){
                    st.push(mat[i][col]);
                }
                col++;
            }
        }
        while (!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
}
