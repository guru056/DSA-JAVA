package Arrays.Misc;

//https://www.geeksforgeeks.org/trapping-rain-water/
//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr1 = {3, 0, 2, 0, 4};
        int[] arr2 = {2, 0, 2};
        int[] arr3 = {4, 2, 3};
        int[] arr4 = {4, 0, 2, 3};
        int[] arr5 = {1, 7, 5};
        int[] arr6 = {0, 7, 1, 4, 6};
        int[] arr7 = {6,8,5,0,0,6,5};
        int[] arr8 = {1,2,3,2,1};

        printTrappedWaterUnits(arr);
        printTrappedWaterUnits(arr1);
        printTrappedWaterUnits(arr2);
        printTrappedWaterUnits(arr3);
        printTrappedWaterUnits(arr4);
        printTrappedWaterUnits(arr5);
        printTrappedWaterUnits(arr6);
        printTrappedWaterUnits(arr7);
        printTrappedWaterUnits(arr8);

    }

    public static void printTrappedWaterUnits(int[] arr)
    {
        System.out.println(getTrappedWater(arr));
        System.out.println(getTrappedWaterV2(arr));
        System.out.println();
    }


    public static int getTrappedWater(int[] arr)
    {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }

        right[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        int waterTrapped = 0;
        for (int i = 0 ; i < n; i++) {
            waterTrapped += ( Math.min(left[i], right[i]) - arr[i]);
        }
        return waterTrapped;
    }

    /**
     * The basic idea is that water can be stored at building i only if there are buildings of
     * greater height on both of its sides.
     * @param arr
     * @return
     */
    public static int getTrappedWaterV2(int[] arr)
    {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    trappedWater += (leftMax - arr[left]);
                }
                left++;
            } else {
                if (arr[right] > rightMax) {
                    rightMax = arr[right];
                } else {
                    trappedWater += (rightMax - arr[right]);
                }
                right--;
            }
        }
        return trappedWater;
    }

}
