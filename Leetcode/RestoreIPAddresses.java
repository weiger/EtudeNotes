/*
 * Given a string containing only digits, restore it by returning all possible 
 * valid IP address combinations.

 * For example:
 * Given "25525511135",

 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
 public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        dfs(res,"",s,3);
        return res;
    }
    private void dfs(List<String> res, String ip, String str, int n) {
        if(n==0) {
            if(str.length()<=3 && isValid(str)) //important! TLE parse error when str is too long
                res.add(ip + str);
            return;
        }
        for(int i = 1;i<4 && i<str.length();i++){
            if(isValid(str.substring(0,i)))
                dfs(res,ip+str.substring(0,i)+".",str.substring(i),n-1);
        }
    }	
    public boolean isValid(String str){
        if(str.charAt(0)=='0') 
            return str.equals("0"); // if it starts with 'o', it must be "0"
        else
            return Integer.parseInt(str)>=0 && Integer.parseInt(str)<=255;
    }
}
 
 
 
public class RestoreIPAddresses {

/**************************** updated 2014.04.09 *****************************/

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        dfs(res, "", s, 4);
        return res;
    }

    public void dfs(ArrayList<String> res, String ip, String subStr, int n) {
        if (n == 0 && subStr.length() == 0) {
            res.add(ip);
        } else if (n > 0) {
            for (int i = 0; i < Math.min(subStr.length(), 3); i++) {
                if (i > 0 && subStr.charAt(0) == '0')  // heading zeros are not allowed.
                    continue;
                if (Integer.parseInt(subStr.substring(0, i + 1)) <= 255) {
                    String temp = ip;
                    ip += (n < 4 ? "." : "") + subStr.substring(0, i + 1);
                    dfs(res, ip, subStr.substring(i + 1), n - 1);
                    ip = temp;
                }
            }
        }
    }

}


public class Solution {  
    public ArrayList<String> restoreIpAddresses(String s) {  
        ArrayList<String> res = new ArrayList<String>();  
        if (s.length()<4||s.length()>12) return res;  
        dfs(s,"",res,0);  
        return res;  
    }  
      
    public void dfs(String s, String tmp, ArrayList<String> res, int count){  
        if (count == 3 && isValid(s)) {  
            res.add(tmp + s);  
            return;  
        }  
        for(int i=1; i<4 && i<s.length(); i++){  
            String substr = s.substring(0,i);  
            if (isValid(substr)){  
                dfs(s.substring(i), tmp + substr + '.', res, count+1);  
            }  
        }  
    }  
      
    public boolean isValid(String s){  
        if (s.charAt(0)=='0') return s.equals("0");  
        int num = Integer.parseInt(s);  
        return num<=255 && num>0;  
    }  
} 
