package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

import java.util.Arrays;

public class RearrangeArrayArrayIArrayJEvenArrayI {

//    https://www.geeksforgeeks.org/rearrange-array-arri-arrj-even-arri/
   /**
    *  Given an array of n elements. Our task is to write a program to rearrange the array such that
    * elements at even positions are greater than all elements before it and
    * elements at odd positions are less than all elements before it.
    */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr1 = {1, 2, 1, 4, 5, 6, 8, 8};

        rearrange(arr);
        ArrayUtils.printArr(arr);

        rearrange(arr1);
        ArrayUtils.printArr(arr1);
    }

    public static void rearrange(int[] arr)
    {
        //assuming n >=2
        int n = arr.length;
        int[] tempArr = new int[n];
        for (int i = 0 ; i < n ; i++){
            tempArr[i] = arr[i];
        }
        Arrays.sort(tempArr);

        int lastOddPosition = (n % 2 == 0 ) ? n -2 : n - 1;
        int k = 0 ;
        int i = lastOddPosition;
        while (i >= 0){
            arr[i] = tempArr[k++];
            i -= 2;
        }
        i = 1;
        while (i < n){
            arr[i] = tempArr[k++];
            i += 2;
        }
    }
}
