package Arrays.Sorting;

import Utils.ArrayUtils;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{38,27,43,3,9,82,10};
        mergeSortUtil(arr);
        ArrayUtils.printArr(arr);
    }

    public static void mergeSortUtil(int[] arr){
        mergeSortRecursive(arr, 0, arr.length - 1 );
    }

    public static void mergeSortRecursive(int[] arr, int begin, int end){
        if (begin >= end)
            return;
        int mid = (begin + end)/2;
        mergeSortRecursive(arr, begin, mid);
        mergeSortRecursive(arr, mid + 1 , end);
        merge(arr, begin, mid, end);
    }

    public static void merge(int[] arr , int begin, int mid, int end){
        int m = mid - begin + 1;
        int n = end - mid;

        int[] a = new int[m];
        int[] b = new int[n];

        for (int i = 0 ; i < m; i++){
            a[i] = arr[begin + i];
        }

        for (int i = 0 ; i < n ; i++){
            b[i] = arr[mid + 1 + i];
        }

        int k = begin;
        int i = 0;
        int j = 0;

        while (i < m && j < n){
            if (a[i] < b[j]){
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
            }
        }
        while (i < m ){
            arr[k++] = a[i++];
        }

        while (j < n){
            arr[k++] = b[j++];
        }
    }
}
