public class WordDictionary {
    private class TrieNode{
        TrieNode[] next;
        boolean end;
        TrieNode(){
            next = new TrieNode[26];
            end = false;
        }
    }
    TrieNode root;
    WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0 ; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new TrieNode();
            }
            cur = cur.next[c - 'a'];
        }
        cur.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode node){
        if (index == word.length()) {
            return node.end;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                TrieNode next = node.next[i];
                if (next != null) {
                    if (dfs(word, index + 1, next)){
                        return true;
                    }
                }
            }
            return false;
        }
        if (node.next[c - 'a'] == null) return false;
        return dfs(word, index + 1, node.next[c - 'a']);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
