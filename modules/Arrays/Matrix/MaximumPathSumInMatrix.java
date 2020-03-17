package Arrays.Matrix;

public class MaximumPathSumInMatrix {

//    https://www.geeksforgeeks.org/maximum-path-sum-matrix/
    public static void main(String[] args) {
        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
        };
        System.out.println(maximumPathSumUtil(mat));
        System.out.println(maximumPathSumIterative(mat));
    }

    public static int maximumPathSumUtil(int[][] mat){
        return maximumPathSumRecursive(mat, 0, 0, mat.length, mat[0].length);
    }

    public static int maximumPathSumRecursive(int[][] mat, int i , int j ,int m , int n )
    {
        if (i > m - 1 || j > n - 1 )
            return 0;
        if (i == m - 1 )
            return mat[i][j];

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;

        if (i + 1 < m && j - 1 >=0 )
            sum1 = mat[i][j] + maximumPathSumRecursive(mat, i +1, j - 1, m, n);
        if (i + 1 < m  )
            sum2 = mat[i][j] + maximumPathSumRecursive(mat, i +1, j, m, n);
        if (i + 1 < m && j + 1 < n )
            sum3 = mat[i][j] + maximumPathSumRecursive(mat, i +1, j + 1, m, n);
        if (i == 0)
            sum4 = maximumPathSumRecursive(mat, i , j + 1 , m , n );

        return Math.max(Math.max(sum1,sum2),Math.max(sum3,sum4));
    }

    public static int maximumPathSumIterative(int[][] mat)
    {
        // To find max val in first row
        int res = -1;
        int m = mat.length;
        int n = mat[0].length;

        //this is for case when there is only one row.
        for (int i = 0; i < n; i++)
            res = Math.max(res, mat[0][i]);

        for (int i = 1; i < m; i++)
        {
            res = -1;
            for (int j = 0; j < n; j++)
            {
                // When all paths are possible
                if (j > 0 && j < n - 1)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            Math.max(mat[i - 1][j - 1],
                                    mat[i - 1][j + 1]));

                    // When diagonal right is not possible
                else if (j > 0)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            mat[i - 1][j - 1]);

                    // When diagonal left is not possible
                else if (j < n - 1)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            mat[i - 1][j + 1]);

                // Store max path sum
                res = Math.max(mat[i][j], res);
            }
        }
        return res;
    }
}
