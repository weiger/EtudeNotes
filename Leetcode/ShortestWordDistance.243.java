public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int a = -1;
        int b = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0 ; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            }
            if (words[i].equals(word2)) {
                b = i;
            }
            if (a != -1 && b != -1) {
                res = Math.min(res, Math.abs(a - b));
            }
        }
        return res;
    }
}
