package Trie.TrieProblems;

import Trie.TrieImplementation.Trie;
import Trie.TrieImplementation.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteFeature {

    public static void main(String[] args) {
        System.out.println(getStringsWithPrefix("a"));
    }

    public static List<String> getStringsWithPrefix(String prefix)
    {
        Trie trie = new Trie();
        String[] sample = {"abc", "abcd"};
        trie.insert(sample);

        List<String> resultStrings = new ArrayList<>();
        TrieNode node = trie.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.getChildren()[prefix.charAt(i)-'a'] == null) {
                return resultStrings;
            }
            node = node.getChildren()[prefix.charAt(i)-'a'];
        }

        List<String> suffixes = getStrings(node);
        System.out.println("suffixes");
        for (String suffix: suffixes) {
            resultStrings.add(prefix + suffix);
        }
        return resultStrings;
    }

    public static List<String> getStrings(TrieNode node)
    {
        List<String> resultList = new ArrayList<>();
        if (node == null)
            return resultList;
        for (int i = 0 ; i < node.getChildren().length; i++) {
            if (node.getChildren()[i] == null)
                continue;
            String suffix = String.valueOf((char)(i + 'a'));
            List<String> subSuffix = getStrings(node.getChildren()[i]);
            if (subSuffix.size() > 0) {
                for (String str: subSuffix)  {
                    resultList.add(suffix + str);
                }
            } else {
                resultList.add(suffix);
            }
        }
        return resultList;
    }
}
