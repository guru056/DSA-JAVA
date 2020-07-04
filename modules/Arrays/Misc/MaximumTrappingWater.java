package Arrays.Misc;

//https://www.geeksforgeeks.org/maximum-water-that-can-be-stored-between-two-buildings/
public class MaximumTrappingWater {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 6, 5};
        System.out.println(getMaximumTrappingWater(arr));
    }

    /**
     * Input: arr[] = {2, 1, 3, 4, 6, 5}
     * Output: 8
     * @param arr
     * @return
     */
    public static int getMaximumTrappingWater(int[] arr)
    {
        int n = arr.length;
        int i = 0 ;
        int j = n - 1;

        int maxTrapped = 0;
        while (i < j) {
            if (arr[i] < arr[j]) {
                maxTrapped = Math.max( (j - i - 1) * arr[i], maxTrapped);
                i++;
            } else if (arr[j] < arr[i]) {
                maxTrapped = Math.max( (j - i - 1) * arr[j], maxTrapped);
                j--;
            } else {
                maxTrapped = Math.max( (j - i - 1) * arr[i], maxTrapped);
                i++;
                j--;
            }
        }
        return maxTrapped;
    }
}
