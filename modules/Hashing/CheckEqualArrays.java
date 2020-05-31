package Hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/check-if-two-arrays-are-equal-or-not/
public class CheckEqualArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 4, 0};
        int[] arr2 = {2, 4, 5, 0, 1};

        int[] arr3 = {1, 2, 5, 4, 0, 2, 1};
        int[] arr4 = {2, 4, 5, 0, 1, 1, 2};

        int[] arr5 = {1, 7, 1};
        int[] arr6 = {7, 7, 1};

        System.out.println(  checkEqualArrays(arr1,arr2) );
        System.out.println(  checkEqualArrays(arr3,arr4) );
        System.out.println(  checkEqualArrays(arr5,arr6) );
    }

    /**
     * Given two given arrays of equal length, the task is to find if given arrays are equal or not.
     * Two arrays are said to be equal if both of them contain same set of elements,
     * arrangements (or permutation) of elements may be different though.
     *
     * -- Logic is similar to "check if two strings are anagrams"
     */
    public static boolean checkEqualArrays(int[] arr1, int[] arr2)
    {
       if (arr1.length != arr2.length)
           return false;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr1.length; i++) {
            alterMap(arr1,map,i);
            alterMap(arr2,map,i);
        }
        return map.isEmpty();
    }

    private static void alterMap(int[] arr, Map<Integer,Integer> map, int i)
    {
        if (map.containsKey(arr[i])){
            int val = map.get(arr[i]);
            if (val - 1 <= 0) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], val - 1);
            }
        } else {
            map.put(arr[i], 1);
        }
    }
}
