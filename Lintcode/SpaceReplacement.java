public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if(string == null || string.length == 0)
            return 0;
        int cnt = 0;
        for(int i = 0 ; i < string.length; i++){
            if(string[i] == ' '){
                cnt++;
            }
        }
        int j = length + 2 * cnt - 1;
        int i = length - 1;
        while(i >= 0){
            if(string[i] != ' '){
                string[j--] = string[i--];
            }else{
                string[j] = '0';
                string[j - 1] = '2';
                string[j - 2] = '%';
                j -= 3;
                i--;
            }
        }
        return length + 2 * cnt;
    }
}
