package Arrays.Sorting;

import Arrays.SearchingProblems.FloorAndCeilInASortedArray;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-number-pairs-xy-yx/
public class NumberOfPairs {

    public static void main(String[] args) {
        int[] X = {2,1,6};
        int[] Y = {1,5};

        int[] X1 = {10, 19, 18};
        int[] Y1 = {11, 15, 9};

        System.out.println(getNumberOfPairs(X,Y));
        System.out.println(getNumberOfPairs(X1,Y1));
    }

    /**
     *
     * @param X
     * @param Y
     * @return
     */
    public static int getNumberOfPairs(int[] X, int[] Y)
    {
        int m = X.length;
        Arrays.sort(Y); // O(NLogN)
        int[] count = new int[5];
        for (int i = 0 ; i < count.length; i++) {
            count[i] = getElementCountInSortedArray(Y, i); // O(logN)
        }
        int result = 0;

        for (int i = 0 ; i < m; i++) { // O(MLogN)
            if (X[i] == 0)
                continue;
            if (X[i] == 1) {
                result += count[0];
                continue;
            }
            int upperBound = FloorAndCeilInASortedArray.findStrictCeilUtil(Y, X[i]);
            if (upperBound != -1) {
                result += (m - upperBound + count[0] + count[1]);
            }
            if ( X[i] == 2 ) {
                result -= (  count[3] + count[4]);
                continue;
            }
            if (X[i] == 3){
                result +=  count[2];
                continue;
            }
        }
        return result;
    }

    /** Get Element Count in a sorted array in O(LogN) time
     * @param arr
     * @param key
     * @return
     */
    public static int getElementCountInSortedArray(int[] arr, int key)
    {
        int firstOccurrence = getFirstOccurrence(arr, 0, arr.length-1, key);
        if (firstOccurrence == -1)
            return 0;

        int lastOccurrence = getLastOccurrence(arr, 0, arr.length- 1,key);
        return lastOccurrence - firstOccurrence + 1;
    }

    public static int getFirstOccurrence(int[] arr, int begin, int end, int key) {
        if (begin > end) return -1;
        int mid = (begin + end) / 2;

        if (key > arr[mid]) {
            return getFirstOccurrence(arr, mid+1,end, key);
        } else if (key < arr[mid]) {
            return getFirstOccurrence(arr, begin, mid - 1, key);
        } else if (mid == 0 || arr[mid - 1] != key) {
            return mid;
        } else {
            return getFirstOccurrence(arr, begin, mid - 1, key);
        }
    }

    public static int getLastOccurrence(int[] arr, int begin, int end, int key) {
        if (begin > end) return -1;
        int mid = (begin + end) / 2;

        if (key > arr[mid]) {
            return getLastOccurrence(arr, mid+1,end, key);
        } else if (key < arr[mid]) {
            return getLastOccurrence(arr, begin, mid - 1, key);
        } else if (mid == arr.length-1 || arr[mid + 1] != key) {
            return mid;
        } else {
            return getLastOccurrence(arr, mid+1, end, key);
        }
    }

}
