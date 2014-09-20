//http://acm.timus.ru/problem.aspx?space=1&num=1763

import java.util.ArrayList;

public class Solution {
    static int res;

    public static int bugjump(int n) {
        res = 0;
        if (n == 0)
            return res;
        boolean[] ladder = new boolean[n]; //record for visited history
        int[] jumps = { 1, 3, -1, -3 };    //4 jump way
        String rec = "";                   //for tracking answer
        ArrayList<String> track = new ArrayList<String>();
        dfs(ladder, jumps, 0, n, 0,rec,track);
        return res;
    }

    public static void dfs(boolean[] ladder, int[] jumps, int deep, int num,
        int start,String rec,ArrayList<String> track) {
        if (deep == num && start == 0) {      //jump all slots and back to start point
            if(!track.contains(rec)){         //unique solution
                track.add(rec);
                res++;
                }
            return;
        }
        for (int i = 0; i < jumps.length; i++) {
            int next;                                   //deal with index for circle
            if ((start + jumps[i]) % num== 0)
                next = 0;
            else if (start + jumps[i] > 0)               //it works but ugly
                next = (start + jumps[i]) % num;
            else 
                next = num + ((start + jumps[i]) % num);  //deal with index for circle
            
            if (ladder[next] == false) {                 //dfs routine
                ladder[next] = true;
                String temp = rec;
                rec = rec +next+"";
                dfs(ladder, jumps, deep + 1, num, next,rec,track);
                rec = temp;
                ladder[next] = false;
            }
        }

    }


    public static void main(String[] args) {
        System.out.println(bugjump(10));
    }
}

