/*
 * Given a digit string, return all possible letter combinations that the number could represent.

 * A mapping of digit to letters (just like on the telephone buttons) is given below.

 * http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/

 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want. 
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] dig = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(res,digits,dig,0,"");
        return res;
    }
    public void helper(List<String> res,String digits,String[] dig,int pos,String buff){
        if(pos==digits.length()){
            res.add(buff);
            return;
        }
        for(int i=0;i<dig[digits.charAt(pos)-'0'].length();i++){
            String tmp = buff;
            buff+=dig[digits.charAt(pos)-'0'].charAt(i);
            helper(res,digits,dig,pos+1,buff);
            buff = tmp;
        }
    }
} 
 
 
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
		String[] dials =
		{" ", "", "abc", "edf", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		String buffer ="";
		helper(res, dials, digits, 0, buffer);
		return res;
    }
    public void helper(List<String> res, String[] dials, String digits,
			int deep, String buffer)
	{
		if (deep == digits.length())
		{
			res.add(buffer);
			return;
		}

		int index = digits.charAt(deep) - 48;
		for (int i = 0; i < dials[index].length(); i++)
		{
			buffer = buffer + dials[index].charAt(i);
			helper(res, dials, digits, deep + 1, buffer);
			buffer = buffer.substring(0,buffer.length()-1);
		}
	}
}
