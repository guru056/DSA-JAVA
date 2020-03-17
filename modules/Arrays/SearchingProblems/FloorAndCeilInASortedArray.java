package Arrays.SearchingProblems;

public class FloorAndCeilInASortedArray {
//    https://www.geeksforgeeks.org/floor-in-a-sorted-array/
//    https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
    //solution is different from GFG, it is verified though
    //approach is similar to binary insertion sort

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 10, 12, 14};
        int key = 7;
        System.out.println("Index of floor of " + key + " : " + findfloorUtil(arr, key));
    }

    public static int findfloorUtil(int[] arr, int key)
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
        return findCeilRecursive(arr, 0, arr.length - 1 , key);
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
}

