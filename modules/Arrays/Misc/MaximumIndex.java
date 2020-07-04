package Arrays.Misc;

//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class MaximumIndex {


    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int[] arr1 = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {6, 5, 4, 3, 2, 1};

        System.out.println(maxIndex(arr));
        System.out.println(maxIndex(arr1));
        System.out.println(maxIndex(arr2));
        System.out.println(maxIndex(arr3));
    }
    /**
     * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
     * Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
     *   Output: 6  (j = 7, i = 1)
     *
     *   Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
     *   Output: 8 ( j = 8, i = 0)
     *
     *   Input:  {1, 2, 3, 4, 5, 6}
     *   Output: 5  (j = 5, i = 0)
     *
     *   Input:  {6, 5, 4, 3, 2, 1}
     *   Output: -1
     * @param arr
     * @return
     */
    public static int maxIndex(int[] arr)
    {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i-1], arr[i]);
        }

        right[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        int i = 0 ;
        int j = 0 ;
        int maxDiff = -1;

        while (i < n && j < n) {
            if (left[i] < right[j]) {
                maxDiff = Math.max(maxDiff, j-i);
                j += 1;
            } else {
                i += 1;
            }
        }
        return maxDiff;
    }
}
