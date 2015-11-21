class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - 'a';
            if (cur.next[n] == null) {
                cur.next[n] = new TrieNode();
            }
            cur = cur.next[n];
            cur.num++;
        }
    }

    public int search(String str) {
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - 'a';
            if (cur.next[n] != null) {
                cur = cur.next[n];
            } else {
                return 0;
            }
        }
        return cur.num;
    }
}


class TrieNode {
    int num;
    TrieNode[] next;

    TrieNode() {
        num = 0;
        next = new TrieNode[26];
    }
}
