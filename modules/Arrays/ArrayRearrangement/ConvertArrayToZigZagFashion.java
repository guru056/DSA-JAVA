package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

//https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
public class ConvertArrayToZigZagFashion {

    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        int[] arr1 = {1, 4, 3, 2};

        ArrayUtils.printArr(arr);
        convertToZigzag(arr);
        ArrayUtils.printArr(arr);

        ArrayUtils.printArr(arr1);
        convertToZigzag(arr1);
        ArrayUtils.printArr(arr1);
    }

    public static void convertToZigzag(int[] arr)
    {
        int n = arr.length;
        boolean flag = true;

        for (int i = 0 ; i < n - 1; i++){
            if (flag) {
                if (arr[i] > arr[i+1]){
                    ArrayUtils.swap(arr, i , i+1);
                }
            } else {
                if (arr[i] < arr[i+1]) {
                    ArrayUtils.swap(arr, i, i + 1);
                }
            }
            flag = !flag;
        }
    }
}
