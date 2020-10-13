package Trie.TrieImplementation;

//https://www.geeksforgeeks.org/trie-insert-and-search/
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String searchKeys[] = {"the", "th", "these", "their", "thaw", "xyz"};
        for (int i = 0 ; i < keys.length; i++ ) {
            trie.insert(keys[i]);
        }
        for (int i = 0 ; i < searchKeys.length; i++ ) {
            if (trie.search(searchKeys[i])) {
                System.out.println(searchKeys[i] + " is present in trie");
            } else {
                System.out.println(searchKeys[i] + " is not present in trie");
            }
            System.out.println();
        }
    }
}
