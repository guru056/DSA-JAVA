package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

public class RearrangeArrayMaximumMinimumForm {

//    https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
//    https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
//    https://www.geeksforgeeks.org/rearrange-array-order-smallest-largest-2nd-smallest-2nd-largest/
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rearrangeNaive(arr);
        ArrayUtils.printArr(arr);

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rearrange(arr1);
        ArrayUtils.printArr(arr1);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rearrangeV2(arr2);
        ArrayUtils.printArr(arr2);
    }

    public static void rearrangeNaive(int[] arr)
    {
        int n = arr.length;
        int[] temp = new int[n];
        int small = 0;
        int large = n - 1 ;
        boolean flag = true;

        for (int i = 0 ; i < n; i++){
            if (flag)
                temp[i] = arr[large--];
            else
                temp[i] = arr[small++];
            flag = !flag;
        }

        for (int i = 0 ; i < n; i++){
            arr[i] = temp[i];
        }
    }

    public static void rearrange(int[] arr)
    {
        int n = arr.length;
        int maxIndex = n - 1;
        int minIndex = 0;
        int maxElement  = arr[maxIndex] + 1;

        for (int i = 0 ; i < n ; i ++){
            if (i % 2 == 0){
                arr[i] += (arr[maxIndex--] % maxElement) * maxElement;
            } else {
                arr[i] += (arr[minIndex++] % maxElement) * maxElement;
            }
        }
        for (int i = 0 ; i < n ; i ++){
            arr[i] /= maxElement;
        }
    }

    public static void rearrangeV2(int[] arr)
    {
        int n = arr.length;
        int maxIndex = n - 1;
        int minIndex = 0;
        int maxElement  = arr[maxIndex] + 1;

        for (int i = 0 ; i < n ; i ++){
            if (i % 2 == 0){
                arr[i] += (arr[minIndex++] % maxElement) * maxElement;
            } else {
                arr[i] += (arr[maxIndex--] % maxElement) * maxElement;
            }
        }
        for (int i = 0 ; i < n ; i ++){
            arr[i] /= maxElement;
        }
    }
}
