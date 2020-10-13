package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.programcreek.com/2014/04/leetcode-combination-sum-ii-java/
//https://practice.geeksforgeeks.org/problems/combination-sum-part-2/0
public class CombinationalSumII {

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int sum = 8;

        System.out.println(getCombinations(arr, sum));
    }

    public static List<List<Integer>> getCombinations(int[] arr, int sum) {
        Arrays.sort(arr);

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        getCombinationsRecursive(arr, arr.length, 0, sum, currentList, resultList);
        return resultList;
    }

    public static void getCombinationsRecursive(int[] arr, int arrSize, int currentIndex, int sum, List<Integer> currentList, List<List<Integer>> resultList) {
        if (sum < 0 )
            return;
        if (sum == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        int prev = -1; // Alternative is to use Set<List<Integer>>
        for (int i = currentIndex; i < arrSize ; i++) {
            if (prev != arr[i]) { // If we have already found a solution starting from value = arr[i], considering it again will just lead to a duplicate.
                currentList.add(arr[i]);
                getCombinationsRecursive(arr, arrSize, i + 1, sum - arr[i], currentList, resultList);
                currentList.remove(currentList.size() - 1);
                prev = arr[i];
            }
        }
    }
}
