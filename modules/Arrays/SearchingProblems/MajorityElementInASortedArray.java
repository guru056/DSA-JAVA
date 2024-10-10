package Arrays.SearchingProblems;

public class MajorityElementInASortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2};
        int key = 2;
        System.out.println(isMajorityElement(arr,key));

    }

    public static boolean isMajorityElement(int[] arr, int key)
    {
        int n = arr.length;
        int firstOccurrence = getFirstOccurrence(arr,key);
        if (
                firstOccurrence == -1 ||
                        firstOccurrence > (n/2 - 1) ||
                        arr[firstOccurrence + n/2 ] != key
        ) return false;
        return true;

    }

    public static int getFirstOccurrence(int[] arr, int key)
    {
        return getFirstOccurrenceRecursive(
                arr,
                0,
                arr.length - 1,
                key
        );
    }

    public static int getFirstOccurrenceRecursive(int[] arr, int low, int high, int key)
    {
        if (low > high)
            return -1;
        int mid = (low + high)/2;
        if (arr[mid] == key){
            if (mid == 0 || arr[mid - 1] != key) {
                return mid;
            }
            return getFirstOccurrenceRecursive(arr, low, mid - 1, key);

        } else if (key < arr[mid]){
            return getFirstOccurrenceRecursive(arr, low, mid - 1, key);
        } else {
            return getFirstOccurrenceRecursive(arr, mid + 1, high, key);
        }

    }
}
