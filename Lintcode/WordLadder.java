public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(start == null || end == null || dict == null){
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int curNum = 1;
        int nextNum = 0;
        int level = 1;
        while(!queue.isEmpty()){
            String str = queue.poll();
            curNum--;
            for(int i = 0 ; i < str.length(); i++){
                char[] arr = str.toCharArray();
                for(char c = 'a'; c <= 'z' ; c++){
                    arr[i] = c;
                    String newstr = new String(arr);
                    if(newstr.equals(end)){
                        return level + 1; 
                    }
                    if(dict.contains(newstr)){
                        queue.offer(newstr);
                        nextNum++;
                        dict.remove(newstr);
                    }
                }
            }
            if(curNum == 0){
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }
}
