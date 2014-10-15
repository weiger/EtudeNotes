import java.util.Arrays;

public class Q1_3 {
    public static boolean isPermutation1(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return new String(str1).equals(new String(str2));
    }
    public static boolean isPermutation2(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        int[] checker = new int[256];
        char[] str1 = s1.toCharArray();
        for(char x:str1)
            checker[x]++;
        for(int i=0;i<s2.length();i++){
            if(--checker[s2.charAt(i)]<0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPermutation1("apple", "papel"));
        System.out.println(isPermutation2("apple", "papel"));
        System.out.println(isPermutation1("carrot", "tarroc"));
        System.out.println(isPermutation2("carrot", "tarroc"));
        System.out.println(isPermutation1("hello", "llloh"));
        System.out.println(isPermutation2("hello", "llloh"));
    }

}
