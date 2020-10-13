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

        int arr1[] = { 1, 2, 3, 4, 5 };
        int k1 = 1;
        System.out.println(getSubArraysCountWithExactlyKDistinctElements(arr, k));
        System.out.println(getSubArraysCountWithExactlyKDistinctElements(arr1, k1));
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

        for (int right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0)
                    map.remove(arr[left]);
                left++;
            }
            /**
             * combinations till the previous window have been counted
             * the new element (say nth element) can be combined with each of the n - 1 elements
             * each forming a combination of size 2.
             * plus one other combination is (1,2,...n). All other intermediate combinations have already been counted
             */
            count += right - left + 1;
        }

        return count;
    }
}
