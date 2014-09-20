/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
    	for (String str : tokens) {
    	    if (str.endsWith("+")) {
        		int v1 = st.pop();
        		int v2 = st.pop();
        		st.push(v2 + v1);
    	    } else if (str.endsWith("-")) {
        		int v1 = st.pop();
        		int v2 = st.pop();
        		st.push(v2 - v1);
        	} else if (str.endsWith("*")) {
        		int v1 = st.pop();
        		int v2 = st.pop();
        		st.push(v2 * v1);
    	    } else if (str.endsWith("/")) {
        		int v1 = st.pop();
        		int v2 = st.pop();
        		st.push(v2 / v1);
    	    } else {
    		st.push(Integer.parseInt(str));
    	    }
	}
	return st.pop();
    }
}
