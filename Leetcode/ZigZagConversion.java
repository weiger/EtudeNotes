/*
P   | A   | H   | N
A P | L S | I I | G
Y   | I   | R   |

cycle = (2*nRows - 2), except nRows == 1.
j = i + cycle*k, k = 0, 1, 2, ...
secondJ = (j - i) + cycle - i

*/
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int cycle = 2 * numRows - 2;
        for (int i = 0 ; i < numRows; i++) {
            for (int j = i; j < s.length(); j = j + cycle) {
                sb.append(s.charAt(j));
                int nextIndex = (j - i) + cycle - i;
                if (i != 0 && i != numRows - 1 && nextIndex < s.length()) {
                    sb.append(s.charAt(nextIndex));
                }
            }
        }
        return sb.toString();
    }
}
