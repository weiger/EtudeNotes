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
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] nums = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(res, nums, "", 0, digits);
        return res;
    }
    public void helper(List<String> res, String[] nums, String buffer, int deep, String input) {
        if (deep == input.length()) {
            res.add(buffer);
            return;
        }
        for (int i = 0; i < nums[input.charAt(deep) - '0'].length(); i++) {
            helper(res, nums, buffer + nums[input.charAt(deep) - '0'].charAt(i), deep + 1, input);
        }
    }
}
