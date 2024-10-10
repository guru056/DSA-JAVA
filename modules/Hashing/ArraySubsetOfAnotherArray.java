package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
//https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-using-map/
public class ArraySubsetOfAnotherArray {

    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int[] arr4 = {1, 2, 4};

        int[] arr5 = {10, 5, 2, 23, 19};
        int[] arr6 = {19, 5, 3};

        int[] arr7 = {1,2, 3};
        int[] arr8 = {4};

        System.out.println(isSubset(arr1, arr2));
        System.out.println(isSubsetV2(arr1, arr2));
        System.out.println(isSubsetV3(arr1, arr2));

        System.out.println(isSubset(arr3, arr4));
        System.out.println(isSubsetV2(arr3, arr4));
        System.out.println(isSubsetV3(arr3, arr4));

        System.out.println(isSubset(arr5, arr6));
        System.out.println(isSubsetV2(arr5, arr6));
        System.out.println(isSubsetV3(arr5, arr6));

        System.out.println(isSubset(arr7, arr8));
        System.out.println(isSubsetV2(arr7, arr8));
        System.out.println(isSubsetV3(arr7, arr8));
    }

    /**
     * Time complexity : O(m + n)
     * Space complexity: O(m)
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isSubset(int[] arr1, int[] arr2)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr1.length; i++)
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);

        for (int i = 0; i < arr2.length; i++) {
            if (!map.containsKey(arr2[i]))
                return false;
            if (map.get(arr2[i]) == 1)
                map.remove(arr2[i]);
            else
                map.put(arr2[i], map.get(arr2[i]) - 1);
        }
        return true;
    }

    /**
     * O(mlogm + nlogn)
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isSubsetV2(int[] arr1, int[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0 ;
        int j = 0;

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if(arr2[j] < arr1[i]) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return (j < n) ? false : true;
    }

    public static boolean isSubsetV3(int[] arr1, int[] arr2)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr2.length; i++)
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);

        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i]))
                continue;
            if (map.get(arr1[i]) == 1)
                map.remove(arr1[i]);
            else
                map.put(arr1[i], map.get(arr1[i]) - 1);
        }
        return map.isEmpty();
    }
}
