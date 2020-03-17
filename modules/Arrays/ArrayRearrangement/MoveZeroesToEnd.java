package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class MoveZeroesToEnd {

//    https://www.geeksforgeeks.org/move-zeroes-end-array/
//    https://www.geeksforgeeks.org/move-zeroes-end-array-set-2-using-single-traversal/
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 0, 3, 6};
        moveZeroesToEnd(arr);
        ArrayUtils.printArr(arr);

        int[] arr1 = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        moveZeroesToEndV2(arr1);
        ArrayUtils.printArr(arr1);
    }

    public static void moveZeroesToEnd(int[] arr)
    {
        int count = 0 ;
        for (int i = 0 ; i < arr.length; i++){
            if (arr[i] != 0 )
                arr[count++] = arr[i];
        }
        while (count < arr.length){
            arr[count++] = 0;
        }
    }

    public static void moveZeroesToEndV2(int[] arr)
    {
        int count = 0 ;
        for (int i = 0 ; i < arr.length; i++){
            if (arr[i] != 0 ){
                if (i != count)
                    ArrayUtils.swap(arr, i , count);
                count++;
            }
        }
    }
}
