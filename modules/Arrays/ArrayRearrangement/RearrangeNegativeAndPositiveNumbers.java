package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class RearrangeNegativeAndPositiveNumbers {

//    https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
//    https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
//    https://www.geeksforgeeks.org/move-ve-elements-end-order-extra-space-allowed/
    public static void main(String[] args) {
        int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};

        //All negative numbers first and then positive numbers
//        rearrangeNegativePositive(arr);
//        ArrayUtils.printArr(arr);
        rearrangeNegativePositiveV2(arr);
        ArrayUtils.printArr(arr);

        //All positive numbers first and then negative numbers
        rearrangePositiveNegative(arr);
        ArrayUtils.printArr(arr);
        rearrangePositiveNegativeV2(arr);
        ArrayUtils.printArr(arr);
//
        rearrangePositiveNegativeV3(arr);
        ArrayUtils.printArr(arr);
    }

    /**
     * int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};
     * @param arr
     */
    public static void rearrangePractice(int[] arr)
    {
        int right = arr.length-1 ;
        int left = 0;
        while (left < right) {
            if (arr[left] < 0){
                left++;
                continue;
            }
            ArrayUtils.swap(arr, left, right);
            right--;
        }
    }

    //if order of elements is not important
    public static void rearrangeNegativePositive(int[] arr)
    {
        int n = arr.length;
        int i = -1;
        for (int j = 0; j < n; j++){
            if (arr[j] < 0){
                i++;
                ArrayUtils.swap(arr, i , j);
            }
        }
    }

    //if order of elements is to be maintained
    public static void rearrangeNegativePositiveV2(int[] arr)
    {
        int n = arr.length;
        for (int i = 0 ; i < n; i++){
            int key = arr[i];
            if (key > 0 )
                continue;
            int j = i - 1;
            while (j >=0 && arr[j] > 0 ){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void rearrangePositiveNegative(int[] arr)
    {
        int n = arr.length;
        int i = -1;
        for (int j = 0; j < n; j++){
            if (arr[j] > 0){
                i++;
                ArrayUtils.swap(arr, i , j);
            }
        }
    }

    public static void rearrangePositiveNegativeV2(int[] arr)
    {
        int n = arr.length;
        for (int i = 0 ; i < n; i++){
            int key = arr[i];
            if (key < 0 )
                continue;
            int j = i - 1;
            while (j >=0 && arr[j] < 0 ){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    //NlogN solution
    public static void rearrangePositiveNegativeV3(int[] arr)
    {
        mergePositiveNegativeRecursive(arr, 0, arr.length-1);
    }
    public static void mergePositiveNegativeRecursive(int[] arr, int low, int high)
    {
        if (low >= high)
            return;
        int mid = ( low + high ) / 2;
        mergePositiveNegativeRecursive(arr, low, mid);
        mergePositiveNegativeRecursive(arr, mid + 1, high);
        merge(arr,low,mid,high);
    }

    public static void merge(int[] arr, int low, int mid, int high)
    {
        int m = mid - low + 1;
        int n = high - mid;

        int[] left = new int[m];
        int[] right = new int[n];

        for (int i = low,k=0; i <= mid; i++,k++) {
            left[k] = arr[i];
        }
        for (int i = mid+1,k=0; i <= high; i++,k++) {
            right[k] = arr[i];
        }

        int i = 0;
        int j = 0;
        int k = low;
        while (i < m && j < n) {
            if (left[i] >= 0) {
                arr[k++] = left[i++];
            } else if (right[j] >= 0) {
                arr[k++] = right[j++];
            } else{
                break;
            }
        }
        while (i < m) {
            arr[k++] = left[i++];
        }
        while (j < n) {
            arr[k++] = right[j++];
        }
    }
}
