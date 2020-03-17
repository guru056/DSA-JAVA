package Arrays.SearchingProblems;

public class ElementThatAppearsOnce {
//    https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 4, 5, 3, 4};
        System.out.println("Element occurring once is : " + findSingle(arr));
    }
    public static int findSingle(int[] arr)
    {
        int res = arr[0];
        for (int i = 1 ; i < arr.length; i++){
            res = res ^ arr[i];
        }
        return res;
    }
}
