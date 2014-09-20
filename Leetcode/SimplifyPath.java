/*Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/
public class Solution {
    public String simplifyPath(String path) {
        if(path.length()==0) return null;
        LinkedList<String> stack = new LinkedList<String>();
        String[] temp = path.split("/");
        for(String str:temp){
            if(str.length()==0 || str.equals("."))
                continue;
            else if (str.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else
                stack.push(str);
        }
        String res = "";
        if(stack.isEmpty()) stack.push("");
        while(!stack.isEmpty())
            res+= "/" + stack.removeLast();
        return res;
    }
}
