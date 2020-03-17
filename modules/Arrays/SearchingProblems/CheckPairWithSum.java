package Arrays.SearchingProblems;

import java.util.Arrays;
import java.util.HashSet;

public class CheckPairWithSum {

    public static void main(String[] args) {
        int[] arr = new int[]{-8,1,4,6,10,45};
        int sum = 16;
        checkPairWithSum(arr, sum);
        checkPairWithSumV2(arr, sum);
    }

    public static boolean checkPairWithSum(int[] arr, int sum){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            if (arr[left] + arr[right] == sum){
                System.out.println("Pair exists : "  + arr[left] + " " + arr[right]);
                return true;
            }
            else if(arr[left] + arr[right] < sum){
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println("Pair doesn't exist");
        return false;
    }

    public static boolean checkPairWithSumV2(int[] arr, int sum)
    {
        HashSet<Integer> hs = new HashSet<Integer>();
        int temp;
        for (int i = 0 ; i < arr.length; i++){
            temp = sum - arr[i];
            if (hs.contains(temp)){
                System.out.println("Pair exists : " + arr[i] + " , " + temp);
                return  true;
            }
            hs.add(arr[i]);
        }
        System.out.println("Pair doesn't exist");
        return false;
    }
}
