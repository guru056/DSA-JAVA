package Arrays.Sorting;

import Utils.ArrayUtils;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,4,2,8,9};
//        bubbleSort(arr);
        bubbleSortOptimized(arr);
        ArrayUtils.printArr(arr);
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for( int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i ; j ++){
                if ( arr[j] > arr[j + 1]){
                    ArrayUtils.swap(arr, j , j + 1);
                }
            }
        }
    }

    public static void bubbleSortOptimized(int[] arr){
        int n = arr.length;
        boolean swapped = false;
        for( int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i ; j ++){
                if ( arr[j] > arr[j + 1]){
                    ArrayUtils.swap(arr, j , j + 1);
                    swapped = true;
                }
            }
            if (swapped == false){
                break;
            }
        }
    }

    public static void bubbleSortRecursive(int[] arr, int n ){
        if (n == 1)
            return;
        for (int i = 0; i < n - 1 ; i++){
            if (arr[i] > arr[i+1]){
                ArrayUtils.swap(arr, i , i+1);
            }
        }
        bubbleSortRecursive(arr, n-1);
    }

    public static void bubbleSortRecursiveUtil(int[] arr){
        bubbleSortRecursive(arr, arr.length);
    }
}
