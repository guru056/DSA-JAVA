package Arrays.Misc;

import Utils.ArrayUtils;

//https://www.geeksforgeeks.org/minimum-number-of-swaps-required-to-sort-an-array-of-first-n-number/
public class MinimumSwaps {


    public static void main(String[] args) {
        int[] arr = {7,1,3,2,4,5,6};
        int[] arr1 = {2,3,4,1,5};
        System.out.println(getMinimumSwapsRequired(arr));
        System.out.println(getMinimumSwapsRequired(arr1));
    }
    public static int getMinimumSwapsRequired(int[] arr)
    {
        int swapCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1)
                continue;
            while (arr[i] != (i+1)) {
                ArrayUtils.swap(arr, i , arr[i]-1);
                swapCount++;
            }
        }
        return swapCount;
    }
}
