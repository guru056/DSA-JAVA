package Arrays.Sorting;

import Utils.ArrayUtils;

//https://leetcode.com/problems/merge-sorted-array/
//https://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
public class MergeSortedArraysIntoOne {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};

        int[] arr3 = {0};
        int[] arr4 = {1};

        int[] arr5 = {4,0,0,0,0,0};
        int[] arr6 = {1,2,3,5,6};

        int[] arr7 = {-1,0,0,3,3,3,0,0,0};
        int[] arr8 = {1,2,2};

        int[] arr9 = {-1,-1,0,0,0,0};
        int[] arr10 = {-1,0};


        mergeArrays(arr1, arr2,3,3);
        ArrayUtils.printArr(arr1);

        mergeArrays(arr3, arr4,0,1);
        ArrayUtils.printArr(arr3);

        mergeArrays(arr5, arr6,1,5);
        ArrayUtils.printArr(arr5);

        mergeArrays(arr7, arr8,6,3);
        ArrayUtils.printArr(arr7);

        mergeArrays(arr9, arr10,4,2);
        ArrayUtils.printArr(arr9);
    }

    /**
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * [4,0,0,0,0,0]
     * 1
     * [1,2,3,5,6]
     * 5
     * @param arr1
     * @param arr2
     * @param m
     * @param n
     */
    public static void mergeArrays(int[] arr1, int[] arr2, int m, int n)
    {
//        moveNonZeroesToEnd(arr1,n);
        moveNonZeroesToEnd(arr1, arr2);
        int i = n;
        int j = 0;
        int k = 0;
        if (m > 0 ){
            while (i < m+n && j < n) {
                if (arr1[i] < arr2[j]) {
                    arr1[k++] = arr1[i++];
                } else {
                    arr1[k++] = arr2[j++];
                }
            }
        }
        while (j < n) {
            arr1[k++] = arr2[j++];
        }
    }

    /**
     *
     * @param arr
     * @param n
     */
    private static void moveNonZeroesToEnd(int[] arr, int n)
    {
        int mPlusN = arr.length;
        int i = mPlusN - 1;
        while (i - n >= 0) {
            arr[i] = arr[i - n];
            i--;
        }
    }

    private static void moveNonZeroesToEnd(int[] arr1, int[] arr2) {
        int mPLusN = arr1.length;
        int N = arr2.length;

        int iterator = mPLusN - 1;
        while (iterator - N >= 0) { // this loop runs M times (M is non zero values in arr1)
            arr1[iterator] = arr1[iterator - N];
            iterator--;
        }
    }
}
