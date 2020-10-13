package Arrays.Sorting;

import Utils.ArrayUtils;

import java.util.TreeSet;

//https://www.geeksforgeeks.org/counting-inversions-using-set-in-c-stl/
//https://www.geeksforgeeks.org/counting-inversions/
public class InversionsInArray {

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int[] arr1 = {3, 1, 2};
        int[] arr2 = {1, 2};

        System.out.println(countInversions(arr));
        System.out.println(countInversions(arr1));
        System.out.println(countInversions(arr2));

        System.out.println(countInversionsV2(arr));
        System.out.println(countInversionsV2(arr1));
        System.out.println(countInversionsV2(arr2));
    }

    public static int countInversions(int[] arr)
    {
//        int maxVal = ArrayUtils.getMaximum(arr) + 1;
        return countInversionsRecursive(arr, 0, arr.length - 1);
    }

    public static int countInversionsRecursive(int[] arr, int begin, int end)
    {
        if (begin >= end)
            return 0;
        int mid = (begin + end) / 2;
        int countLeft = countInversionsRecursive(arr, begin, mid);
        int countRight = countInversionsRecursive(arr, mid + 1 , end);
        int countMerged = merge(arr, begin, mid, end);
        return countLeft + countRight + countMerged;
    }

    public static int merge(int[] arr, int begin, int mid, int end)
    {
        int i = begin;
        int j = mid + 1;
        int k = begin;
        int inversionCount = 0;
        int maxVal = Math.max(arr[mid], arr[end]) + 1;

        while (i <= mid && j <= end) {
            if (arr[i] % maxVal <= arr[j] % maxVal) {
                arr[k++] += (arr[i++] % maxVal) * maxVal;
            } else {
                arr[k++] += (arr[j++] % maxVal) * maxVal;
                inversionCount += (mid - i + 1);
            }
        }
        while (i <= mid) {
            arr[k++] += (arr[i++] % maxVal) * maxVal;
        }
        while (j <= end) {
            arr[k++] += (arr[j++] % maxVal) * maxVal;
        }
        for (k = begin; k <= end; k++) {
            arr[k] /= maxVal;
        }
        return inversionCount;
    }

    public static int countInversionsV2(int[] arr)
    {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(arr[0]);

        int inversionCount = 0;
        for (int i = 1; i < arr.length; i++) {
            set.add(arr[i]);
            int x = set.headSet(arr[i], true).size();
            int y = set.size();

            inversionCount += (y - x);
        }
        return inversionCount;
    }
}
