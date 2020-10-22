package Strings;

import java.util.*;

//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
public class PrintAnagramsTogether {

    public static void main(String[] args) {
        String[] arr = {"cat", "dog", "tac", "god", "act"};
        System.out.println(printAnagramsTogether(arr));
        System.out.println(printAnagramsTogetherV2(arr));
        System.out.println(printAnagramsTogetherV3(arr));
    }

    /**
     * Time Complexity - N*MlogM
     * N - array length
     * M - largest string
     *
     * Space Complexity - O(N)
     *
     * @param arr
     * @return
     */
    public static List<String> printAnagramsTogether(String[] arr) {
        List<String> stringArrModified = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str: arr) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<>());
            list.add(str);
            map.put(sortedString, list);
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            stringArrModified.addAll(entry.getValue());
        }
        return stringArrModified;
    }

    /**
     * Time Complexity - N*M
     *  N - array length
     *  M - largest string
     *
     *  Space Complexity - O(N + M)
     * @param arr
     * @return
     */
    public static List<String> printAnagramsTogetherV2(String[] arr) {
        List<String> stringArrModified = new ArrayList<>();

        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str: arr) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                freqMap.put(str.charAt(i), freqMap.getOrDefault(str.charAt(i), 0) + 1);
            }

            map.putIfAbsent(freqMap, new ArrayList<>());
            List<String> l = map.get(freqMap);
            l.add(str);
            map.put(freqMap, l);
        }

        for (Map.Entry<Map<Character, Integer>, List<String>> entry: map.entrySet()) {
            stringArrModified.addAll(entry.getValue());
        }

        return stringArrModified;
    }

    public static List<String> printAnagramsTogetherV3(String[] arr) {
        Trie trie = new Trie();

        trie.insert(arr);
        List<String> stringArrModified = new ArrayList<>();
        traverse(trie.root, stringArrModified, arr);
        return stringArrModified;
    }

    private static void traverse(TrieNode node, List<String> resultList, String[] arr) {
        if (node == null)
            return;
        if (node.isEndOfWord) {
            for (int i: node.indices) {
                resultList.add(arr[i]);
            }
            return;
        }

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null)
                traverse(node.children[i], resultList,arr);
        }
    }

    private static class TrieNode {
        static final int NO_OF_CHARS = 26;
        TrieNode[] children;
        boolean isEndOfWord;
        LinkedList<Integer> indices;

        public TrieNode() {
            children = new TrieNode[NO_OF_CHARS];
            indices = new LinkedList<>();
        }
    }

    private static class Trie {

        TrieNode root = new TrieNode();
        public void insert(String word, int index) {
            TrieNode node = root;
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            word = new String(charArr);
            for (int i = 0; i < word.length(); i++) {
                if (node.children[word.charAt(i) - 'a'] == null) {
                    node.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                node = node.children[word.charAt(i) - 'a'];
            }
            node.isEndOfWord = true;
            node.indices.add(index);
        }

        public void insert(String[] words) {
            for (int i = 0; i < words.length; i++) {
                insert(words[i], i);
            }
        }
    }

}
