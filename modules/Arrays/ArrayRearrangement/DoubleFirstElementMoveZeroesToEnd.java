package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class DoubleFirstElementMoveZeroesToEnd {

//    https://www.geeksforgeeks.org/double-first-element-move-zero-end/
    public static void main(String[] args) {
        int arr[] = { 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 };
        rearrqange(arr);
        ArrayUtils.printArr(arr);
    }

    public static void rearrqange(int[] arr)
    {
        int n = arr.length;
        for (int i = 0 ; i < n - 1; i++){
            if (arr[i] != 0 && arr[i] == arr[i + 1]){
                arr[i] *= 2;
                arr[i + 1] = 0 ;
                i++;
            }
        }
        MoveZeroesToEnd.moveZeroesToEndV2(arr);
    }
}
