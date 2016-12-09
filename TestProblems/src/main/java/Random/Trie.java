package Random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kunal on 12/8/2016.
 */
public class Trie {

    public static class TrieNode {

        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    public void insertRecursive(TrieNode current, String word, int index) {

        if (index == word.length()) {
            current.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index + 1);
    }

    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    public boolean searchRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            return current.endOfWord;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        return node != null && searchRecursive(node, word, index + 1);
    }


}
