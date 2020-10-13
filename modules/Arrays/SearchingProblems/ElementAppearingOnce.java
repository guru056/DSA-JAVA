package Arrays.SearchingProblems;

//https://leetcode.com/problems/single-element-in-a-sorted-array/
//https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/
public class ElementAppearingOnce {

    public static void main(String[] args) {
        int arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8};
        int arr1[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8};
        System.out.println(getElementAppearingOnce(arr));
        System.out.println(getElementAppearingOnce(arr1));
    }

    public static int getElementAppearingOnce(int[] arr) {
        return arr.length == 1 ? arr[0] : getElementAppearingOnceRecursiveV2(arr, 0, arr.length - 1);
    }

    public static int getElementAppearingOnceRecursive(int[] arr, int begin , int end) {
        if (begin > end)
            return -1;

        int mid = (begin + end) / 2;
        if (mid == 0 && arr[mid] != arr[mid+1]) {
            return arr[mid];
        } else if (mid == arr.length - 1 && arr[mid] != arr[mid-1]) {
            return arr[mid];
        } else if (arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]) {
            return arr[mid];
        } else {
            int left = getElementAppearingOnceRecursive(arr, begin, mid-1);
            return left != -1 ? left : getElementAppearingOnceRecursive(arr, mid + 1, end);
        }
    }

    /**
     * All elements before the required have the first occurrence at even index (0, 2, ..)
     * and next occurrence at odd index (1, 3, …).
     * And all elements after the required elements have the first occurrence at odd index
     * and next occurrence at even index.
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public static int getElementAppearingOnceRecursiveV2(int[] arr, int begin, int end) {
        if (begin > end)
            return Integer.MAX_VALUE;
        if (begin == end)
            return arr[begin];

        int mid = ( begin + end) / 2;
        if (mid % 2 == 0) { //arr[mid] is the first occurrence
            if (arr[mid] == arr[mid+1]) {
                return getElementAppearingOnceRecursiveV2(arr, mid + 2, end);
            } else {
                 return getElementAppearingOnceRecursiveV2(arr, begin, mid);
            }
        } else { //arr[mid] is the second occurrence
            if (arr[mid] == arr[mid-1]) {
                return getElementAppearingOnceRecursiveV2(arr, mid + 1, end);
            } else {
                return getElementAppearingOnceRecursiveV2(arr, begin, mid - 1);
            }
        }
    }
}
