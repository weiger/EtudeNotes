import java.util.Scanner;

public class Main {
    public static int kmp(String ori, String pat) {
        int res = 0;
        int[] next = makeNext(pat);
        for (int i = 0, j = 0; i < ori.length(); i++) {
            while (j > 0 && pat.charAt(j) != ori.charAt(i))
                j = next[j - 1];
            if (pat.charAt(j) == ori.charAt(i)) {
                j++;
            }
            if (j >= pat.length()){
                res++;
                j = next[j-1];
            }
            
        }
        return res;
    }

    public static int[] makeNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i))
                j = next[j - 1];
            if (pattern.charAt(j) == pattern.charAt(i))
                j++;
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String ori = null;
        String pat = null;
        int m = 0;
        m = cin.nextInt();
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            pat = cin.next();
            ori = cin.next();
            res[i] = kmp(ori, pat);
        }
        for (int x : res)
            System.out.println(x);

    }
}
