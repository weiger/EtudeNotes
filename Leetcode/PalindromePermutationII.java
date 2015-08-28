/*
Given a string s, return all the palindromic permutations (without duplicates) of it. 
Return an empty list if no palindromic permutation could be form.
For example:
Given s = "aabb", return ["abba", "baab"].
Given s = "abc", return [].
*/
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] map = new int[256];
        boolean odd = false;
        char single = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            map[c]++;
        }
        for(int i = 0 ; i < map.length; i++){
            if(map[i] % 2 == 1){
                if(odd){
                    return res;
                }
                odd = true;
                single = (char)i;
            }
        }
        String cur = "";
        if(odd){
            cur = "" + single;
            map[single]--;
        }
        dfs(res, map, cur, s.length());
        return res;
    }
    public void dfs(List<String> res, int[] map, String cur, int len){
        if(cur.length() == len){
            res.add(cur);
            return;
        }
        for(int i = 0 ; i < map.length; i++){
            if(map[i] != 0){
                map[i] -= 2;
                String newstr = (char)i + cur + (char)i;
                dfs(res, map, newstr, len);
                map[i] += 2;
            }
        }
    }
}
