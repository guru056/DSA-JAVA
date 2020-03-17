package Arrays.Sorting;

import Utils.ArrayUtils;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12,11,13,5,6};
        insertionSort(arr);
        ArrayUtils.printArr(arr);
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;

        for ( int i = 1; i < n ; i++){
            int j = i - 1;
            int key = arr[i];

            while (j >= 0 && key < arr[j]){
                arr[j + 1 ] = arr[j];
                j = j -1;
            }
            arr[j + 1] = key;
        }
    }

}
