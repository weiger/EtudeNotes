//Simple BFS, every words have same length so each vertice has (word.length * 26) edges
//same idea as clone graph
//curNum is next level node numbers, lastnum is current level, when lastnum is zero it need to forward to next level
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
         if(start==null || end==null || dict==null || start.length()!=end.length()) return 0;
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> isVisit = new HashSet<String>();
        int level = 1;
        int curNum = 0;
        int lastNum = 1;
        queue.offer(start);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            lastNum--;
            for(int i=0;i<cur.length();i++){
                char[] charcur = cur.toCharArray();
                for(char c='a';c<='z';c++){
                     charcur[i] = c;
                     String temp = new String(charcur);
                    if(temp.equals(end))
                        return level+1;
                    else{
                        if(dict.contains(temp) && !isVisit.contains(temp)){
                            curNum++;
                            queue.offer(temp);
                            isVisit.add(temp);
                        }
                    }   
                }
            }
            if(lastNum==0){
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }
}
//two queue method
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start==null || end==null || dict==null || start.length()!=end.length())
            return 0;
        Queue<String> cur = new LinkedList<String>();
        Queue<String> next = new LinkedList<String>();
        HashSet<String> map = new HashSet<String>();
        cur.offer(start);
        int level = 1;
        while(!cur.isEmpty()){
            String str = cur.poll();
            for(int i=0;i<str.length();i++){
                char[] chararr = str.toCharArray();
                for(char c='a';c<='z';c++){
                    chararr[i] = c;
                    String newstr = new String(chararr);
                    if(newstr.equals(end)){
                        return level+1;
                    }else if(dict.contains(newstr) && !map.contains(newstr)){
                        next.offer(newstr);
                        map.add(newstr);
                    }
                }
            }
            if(cur.isEmpty()){
                cur = next;
                level++;
                next = new LinkedList<String>();
            }
        }
        return 0;
    }
}
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start==null || end==null || dict==null || start.length()!=end.length())
            return 0;
        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> dist = new LinkedList<Integer>();
        queue.offer(start);
        dist.offer(1);
        while(!queue.isEmpty()){
            String str = queue.poll();
            Integer curdist = dist.poll();
            if(str.equals(end))
                return curdist;
            for(int i=0;i<str.length();i++){
                char[] arr = str.toCharArray();
                for(char c='a';c<='z';c++){
                    arr[i] = c;
                    String newstr = new String(arr);
                    if(dict.contains(newstr)){
                        queue.offer(newstr);
                        dist.offer(curdist+1);
                        dict.remove(newstr);
                    }
                }
            }
        }
        return 0;
    }
}
