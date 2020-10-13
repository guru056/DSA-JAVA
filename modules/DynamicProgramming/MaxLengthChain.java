package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/maximum-length-of-pair-chain/
//https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/
//https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-set-2/
public class MaxLengthChain {

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    public static void main(String[] args) {
        Pair[] arr = {
                new Pair(5, 24),
                new Pair(39, 60),
                new Pair(15, 28),
                new Pair(27, 40),
                new Pair(50, 90),
        };
//        System.out.println(maxLengthChain(arr));
        System.out.println(maxLengthChainV2(arr));

        int[][] arr1 = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
//        System.out.println(maxLengthChain(arr1));
        System.out.println(maxLengthChainV2(arr1));
    }

    /**
     * {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }
     * {{5, 24}, {27, 40}, {50, 90}}
     * {{15, 28}, {39, 60} }
     * <p>
     * <p>
     * {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }
     * { {5, 24}, {15, 28}, {27, 40}, {39, 60}, {50, 90} }
     *
     * @return
     */
    public static int maxLengthChain(Pair[] arr) {
        Comparator<Pair> cmp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.b < o2.a)
                    return -1;
                else if (o2.b < o1.a)
                    return 1;
                else
                    return o1.b < o2.b ? -1 : 1;
            }
        };
        Arrays.sort(arr, cmp);
        int n = arr.length;
        int[] dp = new int[n];
        int maxLengthLis = 0;
        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j].b < arr[i].a) {
                    maxVal = Math.max(dp[j], maxVal);
                }
            }
            dp[i] = 1 + maxVal;
            maxLengthLis = Math.max(maxLengthLis, dp[i]);
        }
        return maxLengthLis;
    }

    public static int maxLengthChain(int[][] arr) {
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[0])
                    return -1;
                else if (o2[1] < o1[0])
                    return 1;
                else
                    return o1[1] < o2[1] ? -1 : 1;
            }
        };
        Arrays.sort(arr, cmp);

        int n = arr.length;
        int[] dp = new int[n];
        int maxLengthLis = 0;
        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j][1] < arr[i][0]) {
                    maxVal = Math.max(dp[j], maxVal);
                }
            }
            dp[i] = 1 + maxVal;
            maxLengthLis = Math.max(maxLengthLis, dp[i]);
        }
        return maxLengthLis;
    }

    /**
     * O(NLogN) solution
     * Activity Selection Logic
     *
     * @param arr
     * @return
     */
    public static int maxLengthChainV2(int[][] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[0])
                    return -1;
                else if (o2[1] < o1[0])
                    return 1;
                else
                    return o1[1] < o2[1] ? -1 : 1;
            }
        };
        Arrays.sort(arr, cmp);

        int maxLength = 1;
        int second = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] > second) {
                second = arr[i][1];
                maxLength++;
            }
        }
        return maxLength;
    }

    public static int maxLengthChainV2(Pair[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        Comparator<Pair> cmp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.b < o2.a)
                    return -1;
                else if (o2.b < o1.a)
                    return 1;
                else
                    return o1.b < o2.b ? -1 : 1;
            }
        };
        Arrays.sort(arr, cmp);
        int maxLength = 1;
        int second = arr[0].b;
        for (int i = 1; i < n; i++) {
            if (arr[i].a > second) {
                second = arr[i].b;
                maxLength++;
            }
        }
        return maxLength;
    }
}
