import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
/*
0 0
1 1
2
1 0
0 2
 */
public class Solution {
    public static int solve(char[][] fields, Point squirrel, Point tree, Point[] nuts){
        int res = 0;
        fields[squirrel.x][squirrel.y] = 'S';
        for (int i = 0; i < nuts.length; i++) {
            fields[nuts[i].x][nuts[i].y] = 'N';
        }

        res  += BFS(fields, squirrel, tree);

        /*for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                System.out.print(fields[i][j] + " ");
            }
            System.out.println();
        }*/
        for (int i = 0; i < nuts.length; i++) {
            if (fields[nuts[i].x][nuts[i].y] == 'N') {
                res += 2 * (Math.abs(tree.x - nuts[i].x) + Math.abs(tree.y - nuts[i].y));
            }

        }
        return res;
    }

    public static int BFS(char[][] fields, Point squirrel, Point tree){
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        rowQ.offer(squirrel.x);
        colQ.offer(squirrel.y);
        int cur = 1;
        int next = 0;
        int level = 0;
        while (!rowQ.isEmpty() && !colQ.isEmpty()) {
            int curX = rowQ.poll();
            int curY = colQ.poll();
            cur--;
            if (fields[curX][curY] == 'N') {
                fields[curX][curY] = 'O';
                level += (Math.abs(tree.x - curX) + Math.abs(tree.y - curY));
                return level;
            }
            if (curX - 1 >= 0 && (fields[curX - 1][curY] =='O' || fields[curX - 1][curY] =='N')) {
                rowQ.offer(curX - 1);
                colQ.offer(curY);
                next++;
            }
            if (curX + 1 < fields.length && (fields[curX + 1][curY] =='O' || fields[curX + 1][curY] =='N')) {
                rowQ.offer(curX + 1);
                colQ.offer(curY);
                next++;
            }
            if (curY - 1 >= 0 && (fields[curX][curY - 1] =='O' || fields[curX][curY - 1] =='N')) {
                rowQ.offer(curX);
                colQ.offer(curY - 1);
                next++;
            }
            if (curY + 1 < fields[0].length && (fields[curX][curY + 1] =='O' || fields[curX][curY + 1] =='N' )) {
                rowQ.offer(curX);
                colQ.offer(curY + 1);
                next++;
            }
            if (cur == 0) {
                cur = next;
                next = 0;
                level++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int maxRow = 0;
        int maxCol = 0;
        Scanner cin = new Scanner(System.in);
        String sPoint = cin.nextLine();
        String[] strs = sPoint.split(" ");
        Point SP = new Point(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        String tPoint = cin.nextLine();
        strs = tPoint.split(" ");
        Point TP = new Point(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        int N = Integer.parseInt(cin.nextLine());
        Point[] NPs = new Point[N];
        for (int i = 0 ; i < N; i++) {
            String nPoint = cin.nextLine();
            strs = nPoint.split(" ");
            NPs[i] = new Point(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
            maxRow = Math.max(maxRow, NPs[i].x + 1);
            maxCol = Math.max(maxCol, NPs[i].y + 1);
        }
        char[][] fields = new char[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                fields[i][j] = 'O';
            }
        }
        int res = solve(fields, SP, TP, NPs);
        System.out.println(res);
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return x + " : " + y;
    }
}


