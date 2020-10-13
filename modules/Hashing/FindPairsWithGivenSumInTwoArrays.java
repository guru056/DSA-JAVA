package Hashing;

import java.util.*;

//https://www.geeksforgeeks.org/given-two-unsorted-arrays-find-pairs-whose-sum-x/
public class FindPairsWithGivenSumInTwoArrays {

    public static void main(String[] args) {
        int arr1[] = {-1, -2, 4, -6, 5, 7};
        int arr2[] = {6, 3, 4, 0};
        int sum = 8;

        int arr3[] = {1, 2, 4, 5, 7};
        int arr4[] = {5, 6, 3, 4, 8};
        int sum1 = 9;

        System.out.println(getPairs(arr1, arr2, sum));
        System.out.println(getPairs(arr3, arr4, sum1));
    }

    public static List<List<Integer>> getPairs(int[] arr1, int[] arr2, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(sum - arr2[i])) {
                resultList.add(Arrays.asList(sum-arr2[i], arr2[i]));
            }
        }
        return resultList;
    }
}
