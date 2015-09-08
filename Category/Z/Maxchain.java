import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public int maxChain(String[] strs) {
        HashSet<String> dict = new HashSet<>();
        HashSet<String> isVisited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String maxString = "";
        for(String str: strs){
            if(str.length() > maxString.length()){
                maxString = str;
            }
            dict.add(str);
        }
        int res = 0;
        queue.offer(maxString);
        int curNum = 1;
        int nextNum = 0;
        while(!queue.isEmpty()){
            String cur = queue.poll();
            curNum--;
            for(int i = 0 ; i < cur.length(); i++) {
                String sub = cur.substring(0, i) + cur.substring(i + 1);
                if (dict.contains(sub) && !isVisited.contains(sub)) {
                    nextNum++;
                    queue.offer(sub);
                    isVisited.add(sub);
                }
            }
            if(curNum == 0){
                curNum = nextNum;
                nextNum = 0;
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = Integer.valueOf(cin.next());
        String[] strs = new String[N];
        for(int i = 0 ; i < N; i++){
            strs[i] = cin.next();
        }
        int maxLenChain = new Solution().maxChain(strs);
        System.out.println(maxLenChain);
    }
}
