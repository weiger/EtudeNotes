/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, 
such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
Note
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null || start.length() == 0 || end.length() == 0 || dict == null)
            return 0;
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        int level = 1;
        int cur = 1;
        int next = 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            String str = queue.poll();
            cur--;
            for(int i = 0; i < str.length(); i++){
                char[] arr = str.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    arr[i] = c;
                    String newstr = new String(arr);
                    if(newstr.equals(end)){
                        return level + 1;
                    }else if(dict.contains(newstr) && !set.contains(newstr)){
                        queue.offer(newstr);
                        next++;
                        set.add(newstr);
                    }
                }
            }
            if(cur == 0){
                cur = next;
                next = 0;
                level++;
            }
        }
        return level;
    }
}
