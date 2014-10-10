/*Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/
public class Solution {
    public String simplifyPath(String path) {
        if(path==null)
            return null;
        String[] tmp = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<tmp.length;i++){
            if(tmp[i].length()==0 || tmp[i].equals("."))
                continue;
            if(tmp[i].equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else
                stack.push(tmp[i]);
        }
        String res = "";
        if(stack.isEmpty())
            stack.push("");
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}
