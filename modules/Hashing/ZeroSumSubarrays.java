package Hashing;

import java.util.*;

//https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
//https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
public class ZeroSumSubarrays {

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr1 = {-1 ,1 ,-1 ,1};
        int[] arr2 = {-1, 1, 0, -1, 1};
        int[] arr3 = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        printResults(arr);
        printResults(arr1);
        printResults(arr2);
        printResults(arr3);
    }

    public static void printResults(int[] arr) {
        System.out.println(getLargestSubarrayLengthWithZeroSum(arr));
        System.out.println(zeroSumSubarrayCount(arr));
        System.out.println(getAllSubArraysWithZeroSum(arr));
    }

    public static int getLargestSubarrayLengthWithZeroSum(int[] arr)
    {
        int n  = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        int startPos = -1; // will be used if you are supposed to return the subarray
        for (int i = 0 ; i < n; i++){
            sum += arr[i];
            if (sum == 0 ) {
                maxLength = i + 1;
                startPos = 0;
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            } else {
                int startIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - startIndex);
                startPos = startIndex + 1;
            }
        }
        return maxLength;
    }

    public static int zeroSumSubarrayCount(int[] arr)
    {
        int n  = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0 ; i < n; i++){
            sum += arr[i];
            if (sum == 0 )
                count++;
            if (!map.containsKey(sum)){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sum, list);
            } else {
                count += map.get(sum).size();
                map.get(sum).add(i);
            }
        }
        return count;
    }

    public static List<List<Integer>> getAllSubArraysWithZeroSum(int[] arr) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                resultList.add(Arrays.asList(0,i));
            }
            if (!map.containsKey(sum)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sum, list);
            } else {
                List<Integer> startIndices = map.get(sum);
                for(int startIndex: startIndices ) {
                    resultList.add(Arrays.asList(startIndex+1,i));
                }
                map.get(sum).add(i);
            }
        }
        return resultList;
    }
}
