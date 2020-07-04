package Arrays.Misc;

//https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
public class MissingAndRepeatingElement {

    public static void main(String[] args)
    {
        int[] arr = {3, 1, 3};
        int[] arr1 = {4, 3, 6, 2, 1, 1};
        int arr2[] = { 7, 3, 4, 5, 5, 6, 2 };

        printMissingAndRepeatingElement(arr);
        printMissingAndRepeatingElement(arr1);
        printMissingAndRepeatingElement(arr2);
    }

    public static void printMissingAndRepeatingElement(int[] arr)
    {
        int[] result = getMissingAndRepeatingElement(arr);
        System.out.println("Repeating Element : " + result[0]);
        System.out.println("Missing Element : " + result[1]);
        System.out.println();
    }

    /**
     * {4, 3, 6, 2, 1, 1}
     * {4, 3, 6, -2, 1, 1}
     * {4, 3, -6, -2, 1, 1}
     * {4, 3, -6, -2, 1, -1}
     * {4, -3, -6, -2, 1, -1}
     * {-4, -3, -6, -2, 1, -1}
     * @param arr
     * @return
     */
    public static int[] getMissingAndRepeatingElement(int[] arr)
    {
        int n = arr.length;
        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            if (arr[Math.abs(arr[i])-1] < 0 ) {
                result[0] = Math.abs(arr[i]);
            } else {
                arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                result[1] = (i+1);
                break;
            }
        }
        return result;
    }
}
