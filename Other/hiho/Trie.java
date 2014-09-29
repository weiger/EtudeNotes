//http://hihocoder.com/problemset/solution/169026
import java.util.Scanner;

public class Main {
    Trie root;

    Main() {
        root = new Trie();
    }

    public void in(String str) {
        Trie p = root;
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - 'a';
            if (p.next[a] == null)
                p.next[a] = new Trie();
            p = p.next[a];
            p.num++;

        }
    }

    public int find(String str) {
        Trie p = root;
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - 'a';
            if (p.next[a] == null)
                return 0;
            p = p.next[a];
        }
        return p.num;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = null;
        Main trie = new Main();

        int m = 0;
        m = cin.nextInt();
        String[] strs = new String[m];
        for (int i = 0; i < m; i++) {
            strs[i] = cin.next();
            trie.in(strs[i]);
        }
        int n = cin.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            str = cin.next();
            res[i] = trie.find(str);
        }
        for (int x : res)
            System.out.println(x);

    }
}

class Trie {
    int num;
    Trie[] next;

    Trie() {
        num = 0;
        next = new Trie[26];
        for (int i = 0; i < 26; i++)
            next[i] = null;
    }
}
