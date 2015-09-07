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

public class Solution {
    public String shuffleStr(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        char[] arr = str.toCharArray();
        int prev = -1;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] != ' '){
                int cur = i + 1;
                if(arr[cur] == ' '){
                    continue;
                }
                int next = cur + 1;
                while(next < arr.length && arr[next] != ' '){
                    if(next + 1 < arr.length && arr[next + 1] == ' '){
                        break;
                    }
                    double rand = Math.random();
                    if(rand > 0.5){
                        char tmp = arr[next];
                        arr[next] =  arr[cur];
                        arr[cur] = tmp;
                    }
                    next++;
                }
                i = next;
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
        System.out.println(new Solution().shuffleStr("Skype coding exercise"));
    }
}

public class Solution {
    public static String shuffleSentence(String str){
        int j = -1;
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' ' || i == arr.length - 1){
                if(i == j){
                    j++;
                }else{
                    if(i - j > 4){
                        shuffle(arr, j + 2, i - 2);
                    }
                    j = i;
                }
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String res = shuffleSentence("I want to get a cup of water");
        System.out.println(res);
    }

    public static void shuffle(char[] arr, int beg , int end){
        for(int i = beg ; i <= end; i++){
            int j = (int)(Math.random() * (end - beg)) + beg;
            char tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }
}
