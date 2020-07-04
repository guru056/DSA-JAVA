package Arrays.OptimizationProblems;

//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class LargestSumContiguousSubarray {

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr1[] = {-4, -3, -2};

        System.out.println(largestSubarraySum(arr));
        printLargestSumContiguousSubarray(arr);

        System.out.println(largestSubarraySum(arr1));
        printLargestSumContiguousSubarray(arr1);
    }

    public static int largestSubarraySum(int[] arr)
    {
        int currMax = arr[0] ;
        int maxSoFar = arr[0];

        for (int i = 0 ; i < arr.length; i++){
            currMax = Math.max(currMax + arr[i], arr[i] );
            maxSoFar = Math.max(maxSoFar, currMax); // end will keep updating to i here if maxSoFar changes.
        }

        return maxSoFar;
    }

    public static void printLargestSumContiguousSubarray(int[] arr)
    {
        int currMax = arr[0] ;
        int maxSoFar = arr[0];
        int start = 0 ;
        int end = 0;
        int s = 0;

        for (int i = 0 ; i < arr.length; i++){
            currMax += arr[i];

            if (currMax < arr[i]){
                s = i ;
                end = i;
                currMax = arr[i];
            }

            if (maxSoFar < currMax){
                start = s;
                end = i;
                maxSoFar = currMax;
            }

        }
        System.out.println("Start Index : " + start + " , End Index : " + end);
    }
}
