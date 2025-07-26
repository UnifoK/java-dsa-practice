public class wordDict {

    // Original WordDictionary class without any changes
    static class WordDictionary {

        class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            public TrieNode() {
                children = new TrieNode[26];
                isEndOfWord = false;
            }
        }

        private final TrieNode root; // The root of our entire Trie

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null)
                    current.children[index] = new TrieNode();
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }

        private boolean searchHelper(String word, int index, TrieNode node) {
            if (index == word.length())
                return node.isEndOfWord;
            char c = word.charAt(index);
            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null) {
                        if (searchHelper(word, index + 1, child))
                            return true;
                    }
                }
                return false;
            } else {
                int charIndex = c - 'a';
                TrieNode child = node.children[charIndex];

                if (child == null)
                    return false;
                return searchHelper(word, index + 1, child);
            }
        }

        public boolean search(String word) {
            return searchHelper(word, 0, root);
        }
    }

    // Main method to test WordDictionary
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");

        System.out.println("Search 'pad': " + obj.search("pad")); // false
        System.out.println("Search 'bad': " + obj.search("bad")); // true
        System.out.println("Search '.ad': " + obj.search(".ad")); // true
        System.out.println("Search 'b..': " + obj.search("b..")); // true
    }
}
