package Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
//https://www.geeksforgeeks.org/power-set/
//https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/
public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(getAllSubsetsIterative(arr));
        System.out.println(getAllSubsetsIterativeV2(arr));
    }

    public static List<List<Integer>> getAllSubsets(int[] arr) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        getAllSubsetsRecursiveV2(arr, 0, arr.length-1, currentList, resultList);
        return resultList;
    }

    public static void getAllSubsetsRecursive(int[] arr, int begin, int end, List<Integer> currentList, List<List<Integer>> resultList) {
        if (begin > end) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = begin; i <= end; i++) { // will lead to duplicates , so set is needed here.
            getAllSubsetsRecursive(arr, i + 1, end, currentList, resultList);
            currentList.add(arr[i]);
            getAllSubsetsRecursive(arr, i + 1, end, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }

    }

    /**
     * Time Complexity: O(2 ^ n).
     * For every index i two recursive case originates, So Time Complexity is O(2^n).
     * @param arr
     * @param begin
     * @param end
     * @param currentList
     * @param resultList
     */
    public static void getAllSubsetsRecursiveV2(int[] arr, int begin, int end, List<Integer> currentList, List<List<Integer>> resultList) {
        resultList.add(new ArrayList<>(currentList));

        for (int i = begin; i <= end; i++) {
            currentList.add(arr[i]);
            getAllSubsetsRecursiveV2(arr, i + 1, end, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static List<List<Integer>> getAllSubsetsIterative(int[] arr) {
        int n = arr.length;
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();

        int numOfSets = 1 << n; // 2^n
        for (int counter = 0; counter < numOfSets; counter++) {
            int j = counter;
            int index = 0;
            while (j > 0 && index < n) {
                if ((j & 1) > 0) {
                    currentList.add(arr[index]);
                }
                j = j >> 1;
                index++;
            }
            resultList.add(new ArrayList<>(currentList));
            currentList.clear();
        }
        return resultList;
    }

    public static List<List<Integer>> getAllSubsetsIterativeV2(int[] arr) { // O(n*2^n)
        int n = arr.length;
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();

        int numOfSets = 1 << n; // 2^n
        for (int counter = 0; counter < numOfSets; counter++) {
            for (int j = 0; j < n; j++) {
                if ((counter & (1 << j)) > 0) {
                    currentList.add(arr[j]);
                }
            }
            resultList.add(new ArrayList<>(currentList));
            currentList.clear();
        }
        return resultList;
    }


    public static void combinationalSum(int[] arr, int sum, int begin, int end, List<Integer> currentList, List<List<Integer>> resultList) {
        if (sum < 0) {
            return;
        }

        if (sum == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        int prev = -1;
        for (int i = begin; i <= end; i++) {
            if (prev != arr[i]) {
                currentList.add(arr[i]);
                combinationalSum(arr, sum - arr[i], i+1, end, currentList, resultList);
                currentList.remove(currentList.size()-1);
                prev = arr[i];
            }
        }
    }


    public static List<List<Integer>> getCombinationalSum(int[] arr, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        combinationalSum(arr, sum, 0, arr.length - 1, currentList, resultList);
        return resultList;
    }

}
