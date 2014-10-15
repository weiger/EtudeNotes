
public class Q1_4 {
    public static String replace(String str){
        if(str==null || str.length()==0)
            return str;
        char[] strs = str.toCharArray();
        int spacecount = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacecount++;
        }
        char[] newstr = new char[str.length()+2*spacecount];
        int index = newstr.length-1;
        for(int i=str.length()-1;i>=0;i--){
            if(strs[i]==' '){
                newstr[index--] = '0';
                newstr[index--] = '2';
                newstr[index--] = '%';
            }else{
                newstr[index--] = strs[i];
            }
        }
        return new String(newstr);  
    }
    public static void main(String[] args) {
        String s1 = " a b c ";
        System.out.println(replace(s1));

    }

}
