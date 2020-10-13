package Trie.TrieImplementation;

public class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * The complexity of creating a trie is O(W*L),
     * where W is the number of words, and L is an average length of the word
     * you need to perform L lookups on the average for each of the W words in the set.
     * @param word
     */
    public void insert(String word)
    {
        TrieNode node = root;
        for (int i = 0 ; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isEndOfWord = true;
        node.wordCount++;
        node.word = word;
    }

    public void insert(String[] words)
    {
        for (int i = 0 ; i < words.length; i++) {
            insert(words[i]);
        }
    }

    public boolean search(String word)
    {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null)
                return false;
            node = node.children[word.charAt(i) - 'a'];
        }
        return node.isEndOfWord;
    }
}
