public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null) return res;
        List<String> list = new ArrayList<>();
        helper(res, list, s);
        return res;
    }
    
    public void helper(List<List<String>> res, List<String> list, String str){
        if(str.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0 ; i <= str.length(); i++){
            if(isPalindrome(str.substring(0, i))){
                list.add(str.substring(0, i));
                helper(res, list, str.substring(i));
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String str){
        if(str.length() == 0) return false;
        int beg = 0; int end = str.length() - 1;
        while(beg < end){
            if(str.charAt(beg) != str.charAt(end)) return false;
            beg++; end--;
        }
        return true;
    }
}
