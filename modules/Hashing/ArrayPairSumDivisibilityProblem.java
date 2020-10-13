package Hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
//https://www.geeksforgeeks.org/count-pairs-in-array-whose-sum-is-divisible-by-k/
//https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
public class ArrayPairSumDivisibilityProblem {

    public static void main(String[] args) {
        int[] arr = {92, 75, 65, 48, 45, 35};
        int k = 10;

        int[] arr1 = {9, 7, 5, 3};
        int k1 = 6;

        int[] arr2 = {20, 25, 10, 3, 15, 27};
        int k2 = 10;

        System.out.println(checkPairSumDivisibilityCriteria(arr, k));
        System.out.println(getPairSumDivisibilityCriteriaCount(arr, k));

        System.out.println(checkPairSumDivisibilityCriteria(arr1, k1));
        System.out.println(getPairSumDivisibilityCriteriaCount(arr1, k1));

        System.out.println(checkPairSumDivisibilityCriteria(arr2, k2));
        System.out.println(getPairSumDivisibilityCriteriaCount(arr2, k2));

    }

    /**
     * Check if an array can be divided into pairs whose sum is divisible by k
     * <p>
     * Given an array of integers and a number k, write a function that returns true
     * if given array can be divided into pairs such that
     * sum of every pair is divisible by k.
     * <p>
     * arr[] = {92, 75, 65, 48, 45, 35}
     *
     * @param arr
     * @param k
     * @return
     */
    public static boolean checkPairSumDivisibilityCriteria(int[] arr, int k) {
        if (arr.length % 2 != 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i] % k, map.getOrDefault(arr[i] % k, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int currentRemainder = entry.getKey();
            int currentRemainderCount = entry.getValue();

            if (currentRemainder == 0) {
                if (currentRemainderCount % 2 != 0)
                    return false;
            } else if (2 * currentRemainder == k) {
                if (currentRemainderCount % 2 != 0)
                    return false;
            } else if (currentRemainderCount != map.get(k - currentRemainder)) {
                return false;
            }
        }
        return true;
    }

    public static int getPairSumDivisibilityCriteriaCount(int[] arr, int k) {
        int count = 0;
        int twiceCount = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i] % k, map.getOrDefault(arr[i] % k, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int currentReminder = e.getKey();
            int currentReminderCount = e.getValue();

            if (currentReminder == 0) {
                count += ((currentReminderCount) * (currentReminderCount - 1) / 2);
            } else if (2 * currentReminder == k) {
                count += ((currentReminderCount) * (currentReminderCount - 1) / 2);
            } else {
                int remainingRemainder = k - currentReminder;
                if (!map.containsKey(remainingRemainder))
                    continue;
                int remainingReminderCount = map.get(remainingRemainder);
                twiceCount += ((currentReminderCount * remainingReminderCount));
            }
        }
        return count + (twiceCount / 2);
    }
}
