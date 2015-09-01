public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] rec = new int[256];
        for(int i = 0 ; i < B.length(); i++){
            char c = B.charAt(i);
            rec[c]++;
        }
        
        for(int i = 0 ; i < A.length(); i++){
            char c = A.charAt(i);
            rec[c]--;
        }
        for(int x : rec){
            if(x > 0){
                return false;
            }
        }
        return true;
    }
}
