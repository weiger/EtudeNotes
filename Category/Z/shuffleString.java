public class Solution {
    public String shuffleStr(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        char[] arr = str.toCharArray();
        int prev = -1;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == ' '){
                helper(arr, prev + 1, i - 1);
                prev = i;
            }
            if(i == arr.length - 1){
                helper(arr, prev + 1, arr.length - 1);
            }
        }
        return new String(arr);
    }
    public static void helper(char[] arr, int beg ,int end){
        for(int i = beg + 1 ; i <= end - 1 ; i++){
            int j = (int)(Math.random() * (end - i)) + i;
            char tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().shuffleStr("I want to buy a cup of water"));
    }
}
