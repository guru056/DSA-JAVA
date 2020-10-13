package Arrays.Misc.StockBuyAndSell;

import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSellWithMultipleTransactions {

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

}
