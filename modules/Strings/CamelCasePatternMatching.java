package Strings;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/print-words-matching-pattern-camelcase-notation-dictonary
public class CamelCasePatternMatching {

    static class TrieNode {
        int NO_OF_CHARS = 26;
        TrieNode[] children;
        boolean isEndOfWord;
        List<String> words;

        public TrieNode() {
            children = new TrieNode[NO_OF_CHARS];
            isEndOfWord = false;
            words = new ArrayList<>();
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) { // O(N), N is the word length
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i)))
                    continue;
                int index = word.charAt(i) - 'A';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
            node.words.add(word);
        }

        public void insert(String[] words) { // O(W*L), W is the number of words, L is the average length of word
            for (int i = 0 ; i < words.length; i++)
                insert(words[i]);
        }

        public List<String> getAllWords(TrieNode node) { // O(L),L is the number of uppercase characters in the string array
            List<String> resultList = new ArrayList<>();
            if (node == null) {
                return  resultList;
            }
            if (node.isEndOfWord) {
                resultList.addAll(node.words);
            }
            for(int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    resultList.addAll(getAllWords(node.children[i]));
                }
            }
            return resultList;
        }

        public TrieNode search(String pattern) { //O(N) , N is the pattern length
            TrieNode node = root;
            int index;
            for (int i = 0; i < pattern.length(); i++) {
                index = pattern.charAt(i) - 'A';
                if (node.children[index] == null)
                    return null;
                node = node.children[index];
            }
            return node;
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"Hi", "Hello",
                "HelloWorld", "HiTech", "HiGeek",
                "HiTechWorld", "HiTechCity",
                "HiTechLab"};
        String pattern = "HT";

        System.out.println(findAllWords(words, pattern));
    }
    public static List<String> findAllWords(String[] dictionary, String pattern) {
        Trie trie = new Trie();
        trie.insert(dictionary);

        TrieNode node = trie.search(pattern);
        if (node == null)
            return new ArrayList<>();
        return trie.getAllWords(node); // O(L),L is the number of uppercase characters in the string array
    }

}
