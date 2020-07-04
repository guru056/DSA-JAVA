package Arrays.Sorting;

import Utils.ArrayUtils;

//https://www.geeksforgeeks.org/merge-sort-with-o1-extra-space-merge-and-on-lg-n-time/
public class EfficientMergeSort {

    public static void main(String[] args) {
        int[] arr = {38,27,43,3,9,82,10};
        mergeSort(arr);
        ArrayUtils.printArr(arr);
     }

    public static void mergeSort(int[] arr)
    {
        int maxVal = ArrayUtils.getMaximum(arr);
        mergeSortRecursive(arr, 0, arr.length - 1, maxVal+1);
    }

    public static void mergeSortRecursive(int[] arr, int begin, int end, int maxVal)
    {
        if (begin >= end)
            return;
        int mid = (begin + end) / 2;
        mergeSortRecursive(arr, begin, mid, maxVal);
        mergeSortRecursive(arr, mid + 1, end, maxVal);
        merge(arr, begin, mid, end, maxVal);
    }

    public static void merge(int[] arr, int begin, int mid, int end, int maxVal)
    {
        int i  = begin;
        int j  = mid + 1;
        int k = begin;

        while (i <= mid && j <= end) {
            if (arr[i] % maxVal < arr[j] % maxVal) {
                arr[k] += (arr[i] % maxVal) * maxVal ;
                k++;
                i++;
            }
            else {
                arr[k] += (arr[j] % maxVal) * maxVal ;
                k++;
                j++;
            }
        }
        while (i <= mid) {
            arr[k] += (arr[i] % maxVal) * maxVal ;
            k++;
            i++;
        }
        while (j <= end) {
            arr[k] += (arr[j] % maxVal) * maxVal ;
            k++;
            j++;
        }
        for (i = begin; i <= end; i++) {
            arr[i] /= maxVal;
        }
    }
}
