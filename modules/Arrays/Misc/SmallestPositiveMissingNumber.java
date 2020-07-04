package Arrays.Misc;

import Arrays.ArrayRearrangement.SegregatePositiveAndNegativeNumbers;

//https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,-7,6,8,1,-10,15};
        int[] arr1 = {2, 3, 7, 6, 8, -1, -10, 15};
        int[] arr2 = {1, 1, 0, -1, -2};

//        System.out.println(getSmallestPositiveMissingNumber(arr));
//        System.out.println(getSmallestPositiveMissingNumber(arr1));
//        System.out.println(getSmallestPositiveMissingNumber(arr2));

        System.out.println(getSmallestPositiveMissingNumberV2(arr));
        System.out.println(getSmallestPositiveMissingNumberV2(arr1));
        System.out.println(getSmallestPositiveMissingNumberV2(arr2));
    }

    public static int getSmallestPositiveMissingNumber(int[] arr)
    {
        int left = SegregatePositiveAndNegativeNumbers.getFirstPositiveElementIndexAfterSegregation(arr);
        int index;

        for (int i = left; i < arr.length; i++) {
            index = left + Math.abs(arr[i]) - 1;
            if (index < arr.length && arr[index] > 0) {
                arr[index] = -arr[index];
            }
        }
        for (int i = left; i < arr.length; i++) {
            if (arr[i] > 0)
                return (i+1-left);
        }
        return arr.length + 1;
    }

    public static int getSmallestPositiveMissingNumberV2(int[] arr)
    {
        boolean[] present = new boolean[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] <= arr.length) {
                present[arr[i]]  =true;
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            if (!present[i])
                return i;
        }
        return arr.length + 1;
    }
}
