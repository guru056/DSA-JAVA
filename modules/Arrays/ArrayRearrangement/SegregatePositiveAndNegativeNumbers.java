package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class SegregatePositiveAndNegativeNumbers {

    public static void main(String[] args) {
        int[] arr = {2,3,-7,6,8,1,-10,15};
        segregate(arr);
        ArrayUtils.printArr(arr);
    }
    public static void segregate(int[] arr)
    {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[right] > 0) {
                right--;
            } else {
                ArrayUtils.swap(arr, left, right);
                left++;
            }
        }
    }

    public static int getFirstPositiveElementIndexAfterSegregation(int[] arr)
    {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[right] > 0) {
                right--;
            } else {
                ArrayUtils.swap(arr, left, right);
                left++;
            }
        }
        return left;
    }
}
