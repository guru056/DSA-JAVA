package Arrays.SearchingProblems;

public class KthElementOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 6, 7, 9};
        int[] arr2 = new int[]{1, 4, 8, 10};

        for (int k = 1; k <= 9; k++)
            System.out.println(getKth(arr1, arr2, k));
    }
    /**
     * Input : Array 1 - 2 3 6 7 9
     *         Array 2 - 1 4 8 10 12
     *         k = 5
     *
     * Input : Array 1 - 100 112 256 290 349 770
     *         Array 2 - 72 86 113 119 265 445 892
     *         k = 7
     * Output : 256
     * Explanation: Final sorted array is -
     * 72, 86, 100, 112, 113, 119, 256, 265, 290, 349, 445, 770, 892
     * 7th element of this array is 256.
     * @param arr1 (sorted)
     * @param arr2 (sorted)
     * @param k
     * @return
     */
    public static int getKth(int[] arr1, int[] arr2, int k) {
        return getKthRecursive(arr1, arr2, 0, arr1.length - 1, 0, arr2.length - 1, k-1 );
    }

    public static int getKthRecursive(int[] arr1, int[] arr2, int start1, int end1, int start2, int end2, int k) {

        if (start1 == end1)
            return arr2[k];
        if (start2 == end2)
            return arr1[k];

        int mid1 = (start1 + end1) / 2;
        int mid2 = (start2 + end2) / 2;

        if (mid1 + mid2 < k) {
            if (arr1[mid1] < arr2[mid2]) {
                return getKthRecursive(arr1, arr2, mid1+1, end1, start2, end2, k - mid1-1);
            } else {
                return getKthRecursive(arr1, arr2, start1, end1, mid2+1, end2, k - mid2-1);
            }
        } else {
            if (arr1[mid1] > arr2[mid2]) {
                return getKthRecursive(arr1, arr2, start1, mid1, start2, end2, k);
            } else {
                return getKthRecursive(arr1, arr2, start1, end1, start2, mid2, k);
            }
        }
    }
}
