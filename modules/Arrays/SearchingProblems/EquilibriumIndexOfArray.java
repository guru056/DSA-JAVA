package Arrays.SearchingProblems;

import Utils.ArrayUtils;

public class EquilibriumIndexOfArray {
//    https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println("Equilibrium Index : "+ findEquilibrium(arr));
    }

    public static int findEquilibrium(int[] arr)
    {
        int leftSum = 0;
        int sum = ArrayUtils.getSum(arr);

        for (int i = 0 ; i < arr.length; i++){
            sum -= arr[i];
            if (leftSum == sum)
                return i;
            leftSum += arr[i];
        }
        return -1;
    }
}
