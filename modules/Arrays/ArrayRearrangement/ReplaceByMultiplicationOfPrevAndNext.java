package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class ReplaceByMultiplicationOfPrevAndNext {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6};
        modify(arr);
        ArrayUtils.printArr(arr);

        int[] arr2 = {2, 3, 4, 5, 6};
        modifyV2(arr2);
        ArrayUtils.printArr(arr2);
    }
    public static void modify(int[] arr)
    {
        int prev = arr[0];
        int n =arr.length;
        arr[0] = arr[0] * arr[1];

        for (int i = 1; i < n - 1; i++){
            int curr = arr[i];
            arr[i] = prev * arr[i+1];
            prev = curr;
        }
        arr[n - 1] = prev*arr[n - 1];
    }

    public static void modifyV2(int[] arr)
    {
        int n = arr.length;
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0 ; i < n - 1 ; i++){
            if (maxElement < arr[i]*arr[i+1])
                maxElement =  arr[i]*arr[i+1];
        }
        maxElement += 1;
        arr[0] += arr[0]*arr[1]*maxElement;

        for (int i = 1; i < n - 1; i++ ){
            arr[i] += ((arr[i - 1]%maxElement ) * (arr[i+1]%maxElement))*maxElement;
        }
        arr[n - 1] +=  (arr[n-1]%maxElement) * (arr[n-2]%maxElement) * maxElement;

        for (int i = 0 ; i < n; i++){
            arr[i] /= maxElement;
        }
    }
}
