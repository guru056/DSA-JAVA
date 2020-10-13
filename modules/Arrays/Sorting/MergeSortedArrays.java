package Arrays.Sorting;

import Utils.ArrayUtils;
import Utils.HeapUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
public class MergeSortedArrays {

    public static void main(String[] args) {

        int[] arr1 = {4, 5, 6, 7};
        int[] arr2 = {1, 2, 3};

        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 5, 6, 7};

        int[] arr5 = {1, 2, 6};
        int[] arr6 = {3, 4, 5, 7};

        mergeAndPrintArrays(arr1, arr2);
        mergeAndPrintArrays(arr3, arr4);
        mergeAndPrintArrays(arr5, arr6);
    }

    public static void mergeAndPrintArrays(int[] arr1, int[] arr2) {
        mergeSortedArrays(arr1, arr2);
        ArrayUtils.printArr(arr1);
        ArrayUtils.printArr(arr2);
        System.out.println();
    }

    /**
     * i) For every element in First array(a[i]) compare it with the first element of 2nd array(b[0]).
     * ii) if(a[i] > b[0]) then do
     * swap(a[i],b[0]);
     * heapify(b);
     * //idea is that first element of 2nd array must always contain the smallest element
     * O(N + MlogN)
     *
     * @param arr1
     * @param arr2
     */
    public static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr2[i]);
        }
        for (int i = 0; i < m; i++) {
            if (arr1[i] > pq.peek()) {
                int temp = arr1[i];
                arr1[i] = pq.poll();
                pq.add(temp);
            }
        }
        int index = 0;
        while (!pq.isEmpty()) {
            arr2[index++] = pq.poll();
        }
    }

    public static void mergeSortedArraysV2(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        HeapUtils.buildMinHeap(arr2);
        for (int i = 0; i < m; i++) {
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                HeapUtils.minHeapify(0, arr2);
            }
        }
        Arrays.sort(arr2);
    }
}
