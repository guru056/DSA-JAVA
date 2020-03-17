package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class RearrangeArrayArrayJI {

//    https://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 2};
//        rearrangeNaive(arr);
        rearrange(arr);
        ArrayUtils.printArr(arr);
    }

    public static void rearrangeNaive(int[] arr)
    {
        int n = arr.length;
        int[] temp = new int[n];

        for (int i = 0 ; i < n ; i++){
            temp[arr[i]] = i;
        }

        for (int i = 0 ; i < n; i++){
            arr[i] = temp[i];
        }
    }

    public static void rearrange(int[] arr)
    {
        int n = arr.length;

        for (int i = 0 ; i < n; i++){
            arr[arr[i] % n] += i * n;
        }

        for (int i = 0 ; i < n; i++){
            arr[i] /= n;
        }
    }
}
