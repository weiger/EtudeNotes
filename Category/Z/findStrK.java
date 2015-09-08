public class Solution {
    public int findStr(String B, String A) {
        int M = A.length();
        int N = B.length();
        int max = N / M;
        for(int i = max; i >= 1; i--){
            if(isValid(B, A, i)){
                return i;
            }
        }
        return -1;
    }

    public boolean isValid(String B, String A, int k){
        StringBuilder p = new StringBuilder();
        for(int i = 0; i < A.length(); i++){
            int tmp = k;
            while(tmp > 0){
                p.append(A.charAt(i));
                tmp--;
            }
        }
        String pattern = p.toString();
        int i = 0;
        int j = 0;
        while(i < B.length()){
            if(B.charAt(i) == pattern.charAt(j)){
                j++;
                if(j == pattern.length()){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args) {
        String B = "XXadhflakjhelXXzzqqkkpoYYadadfhgakheZafhajkefhlZadhflkejhZfagjhfebhh";
        String A = "XYZ";
        int k = new Solution().findStr(B, A);
        System.out.println(k);
    }
}
