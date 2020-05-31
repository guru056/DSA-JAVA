package Hashing;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarrays-with-k-different-integers/
//https://www.geeksforgeeks.org/count-of-subarrays-having-exactly-k-distinct-elements/
//https://www.geeksforgeeks.org/window-sliding-technique/
public class SubArraysCountWithExactlyKDistinctElements {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 2, 1, 6 };
        int k = 2;
        System.out.println(getSubArraysCountWithExactlyKDistinctElements(arr, k));
    }

    public static int getSubArraysCountWithExactlyKDistinctElements(int[] arr, int k)
    {
        return getSubArraysCountWithAtMostKDistinctElements(arr, k) - getSubArraysCountWithAtMostKDistinctElements(arr, k - 1);
    }

    public static int getSubArraysCountWithAtMostKDistinctElements(int[] arr, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();

        int n = arr.length;
        int count = 0;
        int left = 0 ;
        int right = 0;

        while (right < n) {

            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > k && left < n) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0)
                    map.remove(arr[left]);
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}
