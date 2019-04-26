class TrieNode {
    char val;
    int count;
    boolean exist;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(){}
    public TrieNode(char val){
        this.val = val;
    }
}
class Trie {

    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('#');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode(word.charAt(i));
            }
            cur = cur.children[index];
        }
		cur.count += 1;
        if (cur.exist == false) cur.exist = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (cur.children[index] == null && i < word.length()) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.exist;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'a');
            if (cur.children[index] == null && i < prefix.length()) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {

    int count;
    boolean exist;
    Trie[] children;
    
    
    /** Initialize your data structure here. */
    public Trie() {
        count = 0;
        exist = false;
        children = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
        }
		cur.count += 1;
        if (cur.exist == false) cur.exist = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (cur.children[index] == null && i < word.length()) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.exist;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'a');
            if (cur.children[index] == null && i < prefix.length()) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */