package Arrays.Sorting;

import Heaps.HeapUtils;
import Utils.ArrayUtils;

public class HeapSort {

    public static void main(String[] args)
    {
        int[] arr = {4,10,3,5,1};
        ArrayUtils.printArr(arr);
        heapSort(arr);
        ArrayUtils.printArr(arr);
    }
    public static void heapSort(int[] arr)
    {
        HeapUtils.buildMaxHeap(arr);
        int n = arr.length;

        for (int i = n - 1; i>0; i--){
            ArrayUtils.swap(arr, 0, i);
            HeapUtils.maxHeapifySubarray(arr, 0, i);
        }
    }
}
