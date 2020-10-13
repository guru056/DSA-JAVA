package Arrays.Misc.StockBuyAndSell;

import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSellWithAtMostTwoTransactions {

    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {10, 22, 5, 75, 65, 80};
        int[] arr3 = {2, 30, 15, 10, 8, 25, 80};
        int[] arr4 = {100, 30, 15, 10, 8, 25, 80};
        int[] arr5 = {90, 80, 70, 60, 50};
        int[] arr6 = {3,3,5,0,0,3,1,4};
        int[] arr7 = {1,2,4,2,5,7,2,4,9,0};
        int[] arr8 = {1,2,4,7};

        printMaxProfit(arr);
        printMaxProfit(arr1);
        printMaxProfit(arr2);
        printMaxProfit(arr3);
        printMaxProfit(arr4);
        printMaxProfit(arr5);
        printMaxProfit(arr6);
        printMaxProfit(arr7);
        printMaxProfit(arr8);
    }

    public static void printMaxProfit(int[] arr) {
        List<ResultPair> resultPairList = getPairsForMaxProfitWithAtMostTwoTransactions(arr);
        if (resultPairList.isEmpty()) {
            System.out.println("No pairs possible\n");
            return;
        }
        int totalProfit = 0;
        for (ResultPair pair: resultPairList) {
            System.out.println("Buy On Day " + pair.buyOnDay + " , Sell On Day " + pair.sellOnDay + " with profit " + (arr[pair.sellOnDay] - arr[pair.buyOnDay]));
            totalProfit += arr[pair.sellOnDay] - arr[pair.buyOnDay];
        }
        System.out.println("Total Profit : " + totalProfit);
        System.out.println("Total Profit : " + getMaxProfitWithAtMostTwoTransactionsV2(arr));
        System.out.println("Total Profit : " + getMaxProfitWithAtMostTwoTransactionsV3(arr));
        System.out.println();
    }

    public static ResultPair getMaxProfitForSingleTransaction(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return null;

        int maxProfit = 0;
        int minElement = arr[startIndex];
        int resultStartIndex = startIndex, resultEndIndex = startIndex;
        int start = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                start = i;
            } else {
                if (arr[i] - minElement > maxProfit) {
                    maxProfit = arr[i] - minElement;
                    resultStartIndex = start;
                    resultEndIndex = i;
                }
            }
        }
        return maxProfit == 0 ? null : new ResultPair(resultStartIndex, resultEndIndex);
    }

    public static List<ResultPair> getPairsForMaxProfitWithAtMostTwoTransactions(int[] arr) {
        List<ResultPair> resultPairList = new ArrayList<>();
        int n = arr.length;
        if (n == 0)
            return resultPairList;

        int maxProfit = 0;

        for (int i = 1; i < n ; i++) {
            ResultPair p1 = getMaxProfitForSingleTransaction(arr, 0, i);
            ResultPair p2 = getMaxProfitForSingleTransaction(arr, i + 1, n - 1);

            if (p1 == null && p2 == null)
                continue;
            int profit1 = p1 == null ? 0: arr[p1.sellOnDay] - arr[p1.buyOnDay];
            int profit2 = p2 == null ? 0: arr[p2.sellOnDay] - arr[p2.buyOnDay];
            if (profit1 + profit2 > maxProfit) {
                maxProfit = profit1 + profit2;
                resultPairList.clear();
                if (p1 != null )
                    resultPairList.add(p1);
                if (p2 != null)
                    resultPairList.add(p2);
            }
        }
        return resultPairList;
    }

    public static int getMaxProfitWithAtMostTwoTransactions(int[] arr) {
        List<ResultPair> resultPairList = getPairsForMaxProfitWithAtMostTwoTransactions(arr);

        int totalProfit = 0;
        for (ResultPair p: resultPairList) {
            totalProfit += arr[p.sellOnDay] - arr[p.buyOnDay];
        }

        return totalProfit;
    }

    /**
     * {10, 22, 5, 75, 65, 80}
     * {0, 12, 12, 70, 70, 75} 0..i
     * {75, 75, 75, 15, 15, 0} i..n-1
     *
     * {10, 27, 5, 75, 65, 80}
     * {0, 17, 17, 70, 70, 75} 0..i
     * {75, 75, 75, 15, 15, 0} i..n-1
     *
     * {10, 27, 30, 80}
     * {0, 17, 20, 70}
     * {70, 53, 50, 0}
     *
     * {10, 27, 80}
     * {0, 17, 70}
     * {70 ,13, 0}
     *
     * {10, 27, 30, 80}
     * @param arr
     * @return
     */
    public static int getMaxProfitWithAtMostTwoTransactionsV2(int[] arr) { // 5ms
        int n = arr.length;
        if (n < 2)
            return 0;

        int[] leftMaxProfit = new int[n];
        int minElement = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
            }

            leftMaxProfit[i] = Math.max(leftMaxProfit[i - 1], arr[i] - minElement);
        }

        int[] rightMaxProfit = new int[n];
        int maxElement = arr[n-1];
        for (int i = n - 2; i>=0; i--) {
            if (arr[i] > maxElement){
                maxElement = arr[i];
            }
            rightMaxProfit[i] = Math.max(rightMaxProfit[i + 1], maxElement - arr[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftMaxProfit[i] + rightMaxProfit[i]);
        }

        return maxProfit;
    }

    public static int getMaxProfitWithAtMostTwoTransactionsV3(int[] arr) { // 4ms
        int n = arr.length;
        if (n < 2)
            return 0;

        int[] leftMaxProfit = new int[n];
        int minElement = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
            }

            leftMaxProfit[i] = Math.max(leftMaxProfit[i - 1], arr[i] - minElement);
        }

        int maxElement = arr[n-1];
        for (int i = n - 2; i>=0; i--) {
            if (arr[i] > maxElement){
                maxElement = arr[i];
            }
            leftMaxProfit[i] = Math.max(leftMaxProfit[i + 1], maxElement - arr[i] + leftMaxProfit[i]);
        }

        return leftMaxProfit[0];
    }

    /**
     * {3,5,4,5}
     * buy1 = min(buy1, price[i])
     * profit1 = max(profit1, price[i] - buy1)
     * buy2 = min(buy2, price[i] - profit1)
     * profit2 = max(profit2, price[i] - buy2)
     *
     * i = 0, buy1 = 3, profit1 = 0, buy2 = 3, profit2 = 0
     * i = 1, buy1 = 3, profit1 = 2, buy2 = 3, profit2 = 2
     * i = 2, buy1 = 3, profit1 = 2, buy2 = 2, profit2 = 2
     * i = 3, buy1 = 3, profit1 = 2, buy2 = 2, profit2 = 3
     *
     *
     * {1, 2, 4, 7}
     * i = 0, buy1 = 1, profit1 = 0, buy2 = 1, profit2 = 0
     * i = 1, buy1 = 1, profit1 = 1, buy2 = 1, profit2 = 1
     * i = 2, buy1 = 1, profit1 = 3, buy2 = 1, profit2 = 3
     * i = 3, buy1 = 3, profit1 = 2, buy2 = 2, profit2 = 3
     *
     * {10, 22, 5, 75, 65, 80}
     * i = 0, buy1 = 10, profit1 = 0, buy2 = 10, profit2 = 0
     * i = 1, buy1 = 10, profit1 = 12, buy2 = 10, profit2 = 12
     * i = 2, buy1 = 5, profit1 = 12, buy2 = -7, profit2 = 12
     * i = 3, buy1 = 5, profit1 = 65, buy2 = -7, profit2 = 82
     * i = 4, buy1 = 3, profit1 = 2, buy2 = 2, profit2 = 3
     * i = 5, buy1 = 3, profit1 = 2, buy2 = 2, profit2 = 3
     *
     * @param arr
     * @return
     */
    public static int getMaxProfitWithAtMostTwoTransactionsV4(int[] arr) {
        return 0;
    }
}
