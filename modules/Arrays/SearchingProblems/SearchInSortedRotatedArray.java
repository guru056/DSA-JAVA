package Arrays.SearchingProblems;

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
//https://leetcode.com/problems/search-in-rotated-sorted-array
public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;

        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key1 = 30;

        int[] arr2 = {30, 40, 50, 10, 20};
        int key2 = 10;

        System.out.println(search(arr,key));
        System.out.println(search(arr1,key1));
        System.out.println(search(arr2,key2));
    }

    public static int search(int[] arr, int key) {
        return searchRecursive(arr, 0, arr.length - 1, key);
    }

    public static int searchRecursive(int[] arr, int begin, int end, int key) {
        if (begin > end)
            return -1;
        int mid = (begin + end) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        else if (arr[begin] <= arr[mid]) { // begin to mid is sorted
            if (key >= arr[begin] && key < arr[mid]) { // key lies in the sorted range
                return searchRecursive(arr, begin, mid - 1, key);
            } else {
                return searchRecursive(arr, mid + 1, end, key);
            }
        } else { // mid + 1 to end is sorted
            if (key > arr[mid] && key <= arr[end]) { // key lies in the sorted range
                return searchRecursive(arr, mid+1, end, key);
            } else {
                return searchRecursive(arr, begin, mid - 1, key);
            }
        }
    }
}
