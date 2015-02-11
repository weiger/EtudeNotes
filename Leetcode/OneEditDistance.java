public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null)
            return false;
        if(Math.abs(s.length() - t.length()) > 1)
            return false;
        if(s.length() == t.length()){
            if(s.equals(t))
                return false;
            int cnt = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i))
                    cnt++;
                if(cnt > 1)
                    return false;
            }
        }else{
            int cnt = 0;
            for(int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++){
                if(s.charAt(i) != t.charAt(j)){
                    cnt++;
                    if(cnt > 1)
                        return false;
                    if(s.length() > t.length()){
                        j--;
                    }else{
                        i--;
                    }
                }
            }
        }
        return true;
    }
}
