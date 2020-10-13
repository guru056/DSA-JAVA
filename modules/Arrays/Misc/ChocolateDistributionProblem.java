package Arrays.Misc;

import java.util.Arrays;

//https://www.geeksforgeeks.org/chocolate-distribution-problem/
public class ChocolateDistributionProblem {

    public static void main(String[] args) throws Exception {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;

        int[] arr1 = {3, 4, 1, 9, 56, 7, 9, 12};
        int m1 = 5;

        int[] arr2 = {12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50};
        int m2 = 7;

        System.out.println(getMinDifference(arr, m));
        System.out.println(getMinDifference(arr1, m1));
        System.out.println(getMinDifference(arr2, m2));

    }

    /**
     * Given an array of n integers where each value represents number of chocolates in a packet.
     * Each packet can have variable number of chocolates. There are m students,
     * the task is to distribute chocolate packets such that:
     * <p>
     * 1. Each student gets one packet.
     * 2. The difference between the number of chocolates in packet with maximum chocolates
     * and packet with minimum chocolates given to the students is minimum.
     * <p>
     * Approach: Find the subarray of size m such that difference between last (maximum in case of
     * sorted) and first (minimum in case of sorted) elements of
     * subarray is minimum.
     *
     * @param arr
     * @param m
     * @return
     * @throws Exception
     */
    public static int getMinDifference(int[] arr, int m) throws Exception {
        int n = arr.length;
        if (n == 0 || m == 0 || n < m) {
            throw new Exception("Invalid Input");
        }

        Arrays.sort(arr);
        int i = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i + m - 1 < n) {
            minDiff = Math.min(arr[i + m - 1] - arr[i], minDiff);
            i++;
        }
        return minDiff;
    }
}
