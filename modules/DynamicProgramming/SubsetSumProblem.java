package DynamicProgramming;

import Utils.MatrixUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/subset-sum-problem-osum-space/
//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
//@todo https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
public class SubsetSumProblem {
    static List<List<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        int arr1[] = {3,4,5,2};
        int sum1 = 7;


        System.out.println(hasSubsetSumRecursiveDP(arr1, sum1));
        System.out.println(resultList);

//
//
//        System.out.println(hasSubsetWithSum(arr, sum));
//        System.out.println(hasSubsetSumRecursiveDP(arr, sum));
//        System.out.println(hasSubsetSumRecursiveDPV2(arr, sum));
//        System.out.println(hasSubsetSumRecursiveDPV3(arr, sum));
//
//        System.out.println(hasSubsetWithSum(arr1, sum1));
//        System.out.println(hasSubsetSumRecursiveDP(arr1, sum1));
//        System.out.println(hasSubsetSumRecursiveDPV2(arr1, sum1));
//        System.out.println(hasSubsetSumRecursiveDPV3(arr1, sum1));
    }

    public static boolean hasSubsetWithSum(int[] arr, int sum)
    {
        return hasSubsetWithSumRecursive(arr, arr.length, sum);
    }

    /**
     * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
     * Output: True
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    public static boolean hasSubsetWithSumRecursive(int[] arr, int n, int sum)
    {
        if (n == 0 && sum != 0)
            return false;
        if (sum < 0)
            return false;

        if (sum == 0)
            return true;

        return hasSubsetWithSumRecursive(arr, n-1, sum) ||
                hasSubsetWithSumRecursive(arr, n-1, sum-arr[n-1]);
    }

    public static boolean hasSubsetSumRecursiveDP(int[] set, int sum)
    {
        int n = set.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for (int i = 0 ; i < set.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean include = j - set[i-1] < 0 ? false : dp[i-1][j-set[i-1]];
                boolean exclude = dp[i-1][j];
                dp[i][j] = include || exclude;
            }
        }
        for (int i = 0 ; i < dp.length; i++)
            System.out.println(Arrays.toString(dp[i]));
        List<Integer> l = new ArrayList<>();
        printAllSubArrays(set, n-1,sum, dp,l);
        return dp[n][sum];
    }


    public static boolean hasSubsetSumRecursiveDPV2(int[] set, int sum)
    {
        int n = set.length;
        boolean[][] dp = new boolean[2][sum+1];

        for (int i = 0 ; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        int index = 0;
        for (int i = 1; i <= n; i++) {
            index = i & 1;
            for (int j = 1; j <= sum; j++) {
                boolean include = j - set[i-1] < 0 ? false : dp[1-index][j-set[i-1]];
                boolean exclude = dp[1-index][j];
                dp[index][j] = include || exclude;
            }
        }
        return dp[index][sum];
    }


    public static boolean hasSubsetSumRecursiveDPV3(int[] set, int sum)
    {
        int n = set.length;
        boolean[] dp = new boolean[sum+1];

        dp[0] = true;
        for (int i = 1 ; i < dp.length; i++) {
            dp[i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= set[i-1]; j--) {
                boolean include =  dp[j-set[i-1]];
                boolean exclude = dp[j];
                dp[j] = include || exclude;
            }
        }
        return dp[sum];
    }

    public static void printAllSubArrays(int[] arr, int i, int sum, boolean[][] dp,List<Integer> p)
    {
        if ( sum == 0 )
        {
            resultList.add(p);
            p.clear();
            return;
        }

        if (dp[i-1][sum]) {
            List<Integer> b = new ArrayList<>();
            b.addAll(p);
            printAllSubArrays(arr, i -1, sum, dp, b);
        }

        if (sum - arr[i] >= 0 && dp[i-1][sum-arr[i]]) {
            System.out.println("adding in list");
            p.add(arr[i]);
            printAllSubArrays(arr, i -1, sum-arr[i], dp, p);
        }
    }
}
