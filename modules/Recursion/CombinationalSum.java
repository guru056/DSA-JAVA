package Recursion;

import java.util.*;

//https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
//https://www.geeksforgeeks.org/combinational-sum/
public class CombinationalSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,8};
        int sum = 8;
        System.out.println(getCombinations(arr, sum));
    }

    public static List<List<Integer>> getCombinations(int[] arr, int sum) {
        if (arr.length == 0)
            return null;

        //sort the array
        Arrays.sort(arr);

        //remove duplicates
        int j = 0;
        for (int i = 0 ; i < arr.length - 1; i++) {
            if (arr[i] != arr[i+1])
                arr[j++] = arr[i];
        }
        arr[j++] = arr[arr.length - 1];

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        Stack<Integer> currentStack = new Stack<>();

        getCombinationsRecursive(arr,j , 0, sum, currentList, resultList);
//        getCombinationsRecursive(arr, j, 0, sum, currentStack, resultList);
        return resultList;
    }

    public static void getCombinationsRecursive(int[] arr, int arrSize, int currentIndex, int sum, List<Integer> currentList, List<List<Integer>> resultList) {
        if (sum < 0)
            return;
        if (sum == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        while (currentIndex < arrSize && sum - arr[currentIndex] >= 0) {
            currentList.add(arr[currentIndex]);
            getCombinationsRecursive(arr, arrSize, currentIndex, sum - arr[currentIndex], currentList, resultList);
            currentIndex++;
            currentList.remove(currentList.size() - 1); //backtrack
        }
    }

    public static void getCombinationsRecursive(int[] arr, int arrSize, int currentIndex, int sum, Stack<Integer> currentStack, List<List<Integer>> resultList) {
        if (sum < 0)
            return;
        if (sum == 0) {
            List<Integer> list = new ArrayList<>(currentStack);
            resultList.add(list);
            return;
        }
        while (currentIndex < arrSize && sum - arr[currentIndex] >= 0) {
            currentStack.push(arr[currentIndex]);
            getCombinationsRecursive(arr, arrSize, currentIndex, sum - arr[currentIndex], currentStack, resultList);
            currentIndex++;
            currentStack.pop();//backtrack
        }
    }
}
