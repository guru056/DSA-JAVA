package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class RearrangePositiveAndNegativeNumbers {

//    https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
//    https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , -4 , -1 , 4};
        int[] arr1 = {-5 , -2 , 5 , 2 , 4 , 7 , 1 , 8 , 0 , -8};
        int[] arr2= {-5 , -2 , 4 , 5 , 0 , 7 , 1 , 8 , 0 , -8};
//        rearrange(arr);
//        ArrayUtils.printArr(arr);
//        rearrange(arr1);
//        ArrayUtils.printArr(arr1);
        rearrangeV2(arr);
        ArrayUtils.printArr(arr);
        rearrangeV2(arr1);
        ArrayUtils.printArr(arr1);
        rearrangeV2(arr2);
        ArrayUtils.printArr(arr2);
    }

    public static void rearrange(int[] arr)
    {
        int n = arr.length;
        int i = -1;
        for (int j = 0 ; j < n; j++){
            if (arr[j] < 0){
                i++;
                ArrayUtils.swap(arr, i,j);
            }
        }
        int pos = i + 1;
        int neg = 0;

        while (pos < n && neg < pos && arr[neg] < 0){
            ArrayUtils.swap(arr, pos, neg);
            pos++;
            neg += 2;
        }
    }

    public static void rearrangeV2(int[] arr)
    {
        int n = arr.length;
        for (int i = 0 ; i < n; i++){
            if (!isOutOfPlace(arr,i))
                continue;

            int index = i + 1;
            if (arr[i] >= 0 ){
                while (index < n && arr[index] >= 0 ){
                    index++;
                }
            } else{
                while (index < n && arr[index] < 0 ){
                    index++;
                }
            }
            if (index >= n) break;
            rightRotate(arr, i, index);
        }
    }

    private static boolean isOutOfPlace(int[] arr, int index)
    {
        //An element is out of place if it is negative and at odd index, or it is positive and at even index
        //0 behaves as positive element here.
        if (index % 2 == 0 && arr[index] >= 0 )
            return true;
        if (index % 2 != 0 && arr[index] < 0 )
            return true;
        return false;
    }

    private static void rightRotate(int[] arr, int start, int end)
    {
        int key = arr[end];
        int j;
        for ( j = end; j > start; j--){
            arr[j] = arr[j - 1];
        }
        arr[j] = key;
    }
}
