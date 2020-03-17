package Arrays.SearchingProblems;

public class FindRepetitiveElement {
//    https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/

    public static void main(String[] args) {
        int[] arr = {1,3,3,2,4};
        System.out.println("Repeating element: " + findRepeating(arr));
        System.out.println("Repeating element: " + findRepeatingV2(arr));
        System.out.println("Repeating element: " + findRepeatingV3(arr));
    }
    public static int findRepeating(int[] arr)
    {
        int n = arr.length;
        int sum = 0;
        for (int i = 0 ; i < n; i++){
            sum += arr[i];
        }
        return sum - (n* (n-1))/2;
    }

    public static int findRepeatingV2(int[] arr)
    {
        int n = arr.length;
        int res = 0;
        for (int i = 0 ; i < n - 1 ; i++){
            res = res ^ (i + 1) ^ arr[i];
        }
        return res ^ arr[n - 1];
    }

    public static int findRepeatingV3(int[] arr)
    {
        int n = arr.length;
        int element = 0;
        int missingElement  = 0;
        for (int i = 0 ; i < n; i++){
            element = arr[Math.abs(arr[i])];
            if (element < 0){
                missingElement =  Math.abs( arr[i] );
                break;
            }
            arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
        }
        return missingElement;
    }

}
