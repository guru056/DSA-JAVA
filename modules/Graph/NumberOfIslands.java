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
    public static void alterAdjacentIslandsRecursively(int[][] mat, boolean[][] visited, int i, int j)
    {
        if (!areValidCoordinates(mat, visited,i, j))
            return;

        mat[i][j] = 0;
        visited[i][j] = true;
        for (int k = 0 ; k < x.length; k++) {
            if (areValidCoordinates(mat, visited, i+x[k], j + y[k])){
                alterAdjacentIslandsRecursively(mat,visited, i+x[k], j + y[k]);
            }
        }
//        if (areValidCoordinates(mat, visited, i-1,j)){
//            alterAdjacentIslandsRecursively(mat,visited, i-1, j);
//        }
//        if (areValidCoordinates(mat, visited, i-1,j-1)){
//            alterAdjacentIslandsRecursively(mat,visited, i-1, j-1);
//        }
//        if (areValidCoordinates(mat, visited, i-1,j+1)){
//            alterAdjacentIslandsRecursively(mat,visited, i-1, j+1);
//        }
//        if (areValidCoordinates(mat, visited, i,j-1)){
//            alterAdjacentIslandsRecursively(mat,visited, i, j-1);
//        }
//        if (areValidCoordinates(mat, visited, i,j+1)){
//            alterAdjacentIslandsRecursively(mat,visited, i, j+1);
//        }
//        if (areValidCoordinates(mat, visited, i+1,j)){
//            alterAdjacentIslandsRecursively(mat,visited, i+1, j);
//        }
//        if (areValidCoordinates(mat, visited, i+1,j-1)){
//            alterAdjacentIslandsRecursively(mat,visited, i+1, j-1);
//        }
//        if (areValidCoordinates(mat, visited, i+1,j+1)){
//            alterAdjacentIslandsRecursively(mat,visited, i+1, j+1);
//        }
    }

    public static int getNumberOfIslands(int[][] mat)
    {
        int m  = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int isLandCount = 0;
        for (int i = 0 ; i < m; i++){
            for (int j = 0 ; j < n; j++){
                if (mat[i][j] == 1){
                    isLandCount++;
                    alterAdjacentIslandsRecursively(mat,visited,i,j);
                }
            }
        }
        return isLandCount;
    }

    private static boolean areValidCoordinates(int[][] mat, boolean[][] visited, int i, int j)
    {
        int m = mat.length;
        int n = mat[0].length;

        return ( i >= 0 && i < m && j >= 0 && j < n && mat[i][j] == 1 && visited[i][j] == false);
    }
}
