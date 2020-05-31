package Hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/first-element-occurring-k-times-array/
public class FirstElementOccurringKTimes {

    public static void main(String[] args) {
        int[] arr = {1, 7, 4, 3, 4, 8, 7};
        int k = 2;

        int[] arr1 = {4, 1, 6, 1, 6, 4};
        int k1 = 1;

        System.out.println(getFirstElementOccurringKTimes(arr, k));
        System.out.println(getFirstElementOccurringKTimes(arr1, k1));
    }
    public static int getFirstElementOccurringKTimes(int[] arr, int k )
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int element: arr) {
            map.put(element, map.getOrDefault(element,0) + 1);
        }

        for (int element: arr) {
            if (map.get(element) == k)
                return element;
        }

        return -1;
    }
}
