package Arrays.Misc;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//https://www.geeksforgeeks.org/stock-buy-sell/

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//@TODO https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//@TODO https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
//@TODO https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

/**
 * The cost of a stock on each day is given in an array,
 * find the max profit that you can make by buying and selling in those days.
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 * the maximum profit can earned by buying on day 0,
 * selling on day 3. Again buy on day 4 and sell on day 6.
 * If the given array of prices is sorted in decreasing order,
 * then profit cannot be earned at all.
 * Case 1: Multiple transactions allowed
 * Case 2: Single Transaction Allowed
 */
public class StockBuyAndSellV1 {

    static class ResultPair {
        int buyOnDay;
        int sellOnDay;

        public ResultPair(int buyOnDay, int sellOnDay) {
            this.buyOnDay = buyOnDay;
            this.sellOnDay = sellOnDay;
        }

        @Override
        public String toString() {
            return "ResultPair{" +
                    "buyOnDay=" + buyOnDay +
                    ", sellOnDay=" + sellOnDay +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(getPairsForMaxProfit(arr));

        int[] arr1 = {7, 1, 5, 3, 6, 4};
        System.out.println(getPairsForMaxProfit(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(getPairsForMaxProfit(arr2));

        int[] arr3 = {7, 6, 4, 3, 1};
        System.out.println(getPairsForMaxProfit(arr3));

//        1, 3, 2, 8, 4, 9
        int[] arr4 = {1, 3, 2, 8, 4, 9};
        System.out.println(getPairsForMaxProfit(arr4));

    }

    /**
     * {100, 180, 260, 310, 40, 535, 695}
     *
     * @param arr
     * @return
     */
    public static List<ResultPair> getPairsForMaxProfit(int[] arr) {
        List<ResultPair> resultPairList = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = 0;

        while (right < n) {

            while (right < n - 1 && arr[right] < arr[right + 1]) {
                right++;
            }
            if (left != right) {
                resultPairList.add(new ResultPair(left, right));
            }
            right++;
            left = right;
        }

        return resultPairList;
    }

    public static int getMaxProfit(int[] arr) {
        List<ResultPair> resultPairList = getPairsForMaxProfit(arr);

        int totalProfit = 0;
        for (ResultPair p : resultPairList) {
            totalProfit += (arr[p.sellOnDay] - arr[p.buyOnDay]);
        }
        return totalProfit;
    }

    //    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    //    https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

    public static int getMaxProfitForSingleTransaction(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int[] buyMin = new int[n];
        int[] sellMax = new int[n];
        buyMin[0] = arr[0];
        sellMax[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            buyMin[i] = Math.min(buyMin[i - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            sellMax[i] = Math.max(sellMax[i + 1], arr[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, sellMax[i] - buyMin[i]);
        }
        return maxProfit;
    }

    public static int getMaxProfitForSingleTransactionV2(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int minElement = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
            } else {
                maxProfit = Math.max(maxProfit, arr[i] - minElement);
            }
        }
        return maxProfit;
    }

    public static int getMaxProfitForSingleTransactionV3(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int maxElement = arr[n - 1];
        int maxProfit = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            } else {
                maxProfit = Math.max(maxProfit, maxElement - arr[i]);
            }
        }
        return maxProfit;
    }

    /**
     * {2, 30, 15, 10, 8, 25, 80}
     * {2, 30, 40, 40, 38, 40, 80}
     * 28 + 42 = 70
     * 78
     *
     * {100, 10, 15, 30, 8, 25, 80};
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int getMaxProfitForSingleTransaction(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return 0;

        int maxProfit = 0;
        int minElement = arr[startIndex];
        int resultStartIndex = startIndex, resultEndIndex = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                resultStartIndex = i;
                resultEndIndex = i;
            } else {
                if (arr[i] - minElement > maxProfit) {
                    maxProfit = arr[i] - minElement;
                    resultEndIndex = i;
                }
            }
        }
        return maxProfit;
    }

    public static int getMaxProfitWithAtMostTwoTransactions(int[] arr) {
        int n = arr.length;

        int maxProfit = 0;
        for (int i = 1; i < n - 1; i++) {
            int profit1 = getMaxProfitForSingleTransaction(arr, 0, i);
            int profit2 = getMaxProfitForSingleTransaction(arr, i + 1, n - 1);
            if (profit1 + profit2 > maxProfit) {
                maxProfit = profit1 + profit2;
            }
        }
        int profit = getMaxProfitForSingleTransaction(arr, 0, n-1);
        if (profit > maxProfit) {
            maxProfit = profit;
        }

        return maxProfit;
    }
}
