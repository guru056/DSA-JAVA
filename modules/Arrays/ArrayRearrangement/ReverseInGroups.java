package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

//https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/
public class ReverseInGroups {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        reverseInGroups(arr, k);
        ArrayUtils.printArr(arr);
    }
    public static void reverseInGroups(int[] arr, int k)
    {
        int n = arr.length;
        if (k > n) {
            k = n;
        }
        int i = 0 ;
        int end ;
        while (i < n) {
            end = (i + k - 1 ) > (n - 1) ? n - 1 : (i + k - 1);
            ArrayUtils.reverse(arr, i, end);
            i += k;
        }
    }
}
