package Arrays.OrderStatistics;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] arr1 = {1,2,3,3,2};
        int[] arr2 = {1,2,2,2,2};
        int[] arr3 = {1,1,1,1,1};

        System.out.println(secondLargest(arr));
        System.out.println(secondLargest(arr1));
        System.out.println(secondLargest(arr2));
        System.out.println(secondLargest(arr3));

    }
    public static int secondLargest(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return Integer.MIN_VALUE;
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        for (int i = 0 ; i < n; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax && arr[i] != firstMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
}
