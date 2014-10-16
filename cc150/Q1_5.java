
public class Q1_5 {
    public static String compressbad(String str){
        if(str==null || str.length()==0)
            return str;
        String res = "";
        char last = str.charAt(0);
        int count = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==last)
                count++;
            else{
                res+= last+""+count;
                count = 1;
                last = str.charAt(i);
            }
        }
        return res+last+count;
    }
    public static String compressBetter(String str) {
        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        mystr.append(last);
        mystr.append(count);
        return mystr.toString();
    }
    public static void main(String[] args) {
        String str = "abbccccccde";
        System.out.println(compressbad(str));
        System.out.println(compressBetter(str));
    }
}
