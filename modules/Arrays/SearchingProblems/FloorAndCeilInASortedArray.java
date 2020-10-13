package Arrays.SearchingProblems;

public class FloorAndCeilInASortedArray {
//    https://www.geeksforgeeks.org/floor-in-a-sorted-array/
//    https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
    //solution is different from GFG, it is verified though
    //approach is similar to binary insertion sort

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 10, 12, 14};
        int key = 14;

        int[] arr1 = {1,1,1,1,2,2,2,2,2,2,2};
        int key1 = 3;
        System.out.println("Index of floor of " + key + " : " + findFloorUtil(arr, key));
        System.out.println(findStrictCeilUtil(arr1, key1));
        System.out.println(findCeilUtil(arr1, key1));
    }

    public static int findFloorUtil(int[] arr, int key)
    {
        return findFloorRecursive(arr, 0, arr.length - 1 , key);
    }

    public static int findFloorRecursive(int[] arr, int low, int high, int key)
    {
        if ( low >= high ){
            return ( arr[low] <= key ? low : ( (low - 1 >=0 ) ? ( low - 1 ) : -1 ) );
        }
        int mid = ( low + high) /2;
        if(arr[mid] == key){
            return mid;
        } else if (key < arr[mid]){
            return findFloorRecursive(arr, low, mid - 1, key);
        } else {
            return findFloorRecursive(arr, mid + 1, high, key);
        }
    }

    public static int findCeilUtil(int[] arr, int key)
    {
        int idx =  findCeilRecursive(arr, 0, arr.length - 1 , key);
        return idx == -1 ? -1 : arr[idx];
    }

    public static int findCeilRecursive(int[] arr, int low, int high, int key)
    {
        if ( low >= high ){
            return ( arr[low] >= key ? low : ( (low + 1 < arr.length ) ? ( low + 1 ) : -1 ) );
        }
        int mid = ( low + high) /2;
        if(arr[mid] == key){
            return mid;
        } else if (key < arr[mid]){
            return findCeilRecursive(arr, low, mid - 1, key);
        } else {
            return findCeilRecursive(arr, mid + 1, high, key);
        }
    }

    public static int findStrictCeilUtil(int[] arr, int key) {
        int idx =  findStrictCeilRecursive(arr, 0, arr.length - 1, key);
        return idx == -1 ? -1 : arr[idx];
    }

    public static int findStrictCeilRecursive(int[] arr, int low, int high, int key)
    {
        if ( low >= high ){
            return ( arr[low] > key ? low : ( (low + 1 < arr.length ) ? ( low + 1 ) : -1 ) );
        }
        int mid = ( low + high) /2;
        if (key < arr[mid]){
            return findStrictCeilRecursive(arr, low, mid - 1, key);
        } else {
            return findStrictCeilRecursive(arr, mid + 1, high, key);
        }
    }
}

