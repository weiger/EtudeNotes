

public class Solution {
   
    public static void longestCommonSubstring(String str1, String str2) {
        int i, j;
        int len1, len2;
        len1 = str1.length();
        len2 = str2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        int[] max = new int[maxLen];
        int[] maxIndex = new int[maxLen];
        int[] c = new int[maxLen];
 
        for (i = 0; i < len2; i++) {
            for (j = len1 - 1; j >= 0; j--) {
                if (str2.charAt(i) == str1.charAt(j)) {
                    if ((i == 0) || (j == 0))
                        c[j] = 1;
                    else
                        c[j] = c[j - 1] + 1;
                } else {
                    c[j] = 0;
                }
 
                if (c[j] > max[0]) { 
                    max[0] = c[j]; 
                    maxIndex[0] = j;
 
                    for (int k = 1; k < maxLen; k++) {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                } else if (c[j] == max[0]) { 
                    for (int k = 1; k < maxLen; k++) {
                        if (max[k] == 0) {
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break; 
                        }
 
                    }
                }
            }
        }
 
        for (j = 0; j < maxLen; j++) {
            if (max[j] > 0) {
                System.out.println("The" + (j + 1) + "nth LCsubstring:");
                System.out.println(str1.substring(maxIndex[j] - max[j] + 1,maxIndex[j]+1));
            }
        }    
    }
   

    public static void main(String[] args) {
	longestCommonSubstring("123456abcd567","234dddabc45678");
    }

}
