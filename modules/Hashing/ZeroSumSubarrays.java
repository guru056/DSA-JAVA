package Hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
//https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
public class ZeroSumSubarrays {

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr1 = {-1 ,1 ,-1 ,1};
        int[] arr2 = {-1, 1, 0, -1, 1};
        System.out.println(getLargestSubarrayLengthWithZeroSum(arr));
        System.out.println(zeroSumSubarrayCount(arr));

        System.out.println(getLargestSubarrayLengthWithZeroSum(arr1));
        System.out.println(zeroSumSubarrayCount(arr1));

        System.out.println(getLargestSubarrayLengthWithZeroSum(arr2));
        System.out.println(zeroSumSubarrayCount(arr2));
    }

    public static int getLargestSubarrayLengthWithZeroSum(int[] arr)
    {
        int n  = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0 ; i < n; i++){
            sum += arr[i];
            if (sum == 0 )
                maxLength = i + 1;
            if (!map.containsKey(sum)){
                map.put(sum, i);
            } else {
                int startIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - startIndex);
            }
        }
        return maxLength;
    }

    public static int zeroSumSubarrayCount(int[] arr)
    {
        int n  = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0 ; i < n; i++){
            sum += arr[i];
            if (sum == 0 )
                count++;
            if (!map.containsKey(sum)){
                map.put(sum, i);
            } else {
                count++;
            }
        }
        return count;
    }
}
