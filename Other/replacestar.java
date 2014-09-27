/*
将一个string 里的 * 换成0 或者 1 ,输出所有的结果 
*/

public class Solution {
    public static ArrayList<String> replacestart(String s){
        ArrayList<String> res = new ArrayList<String>();
        if(s==null || s.length()==0)
            return res;
        helper(res,0,s);
        return res;
    }
    public static void helper(ArrayList<String> res,int deep,String buffer){
        if(deep==buffer.length()){
            if(!res.contains(buffer))
                res.add(buffer);
            return;
        }
        char[] arr = buffer.toCharArray();
        for(int i=deep;i<arr.length;i++){
            if(arr[i]=='*'){
                char temp = arr[i];
                arr[i] = '0';
                helper(res,i+1,new String(arr));
                arr[i] = '1';
                helper(res,i+1,new String(arr));
        //arr[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> res = replacestart("c*a*b*");
        System.out.println(res);
    }
}
