package Arrays.Misc;

//https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
public class PartitionIndex {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        int[] arr1 = {5, 1, 4, 4};
        int[] arr2 = {4,3,2,7,8,9};
        int[] arr3 ={3, 4, 2, 1, 4, 7, 10, 12, 8, 35};

        printPartitionIndex(arr);
        printPartitionIndex(arr1);
        printPartitionIndex(arr2);
        printPartitionIndex(arr3);
    }

    public static void printPartitionIndex(int[] arr)
    {
        System.out.println(getPartitionIndex(arr));
        System.out.println(getPartitionIndexV2(arr));
        System.out.println();
    }

    public static int getPartitionIndex(int[] arr)
    {
        int n = arr.length;

        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        int[] rightMin = new int[n];
        rightMin[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (leftMax[i] == rightMin[i])
                return i;
        }

        return -1;
    }

    public static int getPartitionIndexV2(int[] arr)
    {
        int n = arr.length;

        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        int rightMin = arr[n-1];
        int result = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            rightMin = Math.min(rightMin, arr[i]);
            if (rightMin == leftMax[i])
                result = i;
        }

        return result == n -1 ? -1 : result;
    }
}
