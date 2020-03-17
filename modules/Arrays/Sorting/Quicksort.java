package Arrays.Sorting;

import Utils.ArrayUtils;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,6,5,0,8,2,4,7};
        quickSortUtil(arr);
        ArrayUtils.printArr(arr);
    }

    public static int partition(int[] arr, int begin, int end){
        int x = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++){
            if (arr[j] <= x){
                i++;
                ArrayUtils.swap(arr, i, j);
            }
        }
        ArrayUtils.swap(arr, i + 1, end);
        return ( i + 1);
    }

    public static void quickSortRecursive(int[] arr, int begin, int end){
        if (begin >= end)
            return;

        int partition = partition(arr, begin, end);
        quickSortRecursive(arr, begin, partition - 1);
        quickSortRecursive(arr, partition + 1 , end);
    }

    public static void quickSortUtil(int[] arr){
        quickSortRecursive(arr, 0, arr.length - 1);
    }
}
