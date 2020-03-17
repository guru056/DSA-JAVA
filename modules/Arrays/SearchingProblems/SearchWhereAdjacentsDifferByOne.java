package Arrays.SearchingProblems;

public class SearchWhereAdjacentsDifferByOne {
    //https://www.geeksforgeeks.org/search-an-element-in-an-array-where-difference-between-adjacent-elements-is-1/
    public static void main(String[] args) {
        int arr[] = {8 ,7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3 };
        int key = -1;
        System.out.println("Element found at index : "+ search(arr, key));
    }

    public static int search(int[] arr, int key){

        int i = 0;

        while (i < arr.length){
            if (arr[i] == key)
                return i;

            i = i + Math.abs(arr[i] - key);
        }
        return -1;
    }

}
