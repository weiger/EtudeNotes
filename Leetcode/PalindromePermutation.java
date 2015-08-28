/*
Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.
*/
public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        int cnt = 0;
        for(Character c: map.keySet()){
            if(map.get(c) % 2 == 1){
                cnt++;
            }
            if(cnt > 1)
                return false;
        }
        return true;
    }
}
