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
        List<String> res = new ArrayList<String>();
        String[] nums = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String buffer = "";
        helper(res,nums,digits,buffer,0);
        return res;
    }
    public void helper(List<String> res,String[] nums,String digits,String buffer,int deep){
        if(deep==digits.length()){
            res.add(buffer);
            return;
        }
        int index = digits.charAt(deep) - '0';
        for(int i=0;i<nums[index].length();i++){
            String temp = buffer;
            buffer = buffer + nums[index].charAt(i);
            helper(res,nums,digits,buffer,deep+1);
            buffer = temp;
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
