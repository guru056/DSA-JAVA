package Arrays.Matrix;

//https://www.geeksforgeeks.org/maximum-difference-sum-elements-two-rows-matrix/
// Variation of modules/Arrays/Misc/StockBuyAndSell.java@getMaxProfitForSingleTransactionV3
//Variation of https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
public class MaximumRowDifference {

    public static void main(String[] args) {
        int[][] mat = {{-1, 2, 3, 4},
                {5, 3, -2, 1},
                {6, 7, 2, -3},
                {2, 9, 1, 4},
                {2, 1, -2, 0}};
        System.out.println(maxRowDiff(mat));
    }

    /**
     * Given a matrix of m*n order, the task is to find the maximum difference
     * between two rows Rj and Ri such that i < j, i.e.,
     * we need to find maximum value of sum(Rj) – sum(Ri) such that row i is above row j.
     *
     * Examples:
     * Input : mat[5][4] = {{-1, 2, 3, 4},
     *                      {5, 3, -2, 1},
     *                      {6, 7, 2, -3},
     *                      {2, 9, 1, 4},
     *                      {2, 1, -2, 0}}
     * Output: 9
     * // difference of R3 - R1 is maximum
     *
     * @param mat
     * @return
     */
    public static int maxRowDiff(int[][] mat)
    {
        int m = mat.length;
        if (m == 0)
            return 0;
        int n = mat[0].length;

        int maxDiff = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0 ; j < n; j++) {
                sum += mat[i][j];
            }
            if (sum < minSum) {
                minSum = sum;
            } else {
                maxDiff = Math.max(maxDiff, sum-minSum);
            }
        }
        return maxDiff;
    }
}
