
public class Q1_1 {
    public static boolean isUnique1(String str){
        if(str.length()>256)
            return false;
        boolean[] rec = new boolean[256];
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(rec[c])
                return false;
            rec[c] = true;
        }
        return true;
    }
    //if only has a-z
    public static boolean isUnique2(String str){
        if(str.length()>26)
            return false;
        int checker = 0;
        for(int i=0;i<str.length();i++){
            int c = str.charAt(i)-'a';
            if( (1<<c & checker) > 0)
                return false;
            checker |= 1<<c;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique1(word) + " " + isUnique2(word));
        }
    }
}
