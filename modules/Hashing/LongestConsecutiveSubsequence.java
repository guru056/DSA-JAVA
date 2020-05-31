package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.geeksforgeeks.org/longest-consecutive-subsequence/
//https://leetcode.com/problems/longest-consecutive-sequence/
//https://www.geeksforgeeks.org/longest-increasing-consecutive-subsequence/
public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] arr ={1, 9, 3, 10, 4, 20, 2};
        int[] arr1 = {6, 7, 8, 3, 4, 5, 9, 10};
        int[] arr2 = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12};
        int[] arr3 = {2, 4, 3, 7, 4, 5};


        System.out.println(getLongestConsecutiveSubsequenceLength(arr));
        System.out.println(getLongestIncreasingConsecutiveSubsequenceLength(arr));

        System.out.println(getLongestConsecutiveSubsequenceLength(arr1));
        System.out.println(getLongestIncreasingConsecutiveSubsequenceLength(arr1));

        System.out.println(getLongestConsecutiveSubsequenceLength(arr2));
        System.out.println(getLongestIncreasingConsecutiveSubsequenceLength(arr2));

        System.out.println(getLongestConsecutiveSubsequenceLength(arr3));
        System.out.println(getLongestIncreasingConsecutiveSubsequenceLength(arr3));
    }

    public static int getLongestConsecutiveSubsequenceLength(int[] arr)
    {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);

        int maxLength = 0;
        for (int i = 0 ; i < arr.length; i++) {
            //check if arr[i] is the starting of an increasing subsequence
            if (set.contains(arr[i] - 1))
                continue;

            int increasingElement = arr[i];
            int subsequenceLength = 0;
            while (set.contains(increasingElement)) {
                subsequenceLength++;
                increasingElement+= 1;
            }
            maxLength = Math.max(maxLength, subsequenceLength);
        }
        return maxLength;
    }

    public static int getLongestIncreasingConsecutiveSubsequenceLength(int[] arr)
    {
        Map<Integer,Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);

        int maxLength = 0;
        for (int i = 0 ; i < arr.length; i++) {
            //check if arr[i] is the starting of an increasing subsequence
            if (map.containsKey(arr[i] - 1) && map.get(arr[i] - 1) < i)
                continue;

            int increasingElement = arr[i];
            int prevIndex = i;
            int subsequenceLength = 0;
            while (map.containsKey(increasingElement) && map.get(increasingElement) >= prevIndex) {
                subsequenceLength++;
                prevIndex = map.get(increasingElement);
                increasingElement+= 1;
            }
            maxLength = Math.max(maxLength, subsequenceLength);
        }
        return maxLength;
    }
}
