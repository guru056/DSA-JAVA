package Arrays.Sorting;

import Utils.ArrayUtils;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{64,25,12,22,11};
        selectionSort(arr);
        ArrayUtils.printArr(arr);
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;

        for ( int i = 0; i < n - 1; i++){
            int minIndex = findMinIndex(arr, i, n - 1);
            if ( minIndex != i){
                ArrayUtils.swap(arr, i ,minIndex);
            }
        }
    }

    private static int findMinIndex(int[] arr, int start, int end){
        int min_index  = start;
        for (int i = start + 1; i <= end; i++){
            if (arr[i] < arr[min_index]){
                min_index = i;
            }
        }
        return min_index;
    }
}
