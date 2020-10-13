package Strings;

import Trie.TrieImplementation.Trie;
import Trie.TrieImplementation.TrieNode;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/frequent-word-array-strings/
public class MostFrequentWord {
    static int maxCount = 0;
    static String word = "";

    public static void main(String[] args) {
        String[] arr = {"geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can",
                "be", "computer", "science",
                "zoom", "yup", "fire", "in",
                "be", "data", "geeks"};
        System.out.println(mostFrequentWord(arr));
        System.out.println(mostFrequentWordV2(arr));

    }

    public static String mostFrequentWord(String[] words) {
        Trie trie = new Trie();
        trie.insert(words);

        preOrder(trie.root);
        return word;
    }

    private static void preOrder(TrieNode node) {
        if (node == null)
            return;

        for (TrieNode n : node.getChildren()) {
            if (n != null && n.isEndOfWord()) {
                if (n.getWordCount()  > maxCount) {
                    maxCount = n.getWordCount();
                    word = n.getWord();
                }
            }
            preOrder(n);
        }
    }

    public static String mostFrequentWordV2(String[] arr) {
        int n = arr.length;
        if (n == 0)
            return "";

        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0 ; i < arr.length; i++) {
            wordCount.put(arr[i], wordCount.getOrDefault(arr[i], 0) + 1);
        }

        int maxCount = -1;
        String wordWithMaxCount = null;
        for (Map.Entry<String, Integer> e: wordCount.entrySet()) {
            if (e.getValue() > maxCount) {
                maxCount = e.getValue();
                wordWithMaxCount = e.getKey();
            }
        }
        return wordWithMaxCount;
    }
}
