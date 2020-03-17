package Arrays.SearchingProblems;

import Utils.ArrayUtils;

public class FIndTwoRepeatingElements {

//    https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
    public static void main(String[] args) {
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        printRepeatingElements(arr);
        printRepeatingElementsV2(arr);
    }

    public static void printRepeatingElements(int[] arr)
    {
        int size = arr.length;
        int n = size - 2;
        int sum = ArrayUtils.getSum(arr);
        int product = ArrayUtils.getProduct(arr)/fact(n);
        int x = 0, y = 0, diff = 0;

        sum = sum - (n*(n + 1))/2;
        diff = (int)Math.sqrt( sum * sum - 4*product);

        x = (sum + diff) / 2;
        y = (sum - diff) / 2;

        System.out.println("Repeating Elements : " + x + " , " + y );
    }

    public static void printRepeatingElementsV2(int[] arr)
    {
        for (int i = 0 ; i < arr.length; i++){
            if (arr[Math.abs(arr[i])] < 0 ){
                System.out.print(Math.abs(arr[i]) + " ");
            } else {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
        }
    }

    private static int fact(int n ){
        if (n == 0)
            return 1;
        return n*fact(n-1);
    }
}
