
public class Q1_2 {
    public static String reverse(String str){
        if(str==null || str.length()==0)
            return str;
        char[] strs = str.toCharArray();
        for(int i=0;i<strs.length/2;i++){
            char tmp = strs[i];
            strs[i] = strs[strs.length-1-i];
            strs[strs.length-1-i] = tmp;
        }
        return new String(strs);
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "I wang a job";
        String s3 = "";
        System.out.println(reverse(s1));
        System.out.println(reverse(s2));
        System.out.println(reverse(s3));
    }
}
