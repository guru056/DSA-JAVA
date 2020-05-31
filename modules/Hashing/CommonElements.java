package Hashing;

import Utils.ArrayUtils;
import Utils.MatrixUtils;

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
//        MatrixUtils.printMatrix(arr);
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
}
