package Arrays.ArrayRearrangement;

import Utils.ArrayUtils;

import java.util.HashSet;

public class RearrangeArrayArrayI {

//    https://www.geeksforgeeks.org/rearrange-array-arri/
    public static void main(String[] args) {
        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4,-1};
        rearrangeArray(arr);
        rearrangeArrayV2(arr);
        ArrayUtils.printArr(arr);
    }


    public static void rearrangeArray(int[] arr)
    {
        for (int i = 0 ; i < arr.length; i++){
            if (arr[i] == -1 || arr[i] == i)
                continue;
            while (arr[i] != -1 && arr[i] != i){
                ArrayUtils.swap(arr, i, arr[i]);
            }
        }
        //implementation on GFG
//        for (int i = 0; i < arr.length;) {
//            if (arr[i] >= 0 && arr[i] != i) {
//                int ele = arr[arr[i]];
//                arr[arr[i]] = arr[i];
//                arr[i] = ele;
//            } else {
//                i++;
//            }
//        }
    }

    public static void rearrangeArrayV2(int[] arr){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0 ; i < arr.length; i++){
            hashSet.add(arr[i]);
        }
        for (int i = 0 ; i < arr.length; i++){
            arr[i] = hashSet.contains(i) ? i : -1;
        }
    }
}
