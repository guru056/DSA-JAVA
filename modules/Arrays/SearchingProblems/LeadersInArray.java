package Arrays.SearchingProblems;

public class LeadersInArray {
//    https://www.geeksforgeeks.org/leaders-in-an-array/
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        printLeaders(arr);
    }

    public static void printLeaders(int[] arr){
        int max = Integer.MIN_VALUE;
        System.out.print("Leaders: ");
        for (int i = arr.length - 1; i  >= 0; i--){
            if (max < arr[i]){
                max = arr[i];
                System.out.print(max + " ");
            }
        }
        System.out.println();
    }
}
