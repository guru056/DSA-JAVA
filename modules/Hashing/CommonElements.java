package Hashing;

import Utils.ArrayUtils;
import Utils.MatrixUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CommonElements {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4}, {1,2,3}, {1,2}};
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7};
        int[] result = getCommonElementsInSortedArrays(arr);
        ArrayUtils.printArr(result);
        System.out.println(getCommonElements(arr[0],arr[1],arr[2]));
    }

    public static int[] getCommonElementsInSortedArrays(int[][] arrays)
    {
        int k = arrays.length; // k sorted arrays are given

        int[] resultArr = getIntersectionForTwoArrays(arrays[0], arrays[1]);
        for (int i = 2; i < k; i++) {
            resultArr = getIntersectionForTwoArrays(resultArr, arrays[i]);
        }
        return resultArr;
    }

    public static int[] getIntersectionForTwoArrays(int[] arr1, int[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;

        List<Integer> list = new LinkedList<>();
        int i = 0,j = 0 ;
        int commonElement = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                commonElement = arr1[i];
                list.add(commonElement);
                i++;
                j++;
                while (i < m && arr1[i] == commonElement)
                    i++;
                while (j < n && arr2[j] == commonElement)
                    j++;
            }
        }
        int[] resultArr = new int[list.size()];
        for (int k = 0 ; k < list.size(); k++)
            resultArr[k] = list.get(k);
        return resultArr;
    }

    public static List<Integer> getCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> resultList = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || arr3.length == 0) {
            return resultList;
        }

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                resultList.add(arr1[i]);
                i++;j++;k++;
            } else if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
                i++;
            } else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
                j++;
            } else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j]){
                k++;
            }
        }
        return resultList;
    }
}
