//package SlidingWindow;
//
//public class LongestContinuousSubarrayWithSumAtMostK {
//
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 1, 0, 1, 1, 0};
//        System.out.println(getLongestContinuousSubarrayWithSumAtMostK(arr,4));
//    }
//    public static int getLongestContinuousSubarrayWithSumAtMostK(int[] arr, int k)
//    {
//       int n = arr.length;
//       int windowLength = 0;
//       int maxWindowLength = 0;
//       int sum = 0;
//       int right = 0;
//
//       while (right < n) {
//           if (sum + arr[right] <= k) {
//               sum += arr[right];
//               windowLength++;
//               right++;
//           } else {
//                sum = sum + arr[right] - arr[right-windowLength];
//           }
//       }
//    }
//}
