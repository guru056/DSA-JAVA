package Arrays.SearchingProblems;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int ar1[] = { 1, 2, 3, 6 };
        int ar2[] = { 4, 5, 8, 10 };

        int ar3[] = { 1, 2, 3, 6 };
        int ar4[] = { 4, 6, 8, 10 };

        int ar5[] = { 1, 12, 15, 26, 38 };
        int ar6[] = { 2, 13, 17, 30, 45 };

        System.out.println(getMedianForSortedArrays(ar1,ar2));
        System.out.println(getMedianForSortedArrays(ar3,ar4));
        System.out.println(getMedianForSortedArrays(ar5,ar6));
    }

    public static int getMedianForSortedArrays(int[] arr1, int[] arr2) {
        return getMedianOfSortedArraysRecursive(arr1, arr2, 0, arr1.length -1 , 0, arr2.length - 1);
    }

    private static int getMedianOfSortedArraysRecursive(int[] arr1, int[] arr2, int begin1, int end1, int begin2, int end2) {
        if (end1 - begin1 == 1) {
            return (Math.max(arr1[begin1], arr2[begin2]) + Math.min(arr1[end1], arr2[end2])) / 2;
        }

        int m1 = getMedian(arr1, begin1, end1);
        int m2 = getMedian(arr2, begin2, end2);

        int n1 = end1 - begin1 + 1;
        int n2 = end2 - begin2 + 1;

        int mid1 = (begin1 + end1 ) / 2;
        int mid2 = (begin2 + end2 ) / 2;

        if (m1 == m2)
            return m1;
        else if (m1 > m2) {
            return getMedianOfSortedArraysRecursive(arr1, arr2, begin1, mid1, n2%2 != 0 ? mid2: (mid2 +1), end2);
        } else {
            return getMedianOfSortedArraysRecursive(arr1, arr2, n1%2 != 0 ? mid1: (mid1 +1), end1, begin2, mid2);
        }
    }

    private static int getMedian(int[] arr, int begin, int end) {
        int n = end - begin + 1;
        if (n % 2 != 0) {
            return arr[begin + (n/2)];
        } else {
            return (arr[begin + (n/2)] + arr[begin + ((n/2)-1)]) / 2;
        }
    }
}
