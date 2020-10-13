package Trie.TrieProblems;

import Trie.TrieImplementation.Trie;
import Trie.TrieImplementation.TrieNode;

//https://www.geeksforgeeks.org/longest-common-prefix-using-trie/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"apple", "ape", "april"};
        String[] arr1 = {"geeksforgeeks", "geeks", "geek", "geezer"};
        String[] arr2 = {"ca","a"};
        String[] arr3 = {"x","aa", "zzz"};
        String[] arr4 = {"geeks","geek", "gee"};
        System.out.println(longestCommonPrefix(arr));
        System.out.println(longestCommonPrefix(arr1));
        System.out.println(longestCommonPrefix(arr2));
        System.out.println(longestCommonPrefix(arr3));
        System.out.println(longestCommonPrefix(arr4));
    }

    public static String longestCommonPrefix(String[] arr)
    {
        if (arr.length == 0)
            return "";
        if (arr.length == 1)
            return arr[0];
        Trie trie = new Trie();
        for (int i = 0 ; i < arr.length; i++) {
            trie.insert(arr[i]);
        }
        String resultString = "";
        TrieNode node = trie.root;

        while (node != null && !node.isEndOfWord()) {
            int index = countDistinctCharacters(node);
            if (index == -1)
                return resultString;
            resultString += (char)(index + 'a');
            node = node.getChildren()[index];
        }
        return resultString;
    }

    private static int countDistinctCharacters(TrieNode node)
    {
        if (node == null)
            return 0;
        int count = 0;
        int index = -1;
        for (int i = 0 ; i < node.getChildren().length; i++) {
            if (node.getChildren()[i] != null) {
                count++;
                index = i;
            }
        }
        return count == 1 ? index : -1;
    }
}
