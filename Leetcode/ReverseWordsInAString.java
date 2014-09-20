/*
 * Given an input string, reverse the string word by word.

 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".

 * click to show clarification.

 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing 
 * spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * 
 */
 public class Solution {
    public String reverseWords(String s) {
        String[] temp = s.trim().split(" ");
        String res = "";
        for(int i = temp.length-1;i>=0;i--){
            if(!temp[i].trim().equals(""))
                res = res + temp[i] + " ";
        }
        return res.trim();
    }
}
 
 
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String res = "";
        s = s.trim();
        ArrayList<String> list = new ArrayList<String>();
        String[] array = s.split(" ");
        for (String a : array)
            if (!a.trim().equals(""))
                list.add(a.trim());
        for (int i = 0; i < list.size(); i++)
            res += list.get(list.size() - 1 - i) + " ";
        res = res.trim();
        return res;
    }

}
