/*
Easy Compare Strings Show Result My Submissions

36% Accepted
Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

Example
For A = "ABCD", B = "ABC", return true.

For A = "ABCD" B = "AABC", return false.
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if(A.equals(B) || B.length()==0)
            return true;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<B.length();i++){
            char c = B.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }
        }
        for(Character c:map.keySet()){
            if(map.get(c)>0)
                return false;
        }
        return true;
    }
}
