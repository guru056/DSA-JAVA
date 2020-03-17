package Arrays.Matrix;

public class DiagonalTraversalOfMatrix {

//    https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
                {17,18,19,20}
        };
        printDiagonalTraversal(mat);
    }

    public static void printDiagonalTraversal(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0 ; i < m; i++){
            int row = i;
            int col = 0;

            while (row >=0 && col < n ){
                System.out.print(mat[row][col] + " ");
                row--;
                col++;
            }
            System.out.println();
        }

        for (int i = 1 ; i < n; i++){
            int row = m - 1;
            int col = i;

            while (row >=0 && col < n ){
                System.out.print(mat[row][col] + " ");
                row--;
                col++;
            }
            System.out.println();
        }
    }
}
