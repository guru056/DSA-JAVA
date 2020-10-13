package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

import java.util.Arrays;

//https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
public class ConvertArrayToZigZagFashion {

    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        int[] arr1 = {1, 4, 3, 2};
        int[] arr2 = {1, 1, 1, 2, 3, 4};

        ArrayUtils.printArr(arr);
        convertToZigzag(arr);
        ArrayUtils.printArr(arr);

        ArrayUtils.printArr(arr1);
        convertToZigzag(arr1);
        ArrayUtils.printArr(arr1);

        ArrayUtils.printArr(arr2);
        convertToZigzag(arr2);
        ArrayUtils.printArr(arr2);

        int[] arr3 = {4, 3, 7, 8, 6, 2, 1};
        int[] arr4 = {1, 4, 3, 2};
        int[] arr5 = {1, 1, 1, 2, 3, 4};
        ArrayUtils.printArr(arr3);
        convertToZigZagV2(arr3);
        ArrayUtils.printArr(arr3);

        ArrayUtils.printArr(arr4);
        convertToZigZagV2(arr4);
        ArrayUtils.printArr(arr4);

        ArrayUtils.printArr(arr5);
        convertToZigZagV2(arr5);
        ArrayUtils.printArr(arr5);

    }

    /**
     * For DISTINCT elements only
     *
     * @param arr
     */
    public static void convertToZigzag(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    ArrayUtils.swap(arr, i, i + 1);
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    ArrayUtils.swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void convertToZigZagV2(int[] arr) {
        Arrays.sort(arr);
        int maxElement = arr[arr.length - 1] + 1;

        int i = 1;
        int majIndex = arr.length - 1;
        while (i < arr.length) {
            arr[i] += (arr[majIndex] % maxElement) * maxElement;
            i += 2;
            majIndex--;
        }

        i = 0;
        int minIndex = 0;
        while (i < arr.length) {
            arr[i] += (arr[minIndex] % maxElement) * maxElement;
            i += 2;
            minIndex++;
        }

        for (i = 0; i < arr.length; i++) {
            arr[i] /= maxElement;
        }
    }
}
