package Heaps;

import Utils.ArrayUtils;

public class HeapUtils {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,6,7};
        buildMaxHeap(arr);
        ArrayUtils.printArr(arr);
        buildMinHeap(arr);
        ArrayUtils.printArr(arr);
    }

    public static void buildMaxHeap(int[] arr){
        int n = arr.length;
        for (int i = n/2 -1; i>=0; i--){
            maxHeapify(i,arr);
        }
    }

    public static void buildMinHeap(int[] arr ){
        int n = arr.length;
        for (int i = n/2 -1; i>=0; i--){
            minHeapify(i,arr);
        }
    }

    public static void maxHeapify(int index, int[] arr){
        int l = 2*index + 1;
        int r = 2*index + 2;
        int largest = index;

        if ( l < arr.length && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < arr.length && arr[r] > arr[largest]){
            largest = r;
        }

        if (largest != index){
            ArrayUtils.swap(arr, index, largest);
            maxHeapify(largest, arr);
        }
    }

    public static void minHeapify(int index, int[] arr){
        int l = 2*index + 1;
        int r = 2*index + 2;
        int smallest = index;

        if ( l < arr.length && arr[l] < arr[smallest]){
            smallest = l;
        }
        if (r < arr.length && arr[r] < arr[smallest]){
            smallest = r;
        }

        if (smallest != index){
            ArrayUtils.swap(arr, index, smallest);
            minHeapify(smallest, arr);
        }
    }

    //heapify a section of the array -- heapify the array till size n (n <= arr.length)
    public static void maxHeapifySubarray(int[] arr, int index, int n){
        int l = 2*index + 1;
        int r = 2*index + 2;
        int largest = index;

        if ( l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }

        if (largest != index){
            ArrayUtils.swap(arr, index, largest);
            maxHeapifySubarray(arr, largest, n);
        }
    }
}
