package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class RearrangeNegativeAndPositiveNumbers {

//    https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
//    https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
//    https://www.geeksforgeeks.org/move-ve-elements-end-order-extra-space-allowed/
    public static void main(String[] args) {
        int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};

        //All negative numbers first and then positive numbers
        rearrange(arr);
        ArrayUtils.printArr(arr);
        rearrangeV2(arr);
        ArrayUtils.printArr(arr);

        //All positive numbers first and then negative numbers
        rearrangeV3(arr);
        ArrayUtils.printArr(arr);
        rearrangeV4(arr);
        ArrayUtils.printArr(arr);
    }

    //if order of elements is not important
    public static void rearrange(int[] arr)
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
    public static void rearrangeV2(int[] arr)
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

    public static void rearrangeV3(int[] arr)
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

    public static void rearrangeV4(int[] arr)
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
}
