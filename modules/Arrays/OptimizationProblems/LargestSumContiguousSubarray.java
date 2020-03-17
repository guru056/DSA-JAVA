package Arrays.OptimizationProblems;

public class LargestSumContiguousSubarray {

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(largestSubarraySum(arr));
        printLargestSumContigousSubarray(arr);
    }

    public static int largestSubarraySum(int[] arr)
    {
        int curr_max = 0 ;
        int maxSoFar = 0;

        for (int i = 0 ; i < arr.length; i++){
            curr_max = Math.max(curr_max + arr[i], arr[i] );
            maxSoFar = Math.max(maxSoFar, curr_max);
        }

        return maxSoFar;
    }

    public static void printLargestSumContigousSubarray(int[] arr)
    {
        int curr_max = 0 ;
        int maxSoFar = 0;
        int start = 0 ;
        int end = 0;
        int s = 0;

        for (int i = 0 ; i < arr.length; i++){
            curr_max += arr[i];

            if (maxSoFar < curr_max){
                start = s;
                end = i;
                maxSoFar = curr_max;
            }

            if (curr_max < 0){
                s = i + 1;
                curr_max = 0;
            }
        }

        System.out.println("Start Index : " + start + " , End Index : " + end);

    }
}
