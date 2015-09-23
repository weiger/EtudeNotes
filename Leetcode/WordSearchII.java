public class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res = new HashSet<>();
        Trie trie = new Trie();
        for (String s: words){
            trie.insert(s);
        }
        int M = board.length;
        int N = board[0].length;
        boolean[][] isVisited = new boolean[M][N];
        for (int i = 0 ; i < M; i++) {
            for (int j = 0 ; j < N; j++) {
                dfs(board, isVisited, i, j, "", trie, res);
            }
        }
        return new ArrayList<>(res);
    }
    
    public void dfs(char[][] board, boolean[][] isVisited, int i, int j, String str, Trie trie, HashSet<String> res){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return;
        }
        if (isVisited[i][j]) return;
        str = str + board[i][j];
        if (!trie.startWith(str)) return;
        if (trie.search(str)) {
            res.add(str);
        }
        isVisited[i][j] = true;
        dfs(board, isVisited, i + 1, j, str, trie, res);
        dfs(board, isVisited, i - 1, j, str, trie, res);
        dfs(board, isVisited, i, j + 1, str, trie, res);
        dfs(board, isVisited, i, j - 1, str, trie, res);
        isVisited[i][j] = false;
    }
}

class TrieNode{
    TrieNode[] next;
    boolean isEnd;
    TrieNode(){
        next = new TrieNode[26];
        isEnd = false;
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    public void insert(String str){
        TrieNode cur = root;
        for (int i = 0 ; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new TrieNode();
            }
            cur = cur.next[idx];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String str){
        TrieNode cur = root;
        for (int i = 0 ; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                return false;
            }
            cur = cur.next[idx];
        }
        return cur.isEnd == true;
    }
    
    public boolean startWith(String str){
        TrieNode cur = root;
        for (int i = 0 ; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                return false;
            }
            cur = cur.next[idx];
        }
        return true;
    }
}
