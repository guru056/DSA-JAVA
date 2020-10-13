package Arrays.OptimizationProblems;

//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class LargestSumContiguousSubarray {

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr1[] = {-4, -3, -2};

        System.out.println(largestSubarraySum(arr));
        printLargestSumContiguousSubarrayV2(arr);

        System.out.println(largestSubarraySum(arr1));
        printLargestSumContiguousSubarrayV2(arr1);
    }

    public static int largestSubarraySum(int[] arr)
    {
        int currMax = arr[0] ;
        int maxSoFar = arr[0];

        for (int i = 1 ; i < arr.length; i++){
            currMax = Math.max(currMax + arr[i], arr[i] );
            maxSoFar = Math.max(maxSoFar, currMax); // end will keep updating to i here if maxSoFar changes.
        }

        return maxSoFar;
    }

    public static void printLargestSumContiguousSubarrayV2(int[] arr)
    {
        int currMax = arr[0] ;
        int maxSoFar = arr[0];
        int start = 0 ;
        int end = 0;

        for (int i = 1; i < arr.length; i++) {
            currMax += arr[i];
            if (currMax < arr[i]) {
                currMax = arr[i];
                start = i;
                end = i;
            }

            if (currMax > maxSoFar) {
                end = i;
                maxSoFar = currMax;
            }
        }
        System.out.println("Max Sum: " + maxSoFar);
        System.out.println("Start: " + start + " , End: " + end);
    }
}
