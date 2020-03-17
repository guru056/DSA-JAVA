package Arrays.Sorting;

import Utils.ArrayUtils;

public class BinaryInsertionSort {
    public static void main(String[] args)
    {
        int[] arr = new int[]{12,11,13,5,6};
        insertionSort(arr);
        ArrayUtils.printArr(arr);
    }

    public static void insertionSort(int[] arr)
    {
        int n = arr.length;

        for ( int i = 1; i < n ; i++){
            int j = i - 1;
            int key = arr[i];
            int loc = binarySearch(arr, 0, j, key);
            while (j >= loc ){
                arr[j + 1 ] = arr[j];
                j = j -1;
            }
            arr[j + 1] = key;
        }
    }

    public static int binarySearch(int[] arr, int low, int high, int key)
    {
        if ( low >= high ){
            return  arr[low] < key ? low + 1 : low ;
        }

        int mid = ( low + high ) / 2;

        if (arr[mid] == key){
            return mid;
        }
        else if (key < arr[mid]){
            return binarySearch(arr, low, mid - 1, key);
        } else {
            return binarySearch(arr, mid + 1, high, key);
        }
    }

}
