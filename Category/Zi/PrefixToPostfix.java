public class Solution {

    public String preToPost(String A) {
        Stack<String> stack = new Stack<>();
        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == '+' || A.charAt(i) == '-' || A.charAt(i) == '*' || A.charAt(i) == '/') {
                String tmp = "";
                tmp += stack.pop();
                tmp += stack.pop();
                tmp += A.charAt(i);
                stack.push(tmp);
            } else {
                stack.push(A.charAt(i) + "");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.preToPost("+-435"));
    }
}
