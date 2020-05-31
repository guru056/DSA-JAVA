package DynamicProgramming;

public class MinCostPath {

    public static void main(String[] args) {
        int[][] cost = { {1, 8, 8, 1, 5},
                {4, 1, 1, 8, 1},
                {4, 2, 8, 8, 1},
                {1, 5, 8, 8, 1} };
        int[][] cost1 = {  {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
        System.out.println(minCost(cost));
        System.out.println(minCost(cost1));
    }

    public static int minCost(int[][] cost)
    {
        int m = cost.length;
        int n = cost[0].length;
        for (int i = 1; i < m; i++) {
            cost[i][0] += cost[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            cost[0][i] += cost[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cost[i][j] += Math.min(
                                    cost[i-1][j-1],
                                    Math.min(
                                                cost[i][j-1],
                                                cost[i-1][j]
                                    )
                            );
            }
        }
        return cost[m-1][n-1];
    }
}
