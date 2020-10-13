package Heaps.Problems;

import java.util.*;

//https://leetcode.com/problems/reorganize-string/
//https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
//https://www.geeksforgeeks.org/rearrange-numbers-in-an-array-such-that-no-two-adjacent-numbers-are-same/
//https://www.geeksforgeeks.org/rearrange-characters-in-a-string-such-that-no-two-adjacent-are-same-using-hashing/
public class RearrangeArray {
    final static int NO_OF_CHARS = 26;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 2, 3, 3, 2, 2);
        List<Integer> list1 = Arrays.asList(1, 3, 2, 3, 3, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1);
//        System.out.println(rearrangeArray(list));
        System.out.println(rearrangeArray(list1));

        String str = "aaabc";
        String str1 = "geeksforgeeks";
        String str2 = "bbbbb";
        System.out.println(rearrangeCharacters(str));
        System.out.println(isRearrangementPossible(str));

        System.out.println(rearrangeCharacters(str1));
        System.out.println(isRearrangementPossible(str1));

        System.out.println(rearrangeCharacters(str2));
        System.out.println(isRearrangementPossible(str2));
    }

    public static List<Integer> rearrangeArray(List<Integer> arr) {
        int n = arr.size();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o2.getValue() == o1.getValue()) {
                    return o2.getKey() > o1.getKey() ? 1 : -1;
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(cmp);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e);
        }
        Map.Entry<Integer, Integer> prev = null;
        Map.Entry<Integer, Integer> current = null;
        List<Integer> resultList = new ArrayList<>();
        while (!pq.isEmpty()) {
            current = pq.poll();
            resultList.add(current.getKey());
            if (prev != null) {
                pq.add(prev);
            }
            current.setValue(current.getValue() - 1);
            if (current.getValue() > 0) {
                prev = current;
            } else {
                prev = null;
            }
        }
        return resultList.size() == arr.size() ? resultList : null;
    }

    static class CharInfo {
        char ch;
        int freq;

        public CharInfo(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String rearrangeCharacters(String str) {
        int n = str.length();

        int[] charCount = new int[NO_OF_CHARS];
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i) - 'a']++;
        }

        Comparator<CharInfo> cmp = new Comparator<CharInfo>() {
            @Override
            public int compare(CharInfo o1, CharInfo o2) {
                if (o1.freq == o2.freq) {
                    return o2.ch > o1.ch ? 1 : -1;
                } else {
                    return o2.freq - o1.freq;
                }
            }
        };

        PriorityQueue<CharInfo> pq = new PriorityQueue<>(cmp);
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (charCount[ch - 'a'] > 0) {
                pq.add(new CharInfo(ch, charCount[ch - 'a']));
            }
        }

        str = "";
        CharInfo prev = null, current = null;

        while (!pq.isEmpty()) {
            current = pq.poll();
            str += current.ch;
            if (prev != null) {
                pq.add(prev);
            }
            current.freq--;
            if (current.freq > 0) {
                prev = current;
            } else {
                prev = null;
            }
        }

        return str.length() == n ? str : null;
    }

    public static boolean isRearrangementPossible(String str) {
        int n = str.length();
        int[] charCount = new int[NO_OF_CHARS];

        int index;
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            index = str.charAt(i) - 'a';
            charCount[index]++;
            if (charCount[index] > maxCount) {
                maxCount = charCount[index];
            }
        }

        /**
         * maxCount <= str.length() - maxCount + 1
         * maxCount < str.length() - maxCount + 2
         * 2 * maxCount < str.length() + 2
         * maxCount < (str.length() / 2) + 1
         */
        if (maxCount <= str.length() - maxCount + 1)
            return true;
        return false;
    }
}
