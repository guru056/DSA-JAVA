package Arrays.SearchingProblems;

import Utils.ArrayUtils;

//https://www.geeksforgeeks.org/find-the-missing-number/
public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        printMissingNumber(arr);
    }

    public static void printMissingNumber(int[] arr)
    {
        System.out.println(getMissingNumber(arr));
        System.out.println(getMissingNumberV2(arr));
    }

    /**
     * This approach takes care of the integer overflow.
     * This tries to calculate the sum of 1 - n+1 and sum of all array elements
     * in the same loop
     * @param arr
     * @return
     */
    public static int getMissingNumber(int[] arr)
    {
        int n = arr.length;

        int total = 1;
        for (int i = 2; i <= n+1; i++) { // numbers range from 1 to n+1
            total += i;
            total -= arr[i-2];
        }
        return total;
    }

    public static int getMissingNumberV2(int[] arr)
    {
        int n = arr.length;
        int sum = ArrayUtils.getSum(arr);

        int sumTotal = ((n+1)*(n+2)) / 2;
        return sumTotal - sum;
    }
}
