package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

import java.util.Arrays;

//https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
public class Segregate01 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        segregate(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void segregate(int[] arr)
    {
        int n = arr.length;
        int left = 0 ;
        int right = n-1;

        while (left < right) {
            if (arr[left] == 0) {
                left++;
                continue;
            }
            ArrayUtils.swap(arr, left ,right);
            right--;
        }
    }
}
