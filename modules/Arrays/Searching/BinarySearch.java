package Arrays.Searching;

public class BinarySearch {
//    https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,100, 130, 140, 160, 170};
        int key = 10;
        System.out.println("Element found at: " + findPos(arr, key));
    }

    public static int findPos(int[] arr, int key)
    {
        int l = 0;
        int h = 1;
        int val = arr[l];

        while (val < key){
            l = h;
            h = 2*h;
            val = arr[h];
        }

        return binarySearch(arr, l ,h , key);

    }

    public static int binarySearch(int[] arr, int begin, int end, int key)
    {
        if (begin > end)
            return -1;
        int mid = (begin + end) / 2;
        if (arr[mid] == key){
            return mid;
        } else if (key < arr[mid] ){
            return binarySearch(arr, begin, mid - 1, key);
        } else {
            return binarySearch(arr, mid + 1, end, key);
        }
    }
}
