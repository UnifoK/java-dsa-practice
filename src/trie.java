public class trie {

    // Original Trie class unchanged
    static class Trie {

        class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            public TrieNode() {
                children = new TrieNode[26];
                isEndOfWord = false;
            }
        }

        private final TrieNode root; // The root of our entire Trie

        public Trie() {
            root = new TrieNode(); // Initialize the Trie with an empty root node
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null)
                    return false;
                current = current.children[index];
            }
            return current.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null)
                    return false;
                current = current.children[index];
            }
            return true;
        }
    }

    // Main method to test Trie operations
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println("Search 'apple': " + obj.search("apple"));   // true
        System.out.println("Search 'app': " + obj.search("app"));       // false
        System.out.println("StartsWith 'app': " + obj.startsWith("app")); // true
        obj.insert("app");
        System.out.println("Search 'app': " + obj.search("app"));       // true
    }
}
