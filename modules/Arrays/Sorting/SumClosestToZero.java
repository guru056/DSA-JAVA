package Arrays.Sorting;

import java.util.Arrays;

//https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
public class SumClosestToZero {

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
        int minDiff = Integer.MAX_VALUE;
        int sum ;
        while (left < right) {
            sum = arr[left] + arr[right];
            if ( sum < 0 ){
                left++;
            } else {
                right--;
            }
            minDiff = Math.min(minDiff, Math.abs(sum));
        }
    }

}
