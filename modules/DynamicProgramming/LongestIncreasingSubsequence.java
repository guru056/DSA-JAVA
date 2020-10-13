package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
public class LongestIncreasingSubsequence {

    static int maxLis;

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 0, 2, 3};
        System.out.println(longestIncreasingSubsequenceLength(arr));
        System.out.println(lisDP(arr));
        System.out.println(getLisDP(arr));
        System.out.println(getLisDPV2(arr));
        System.out.println(maxLisDPV2(arr));
    }
    /**
     *  3, 4, -1, 0, 2, 3
     *
     *  Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i
     *  such that arr[i] is the last element of the LIS.
     * Then, L(i) can be recursively written as:
     * L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
     * L(i) = 1, if no such j exists.
     *
     * @param arr
     * @return
     */
    public static int longestIncreasingSubsequenceLength(int[] arr)
    {
        int max = lisRecursive(arr, arr.length - 1);
        return maxLis;
    }

    public static int lisRecursive(int[] arr, int i)
    {
        if (i == 0)
            return 1;

        int maxVal = 1;
        int result;
        for (int j = i-1; j >= 0; j--){
            result = lisRecursive(arr,j);
            if (arr[j] < arr[i]){
                maxVal = Math.max(maxVal, 1 + result);
            }
        }
        maxLis = Math.max(maxLis, maxVal);
        return maxVal;
    }

    /**
     * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6
     * and LIS is {10, 22, 33, 50, 60, 80}.
     * {10, 22, 9, 33, 21, 50, 41, 60, 80}
     *  {10, 22, 33, 50, 60, 80}
     *
     * @param arr
     * @return
     */
    public static int lisDP(int[] arr)
    {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLisLength = 1;
        for (int i = 1 ; i < n; i++){
            int maxVal = 0;
            for (int j = 0 ; j < i; j++){
                if (arr[j] < arr[i]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = 1 + maxVal;
            maxLisLength = Math.max(maxLisLength, dp[i]);
        }
        return maxLisLength;
    }

    public static List<Integer>  getLisDP(int[] arr)
    {
        int n = arr.length;
        int maxLisLength = 0;
        List<Integer> resultList = null;
        for (int i = 0 ; i < n; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0 ; j < i; j++){
                if (arr[j] < arr[i]){
                    list.add(arr[j]);
                }
            }
            list.add(arr[i]);
            if (maxLisLength < list.size()){
                resultList = list;
                maxLisLength = list.size();
            }
        }
        return resultList;
    }

    public static List<Integer>  getLisDPV2(int[] arr)
    {
        int n = arr.length;
        int maxLisLength = 0;
        List<Integer> resultList = null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++){
            for (int j = 0 ; j < i; j++){
                if (arr[j] < arr[i]){
                    list.add(arr[j]);
                }
            }
            list.add(arr[i]);
            if (maxLisLength < list.size()){
                resultList = new ArrayList<>(list);
                maxLisLength = list.size();
            }
            list.clear();
        }
        return resultList;
    }

    //get all LIS with max length
    public static List<List<Integer>> maxLisDPV2(int[] arr)
    {
        int n = arr.length;
        int maxLisLength = lisDP(arr);

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    list.add(arr[j]);
                }
            }
            list.add(arr[i]);
            if ( list.size() == maxLisLength ) {
                resultList.add(new ArrayList<>(list));
            }
            list.clear();
        }
        return resultList;
    }
}
