package Arrays.Sorting;

//https://www.geeksforgeeks.org/find-index-first-1-sorted-array-0s-1s/
public class FirstIndexOf1 {

    public static int firstIndexOfOneIterative(int[] arr)
    {
        int begin = 0;
        int end = arr.length - 1;
        int mid;

        while (begin <= end) {
            mid = (begin + end) / 2;
            if (arr[mid] == 0 ){
                begin = mid + 1;
            } else {
                if (mid == 0 || arr[mid-1] == 0)
                    return mid;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static int firstIndexOfOne(int[] arr)
    {
        return firstIndexOfOneRecursive(arr, 0, arr.length - 1);
    }

    public static int firstIndexOfOneRecursive(int[] arr, int begin, int end)
    {
        if (begin > end)
            return -1;
        int mid = (begin + end) / 2;
        if (arr[mid] == 0 ){
            return firstIndexOfOneRecursive(arr, mid + 1, end);
        } else {
            if (mid == 0 || arr[mid-1] == 0)
                return mid;
            else
                return firstIndexOfOneRecursive(arr, begin, mid - 1);
        }
    }

}
