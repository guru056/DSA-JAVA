package Arrays.Matrix;

public class ZigzagTraversalOfMatrix {

//    https://www.geeksforgeeks.org/print-given-matrix-zigzag-form/
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };
        printZigzagTraversal(mat);
    }

    public static void printZigzagTraversal(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;
        boolean reverse = false;

        for (int i = 0; i < m ; i++){
            if (reverse == false){
                for (int j = 0 ; j < n; j++){
                    System.out.print(mat[i][j] + " ");
                }
                reverse = true;
            } else{
                for (int j = 0 ; j < n; j++){
                    System.out.print(mat[i][n - 1 - j] + " ");
                }
                reverse = false;
            }
        }
    }
}
