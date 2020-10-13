package Misc;

//https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k
public class LargestSubarrayWithSumAtmostK {

    public static void main(String[] args) {
        int[] arr = {5,2,-1,0,3};
        int k = 1;

        int[] arr1 = {1, 2, 1, 0, 1, 1, 0};
        int k1 = 4;

        int[] arr2 = {5,4,3,2};
        int k2 = 2;

        int[] arr3 = {1,2,3,5};
        int k3 = 5;


       printLargestSubarrayWithSumAtMostK(arr, k);
       printLargestSubarrayWithSumAtMostK(arr1, k1);
       printLargestSubarrayWithSumAtMostK(arr2, k2);
       printLargestSubarrayWithSumAtMostK(arr3, k3);
    }

    public static void printLargestSubarrayWithSumAtMostK(int[] arr, int k) {
        System.out.println("Window Length: " + largestSubarrayWithSumAtMostK(arr, k));
        System.out.println();
    }

    public static int largestSubarrayWithSumAtMostK(int[] arr, int k) {
        int sum = 0;
        int windowLen = 0;
        int maxWindowLen = 0;
        int endIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum <= k) {
                windowLen++;
            } else if ( i < arr.length - 1 && sum + arr[i+1] <= k) {
                    windowLen++;
                    continue;
            }else{
                sum -= arr[i-windowLen];
            }
            if (windowLen > maxWindowLen) {
                maxWindowLen = windowLen;
                endIndex = i;
            }
        }

        //print the subarray
        int startIndex = endIndex - maxWindowLen + 1;
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maxWindowLen;
    }
}
