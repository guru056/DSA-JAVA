package Arrays.SearchingProblems;

import Utils.ArrayUtils;

public class MaximumEquilibriumSumArray {
    public static void main(String[] args) {
        int[] arr = {-2, 5, 3, 1, 2, 6, -4, 2 };
        System.out.println("Equilibrium Sum: " + findMaxEquilibriumSum(arr));
        System.out.println("Equilibrium Sum: " + findMaxEquilibriumSumV2(arr));
    }

    public static int findMaxEquilibriumSum(int[] arr)
    {
        int sum = ArrayUtils.getSum(arr);
        int maxSum = Integer.MIN_VALUE;
        int leftSum = arr[0];
        int rightSum = sum;

        for (int i = 1; i < arr.length; i++){
            leftSum += arr[i];
            rightSum -= arr[i - 1];
            if (leftSum == rightSum && maxSum < rightSum){
                maxSum = rightSum;
            }
        }
        if (maxSum == Integer.MIN_VALUE){
            System.out.println("Equilibrium Sum Not Found In array");
        }
        return maxSum;
    }

    public static int findMaxEquilibriumSumV2(int[] arr)
    {
        int sum = ArrayUtils.getSum(arr);
        int maxSum = Integer.MIN_VALUE;
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++){
            leftSum += arr[i];
            if (leftSum == sum && maxSum < sum){
                maxSum = sum;
            }
            sum -= arr[i];
        }
        if (maxSum == Integer.MIN_VALUE){
            System.out.println("Equilibrium Sum Not Found In array");
        }
        return maxSum;
    }


}
