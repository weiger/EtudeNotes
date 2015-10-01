import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public class NestedList {
        boolean isNum;
        List<NestedList> list;
        Integer value;

        public NestedList(int value) {
            this.value = value;
            isNum = true;
        }

        public NestedList(List<NestedList> list) {
            isNum = false;
            this.list = list;
        }

        public NestedList() {
            list = new ArrayList<>();
            isNum = false;
            value = null;
        }

        public void add(NestedList element) {
            list.add(element);
        }

        public String toString() {
            if (isNum) {
                return "" + value;
            } else {
                return list.toString();
            }
        }


    }

    //"[123,456,[788,799,833],[[]],10,[]]"
    public NestedList convert(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.charAt(0) != '[') {
            return new NestedList(Integer.valueOf(str));
        }
        Stack<NestedList> stk = new Stack<NestedList>();
        int index = 0;
        int num = 0;
        NestedList result = null;
        while (index < str.length()) {
            char c = str.charAt(index);
            if (c == '[') {
                NestedList tmp = new NestedList();
                stk.push(tmp);
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + (int) (c - '0');
            } else if (c == ',' || c == ']') {
                if (isDigit(str.charAt(index - 1))) {
                    NestedList tmp = new NestedList(num);
                    num = 0;
                    stk.peek().add(tmp);
                }
                if (c == ']') {
                    result = stk.pop();
                    if (!stk.isEmpty()) {
                        stk.peek().add(result);
                    }
                }
            }
            index++;
        }
        return result;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convert("[123,456,[788,799,833],[[]]," +
                "[20, 25,[[[20, 10],50, 89], 190,  90], 3, 8], 10,[]]"));
    }
}
