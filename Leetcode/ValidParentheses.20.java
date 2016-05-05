/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 */
//more staightforward
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                } else if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }   
            }
            i++;
        }
        return stack.isEmpty();
    }
}
