package Arrays.SearchingProblems;

public class SearchWhereAdjacentsDifferByK {
//    https://www.geeksforgeeks.org/searching-array-adjacent-differ-k/
    public static void main(String[] args) {
        int arr[] = {20, 40, 50, 70, 70, 60};
        int key = 6;
        int k =20;
        System.out.println("Element found at index : "+ search(arr, key, k));
    }

    public static int search(int[] arr, int key, int k){

        int i = 0;

        while (i < arr.length){
            if (arr[i] == key)
                return i;

            i = i + Math.max(1,   Math.abs(arr[i] - key)/k);
        }
        return -1;
    }
}
