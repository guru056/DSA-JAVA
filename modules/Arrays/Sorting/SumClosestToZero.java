package Arrays.Sorting;

import java.util.Arrays;

//https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
public class SumClosestToZero {

    public static void main(String[] args) {
        int[] arr = {1, 60, -10, 70, -80, 85};
        int[] arr1 = {15, 5, -20, 30, -45};

        printElementsWithSumClosestToZero(arr);
        printElementsWithSumClosestToZero(arr1);
    }
    /**
     * int arr[] = {1, 60, -10, 70, -80, 85};
     * {-80, -10, 1, 60, 70, 85}
     *
     *  [15, 5, -20, 30, -45]
     *  [-45, -20, 5, 15, 30]
     * @param arr
     */
    public static void printElementsWithSumClosestToZero(int[] arr)
    {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int resultLeft = -1, resultRight = -1;
        int minDiff = Integer.MAX_VALUE;
        int sum ;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (Math.abs(sum) < minDiff) {
                resultLeft = left;
                resultRight = right;
                minDiff = Math.abs(sum);
            }
            if ( sum < 0 ){
                left++;
            } else {
                right--;
            }
        }
        System.out.println(arr[resultLeft] + " , " + arr[resultRight]);
    }

}
