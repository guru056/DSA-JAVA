package DynamicProgramming;

import Utils.MatrixUtils;

//https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
public class LongestIncreasingPathInMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 9},
                {5, 1, 8},
                {4, 6, 7}};
        System.out.println(getLongestIncreasingPathLength(mat));
    }

    /**
     * Given a n*n matrix where all numbers are distinct,
     * find the maximum length path (starting from any cell)
     * such that all cells along the path are in increasing order with a difference of 1.
     *
     * We can move in 4 directions from a given cell (i, j), i.e.,
     * we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1)
     * with the condition that the adjacent cells have a difference of 1.
     *
     *
     * @param mat
     * @return
     */
    //visited array is not necessary here as dp[i][j] will return the result if visited again
    public static int getLongestIncreasingPathLength(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int maxLength = 0;
        for (int i = 0 ; i < mat.length; i++) {
            for (int j = 0 ; j < mat[i].length; j++) {
                if (dp[i][j] == 0) {
                    maxLength = Math.max(maxLength, getLongestPathForGivenPosition(mat,visited,dp,i,j));
                }
            }
        }
        MatrixUtils.printMatrix(dp);
        return maxLength;
    }

    public static int getLongestPathForGivenPosition(int[][] mat, boolean[][] visited, int[][] dp, int i, int j)
    {
        if (!areCoordinatesValid(mat, visited, i, j))
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        visited[i][j] = true;

        int left =0, right = 0, top = 0, bottom =  0;
        //left
        if (areCoordinatesValid(mat,visited, i, j-1) && (mat[i][j] - mat[i][j-1]) == 1) {
            left = getLongestPathForGivenPosition(mat, visited, dp, i, j-1);
        }

        //right
        if (areCoordinatesValid(mat,visited, i, j+1) && (mat[i][j] - mat[i][j+1]) == 1) {
            right = getLongestPathForGivenPosition(mat, visited, dp, i, j+1);
        }

        //top
        if (areCoordinatesValid(mat,visited, i-1, j) && (mat[i][j] - mat[i-1][j]) == 1) {
            top = getLongestPathForGivenPosition(mat, visited, dp, i-1, j);
        }

        //bottom
        if (areCoordinatesValid(mat,visited, i+1, j) && (mat[i][j] - mat[i+1][j]) == 1) {
            bottom = getLongestPathForGivenPosition(mat, visited, dp, i+1, j);
        }

        dp[i][j] = 1 + Math.max(
                Math.max(left,right),
                Math.max(top,bottom)
            );
        return dp[i][j];
    }

    private static boolean areCoordinatesValid(int[][] mat, boolean[][] visited, int i, int j)
    {
        return ( i >= 0 && i < mat.length && j >= 0 && j < mat[i].length && visited[i][j] == false);
    }
}
