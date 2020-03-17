package Arrays.SearchingProblems;

import java.util.HashMap;

public class MajorityElement {
//    https://www.geeksforgeeks.org/majority-element/

    public static void main(String[] args) {
        int arr[] = new int[]{2,2,2,2,5,5,2,3,3};
        printMajority(arr);
        printMajorityV2(arr);
        System.out.println(checkMajorityElement(arr));
    }


    public static int findCandidate(int[] arr)
    {
        int majIndex = 0;
        int count = 1;
        for (int i = 1; i < arr.length ; i++){
            if (arr[i] == arr[majIndex]){
                count++;
            } else {
                count--;
            }
            if (count == 0){
                majIndex = i;
                count = 1;
            }
        }
        return arr[majIndex];
    }

    public static boolean isMajority(int[] arr, int cand)
    {
        int count = 0;
        for (int i = 0 ;i < arr.length; i++){
            if (arr[i] == cand){
                count++;
            }
            if (count > arr.length /2 ){
                return  true;
            }
        }
        return false;
    }

    public static void printMajority(int[] arr){
        int candidate = findCandidate(arr);
        if (isMajority(arr, candidate)){
            System.out.println("Majority Element :" + candidate);
        } else {
            System.out.println("No Majority Element Found");
        }
    }

    public static void printMajorityV2(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++ ){
            if (hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i]) + 1);
                if (hm.get(arr[i]) > n / 2){
                    System.out.println("Majority Element : " + arr[i]);
                    return;
                }
            } else {
                hm.put(arr[i], 1);
            }
        }
        System.out.println("No Majority Element Found");
    }

//    https://www.geeksforgeeks.org/check-array-majority-element/
    public static boolean checkMajorityElement(int[] arr)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++ ){
            if (hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i]) + 1);
                if (hm.get(arr[i]) > n / 2){
                    return true;
                }
            } else {
                hm.put(arr[i], 1);
            }
        }
        return false;
    }
}
