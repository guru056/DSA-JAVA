package Hashing;

import java.util.*;

//https://www.geeksforgeeks.org/print-all-pairs-with-given-sum/
public class PairsWithGivenSumInArray {

    public static void main(String[] args) {
        int[] arr = {1,5,7,-1,5};
        int sum = 6;

        int[] arr1 = {2, 5, 17, -1};
        int sum1 = 7;

        int[] arr2 = {1,1,1,1};
        int sum2 = 2;

        System.out.println(getPairs(arr,sum));
        System.out.println(getPairs(arr1,sum1));
        System.out.println(getPairs(arr2, sum2));

        System.out.println(getDistinctPairs(arr,sum));
        System.out.println(getDistinctPairs(arr1,sum1));
        System.out.println(getDistinctPairs(arr2, sum2));
    }
    /**
     * Examples :
     * Input  :  arr[] = {1, 5, 7, -1, 5},
     *           sum = 6
     * Output : (1, 5) (7, -1) (1, 5)
     *
     * Input  :  arr[] = {2, 5, 17, -1},
     *           sum = 7
     * Output :  (2, 5)
     * @param arr
     * @param sum
     * @return
     */
    public static List<List<Integer>> getPairs(int[] arr, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                int count = map.get(sum - arr[i]);
                while (count-- > 0) {
                    resultList.add(Arrays.asList(sum-arr[i], arr[i]));
                }
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }
        return resultList;
    }

    public static List<List<Integer>> getDistinctPairs(int[] arr, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0 ; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                if (sum - arr[i] != arr[i] || (sum - arr[i] == arr[i] && map.get(arr[i]) > 1)) {
                    resultList.add(Arrays.asList(sum-arr[i], arr[i]));
                    map.remove(arr[i]);
                    map.remove(sum - arr[i]);
                }
            }
        }
        return resultList;
    }

    public static int getPairsCount(int[] arr, int sum) {
        return getPairs(arr,sum).size();
    }

    public static int getDistinctPairsCount(int[] arr, int sum) {
        return getDistinctPairs(arr,sum).size();
    }

    public static int getPairsCountV2(int[] arr, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        }

        int twiceCount = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (map.containsKey(sum - key)) {
                if (sum - key == key && value > 1) {
                    twiceCount += 2;
                } else {
                    twiceCount += 1;
                }
            }
        }
        return twiceCount / 2;
    }
}
