package Strings;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/second-repeated-word-sequence/
public class SecondMostRepeatedWordInSequence {

    public static void main(String[] args) {
        String[] arr = new String[]{"aaa", "bbb", "ccc", "bbb",
                "aaa", "aaa"};
        String[] arr1 = new String[]{"geeks", "for", "geeks", "for",
                "geeks", "aaa"};

        System.out.println(getSecondMostRepeatedWord(arr));
        System.out.println(getSecondMostRepeatedWord(arr1));
    }
    public static String getSecondMostRepeatedWord(String[] arr) {
        int n = arr.length;
        if (n < 2)
            return null;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        String firstMax = null, secondMax = null;
        int firstMaxCount = Integer.MIN_VALUE, secondMaxCount = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > firstMaxCount) {
                secondMaxCount = firstMaxCount;
//                if (firstMax != null) {
                    secondMax = firstMax;
//                }
                firstMaxCount = entry.getValue();
                firstMax = entry.getKey();
            } else if (entry.getValue() > secondMaxCount && entry.getValue() != firstMaxCount) {
                secondMaxCount = entry.getValue();
                secondMax = entry.getKey();
            }
        }
        return secondMax;
    }
}
