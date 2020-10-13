package Arrays.Misc.StockBuyAndSell;

public class StockBuyAndSellWithSingleTransaction {

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
}
