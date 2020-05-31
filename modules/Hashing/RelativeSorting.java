package Hashing;

import Utils.ArrayUtils;

import java.util.*;

//https://leetcode.com/problems/relative-sort-array/
//https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
public class RelativeSorting {

    public static void main(String[] args) {
        int[] arr1 = { 2,3,1,3,2,4,6,7,9,2,19 };
        int[] arr2 = { 2,1,4,3,9,6 };

//        ArrayUtils.printArr(relativeSorting(arr1,arr2));
//        ArrayUtils.printArr(relativeSortingV2(arr1,arr2));
        ArrayUtils.printArr(relativeSortingV3(arr1,arr2));
    }

    public static int[] relativeSorting(int[] arr1, int[] arr2)
    {
        Arrays.sort(arr1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < arr2.length; i++) {
            int firstOccurrence = findFirstOccurrence(arr1, arr2[i]);
            if (firstOccurrence == -1)
                continue;
            int index = firstOccurrence;
            int count = 0;
            while (index < arr1.length && arr1[index] == arr2[i]) {
                index++;
                count++;
            }
            map.put(arr2[i], count);
        }
        int[] resultArr = new int[arr1.length];
        int i = 0;
        for (int j = 0 ; j < arr2.length; j++) {
            if (!map.containsKey(arr2[j]))
                continue;
            int count = map.get(arr2[j]);
            while (count-- > 0) {
                resultArr[i++] = arr2[j];
            }
        }
        for (int j = 0; j < arr1.length && i < arr1.length; j++) {
            if (!map.containsKey(arr1[j]))
                resultArr[i++] = arr1[j];
        }

        return resultArr;
    }

    public static int findFirstOccurrence(int[] arr, int searchVal)
    {
        return findFirstOccurrenceRecursive(arr, 0, arr.length - 1, searchVal);
    }

    private static int findFirstOccurrenceRecursive(int[] arr, int begin, int end, int searchVal)
    {
        if (begin > end)
            return -1;
        int mid = (begin + end) / 2;

        if (searchVal < arr[mid] ) {
            return findFirstOccurrenceRecursive(arr, begin, mid - 1 , searchVal);
        } else if (searchVal > arr[mid]) {
            return findFirstOccurrenceRecursive(arr, mid+1, end, searchVal);
        } else {
            if (mid == 0 || arr[mid - 1] != searchVal)
                return mid;
            return findFirstOccurrenceRecursive(arr, begin, mid - 1, searchVal);
        }
    }

    /**
     *
     * complexity step 1 : NlogN
     * complexity step 2: MlogN
     * M - size of arr2
     * N - size of arr1
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortingV2(int[] arr1, int[] arr2)
    {
        int[] resultArr = new int[arr1.length];

        //step 1
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        //step 2
        int index = 0;
        for (int i= 0; i < arr2.length; i++){
            if (!map.containsKey(arr2[i]))
                continue;
            int count = map.get(arr2[i]);
            while (count-- > 0) {
                resultArr[index++] = arr2[i];
            }
            map.remove(arr2[i]);
        }

        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            int count = e.getValue();
            while (count-- > 0) {
                resultArr[index++] = e.getKey();
            }
        }
        return resultArr;
    }

    /**
     * complexity step 1 : NlogN
     * complexity step 2: O(M)
     * complexity step 3 : O(PlogP)
     * M - size of arr2
     * N - size of arr1
     * P - remaining elements in map after traversing arr2
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortingV3(int[] arr1, int[] arr2)
    {
        int[] resultArr = new int[arr1.length];

        //step 1
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        //step 2
        int index = 0;
        for (int i= 0; i < arr2.length; i++){
            if (!map.containsKey(arr2[i]))
                continue;
            int count = map.get(arr2[i]);
            while (count-- > 0) {
                resultArr[index++] = arr2[i];
            }
            map.remove(arr2[i]);
        }

        //step 3
        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);

        for (int j = 0; j < sortedKeys.size(); j++) {
            int val = sortedKeys.get(j);
            int count = map.get(val);
            while (count-- > 0) {
                resultArr[index++] = val;
            }
        }
        return resultArr;
    }
}
