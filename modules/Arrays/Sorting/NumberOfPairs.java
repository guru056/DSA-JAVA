package Arrays.Sorting;

import Arrays.Searching.BinarySearch;
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
        Arrays.sort(Y);
        int[] count = new int[5];
        for (int i = 0 ; i < count.length; i++) {
            count[i] = getZeroesCountInSortedArray(Y, i);
        }
        int result = 0;

        for (int i = 0 ; i < m; i++) {
            if (X[i] == 0)
                continue;
            if (X[i] == 1) {
                result += count[0];
                continue;
            }
            int upperBound = getUpperBound(Y, X[i]);
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

    public static int getUpperBound(int[] arr, int key)
    {
        int index = FloorAndCeilInASortedArray.findCeilUtil(arr, key);
        if (index == -1)
            return -1;
        if (arr[index] != key)
            return index;
        while (index < arr.length && arr[index] == key)
            index++;
        return index == arr.length ? -1 : index;
    }

    public static int getZeroesCountInSortedArray(int[] arr, int key)
    {
        int index = BinarySearch.binarySearchUtil(arr, key);
        if (index == -1)
            return 0;
        int lastOccurrence = index;
        while (lastOccurrence < arr.length && arr[lastOccurrence] == key)
        {
            lastOccurrence++;
        }
        return lastOccurrence - index ;
    }
}
