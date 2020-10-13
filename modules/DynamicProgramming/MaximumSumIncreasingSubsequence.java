package DynamicProgramming;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
//https://www.geeksforgeeks.org/printing-maximum-sum-increasing-subsequence
public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {3,4,-1,0,2,3};
        System.out.println(maxSumIncreasingSubsequence(arr));

        int[] arr1 = {3,4,1,2,4};
        System.out.println(maxSumIncreasingSubsequence(arr1));
        System.out.println(getAllMSIS(arr1));
        System.out.println(getMSISWithMinimumLengthLIS(arr1));
        printMSISWithMinimumLengthLIS(arr1);
    }


    public static int maxSumIncreasingSubsequence(int[] arr)
    {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int maxSum = 0;
        for (int i = 1 ; i < n; i++) {
            int maxVal = 0;
            for (int j = 0 ; j < i; j++) {
                if (arr[j] < arr[i]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + arr[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static List<Stack<Integer>> getAllMSIS(int[] arr)
    {
        int n = arr.length;
        if (n == 0)
            return null;
        List<Stack<Integer>> resultList = new ArrayList<>();

        int[] dp = new int[n];
        dp[0] = arr[0];
        int maxSum = 0;
        for (int i = 1 ; i < n; i++){
            int maxVal = 0;
            for (int j = 0 ; j < i; j++){
                if (arr[j] < arr[i]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + arr[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        for (int i = 0 ; i < n ; i++){
            if (dp[i] == maxSum){
                Stack<Integer> st = new Stack<>();
                st.push(arr[i]);
                int j = i - 1;
                int sum = maxSum - arr[i];
                while (j >= 0 && sum != 0 ){
                    if (arr[j] < arr[i]){
                        st.add(arr[j]);
                        sum -= arr[j];
                    }
                    j--;
                }
                resultList.add(st);
            }
        }
        return resultList;
    }

    public static Stack<Integer> getMSISWithMinimumLengthLIS(int[] arr)
    {
        List<Stack<Integer>> resultList = getAllMSIS(arr);
        Stack<Integer> resultStack = null;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0 ; i < resultList.size(); i++){
            Stack<Integer> st = resultList.get(i);
            if (st.size() < minSize){
                resultStack = st;
                minSize = st.size();
            }
        }
        return resultStack;
    }

    public static void printMSISWithMinimumLengthLIS(int[] arr)
    {
        Stack<Integer> st = getMSISWithMinimumLengthLIS(arr);
        while (!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }
}
