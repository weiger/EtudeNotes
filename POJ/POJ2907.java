
import java.util.Scanner;

public class Main {
    int row, col, n, ans;
    int Max = 15;
    boolean vis[];
    Node[] nodes;

    public void init() {
        nodes = new Node[Max];
        for(int i=0;i<nodes.length;i++)
            nodes[i] = new Node(0,0);
        vis = new boolean[Max];
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();

        while (t > 0) {
            row = cin.nextInt();
            col = cin.nextInt();
            nodes[0].r = cin.nextInt();
            nodes[0].c = cin.nextInt();
            n = cin.nextInt();
            for (int i = 1; i <= n; i++) {
                nodes[i].r = cin.nextInt();
                nodes[i].c = cin.nextInt();
            }

            ans = 9999999;
            dfs(0, 0, 0);
            System.out.println("The shortest path has length " + ans);
            t--;
        }
    }

    int dis(int u, int v) {
        int r = nodes[u].r - nodes[v].r;
        if (r < 0)
            r = -r;
        int c = nodes[u].c - nodes[v].c;
        if (c < 0)
            c = -c;
        return r + c;
    }

    void dfs(int dep, int u, int len) {

        if (len >= ans)
            return;
        if (dep == n) {
            if (len + dis(u, 0) < ans)
                ans = len + dis(u, 0);
            return;
        }
        for (int i = 1; i <= n; i++)
            if (!vis[i]) {
                vis[i] = true;
                dfs(dep + 1, i, len + dis(u, i));
                vis[i] = false;
            }
        }

        public static void main(String args[]) {
            Main m = new Main();
            m.init();
        }
    }

    class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
