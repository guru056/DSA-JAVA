package Graph;

//https://www.geeksforgeeks.org/find-number-of-islands/
public class NumberOfIslands {

    static int[] x = {-1,-1,-1,0,0,1,1,1};
    static int[] y = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) {
        int[][] mat =
                {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        System.out.println(getNumberOfIslands(mat));
    }

    public static void alterAdjacentIslandsRecursively(int[][] mat, int i, int j)
    {
        if (!areValidCoordinates(mat,i, j))
            return;

        mat[i][j] = 0;
        for (int k = 0 ; k < x.length; k++) {
            if (areValidCoordinates(mat, i+x[k], j + y[k])){
                alterAdjacentIslandsRecursively(mat, i+x[k], j + y[k]);
            }
        }
    }

    public static int getNumberOfIslands(int[][] mat)
    {
        int m  = mat.length;
        int n = mat[0].length;
        int isLandCount = 0;
        for (int i = 0 ; i < m; i++){
            for (int j = 0 ; j < n; j++){
                if (mat[i][j] == 1){
                    isLandCount++;
                    alterAdjacentIslandsRecursively(mat,i,j);
                }
            }
        }
        return isLandCount;
    }

    private static boolean areValidCoordinates(int[][] mat, int i, int j)
    {
        return ( i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == 1);
    }
}
