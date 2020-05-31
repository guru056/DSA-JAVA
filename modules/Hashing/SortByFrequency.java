package Hashing;

import Utils.ArrayUtils;

import java.util.*;

//https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
//https://leetcode.com/problems/sort-characters-by-frequency/
//https://www.geeksforgeeks.org/sort-elements-by-frequency/
//https://www.geeksforgeeks.org/sort-elements-frequency-set-4-efficient-approach-using-hash/
public class SortByFrequency {

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
        String s = "tree";

        ArrayUtils.printArr(sortArrayByFrequency(arr));
        System.out.println(sortArrayByFrequency(s));
    }

    public static int[] sortArrayByFrequency(int[] arr)
    {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());

        Comparator<Map.Entry<Integer,Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        Collections.sort(list,cmp);
        int index = 0;
        for (Map.Entry<Integer,Integer> m: list) {
            int count = m.getValue();
            while (count-- > 0) {
                arr[index++] = m.getKey();
            }
        }
        return arr;
    }

    public static String sortArrayByFrequency(String s)
    {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character,Integer>> list = new LinkedList<>(map.entrySet());

        Comparator<Map.Entry<Character,Integer>> cmp = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        Collections.sort(list,cmp);
        s = "";
        for (Map.Entry<Character,Integer> m: list) {
            int count = m.getValue();
            while (count-- > 0) {
                s += m.getKey();
            }
        }
        return s;
    }

}
