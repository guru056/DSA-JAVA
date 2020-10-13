package Arrays.Sorting;

import Utils.ArrayUtils;

//https://www.geeksforgeeks.org/sort-array-0s-1s-2s-simple-counting/
//https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
//https://leetcode.com/problems/sort-colors/
public class Sort012 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
//        sort012(arr);
        sort012V2(arr);
        ArrayUtils.printArr(arr);
    }
    /**
     * Sort an array of 0s, 1s and 2s
     * Input: {0, 1, 2, 0, 1, 2}
     * Output: {0, 0, 1, 1, 2, 2}
     *
     * 3 way partitioning approach
     * @param arr
     */
    public static void sort012(int[] arr)
    {
        int n       = arr.length;
        int low     = 0;
        int mid  = 0;
        int high    = n - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    ArrayUtils.swap(arr,low++,mid++);
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    ArrayUtils.swap(arr, mid, high--);
                    break;
            }
        }
    }

    public static void sort012V2(int[] arr)
    {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }
        int index = 0;
        while (count0-- > 0) {
            arr[index++] = 0;
        }
        while (count1-- > 0) {
            arr[index++] = 1;
        }
        while (count2-- > 0) {
            arr[index++] = 2;
        }
    }
}
