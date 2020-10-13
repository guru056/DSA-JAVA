package Trie.TrieImplementation;

public class TrieNode {
    final private int NO_OF_CHARS = 26;
    TrieNode[] children;
    boolean isEndOfWord;
    int wordCount = 0;
    String word;

    public TrieNode[] getChildren() {
        return children;
    }

    public int getWordCount() {
        return wordCount;
    }
    public String getWord() {
        return word;
    }
    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public TrieNode() {
        children = new TrieNode[NO_OF_CHARS];
        isEndOfWord = false;
    }
}
