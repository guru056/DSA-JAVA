package Misc;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations
public class PermutationsOfIntegerArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(getPermutationsRecursive(arr, 0, 2));
    }

    public static List<List<Integer>> getPermutationsRecursive(int[] arr, int i, int j) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (i == j) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            resultList.add(list);
            return resultList;
        }

        for (int k = i; k <= j; k++) {
            ArrayUtils.swap(arr, i, k);
            List<List<Integer>> list = getPermutationsRecursive(arr, i+1, j);
            for (List<Integer> l: list) {
                l.add(arr[i]);
                resultList.add(l);
            }
            ArrayUtils.swap(arr, i, k);
        }
        return resultList;
    }
}
