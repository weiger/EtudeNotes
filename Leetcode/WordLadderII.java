//Linkedlist to track searching, BFS to search goal
//the reason why search from end is to avoid reverse arraylist
public class Solution{
    public class Ladder{
        Ladder parent;
        String word;
        Ladder(Ladder parent,String word){
            this.parent = parent;
            this.word = word;
        }
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) { 
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        Queue<Ladder> q = new LinkedList<Ladder>();
        Ladder endLadder = new Ladder(null,end);
        q.offer(endLadder);
        int count = 1;
        while(!q.isEmpty()){
            HashSet<String> map = new HashSet<String>();
            int cur = 0;
            for(int i=0;i<count;i++){
                Ladder curLadder = q.poll();
                String str = curLadder.word;
                for(int j=0;j<str.length();j++){
                    char[] charArray = str.toCharArray();
                    for(char c='a';c<='z';c++){
                        charArray[j]=c;
                        String temp = new String(charArray);
                        Ladder newLadder = new Ladder(curLadder,temp);
                        if(temp.equals(start)){
                            ArrayList<String> list = new ArrayList<String>();
                            while(newLadder!=null){
                                list.add(newLadder.word);
                                newLadder = newLadder.parent;
                            }
                            res.add(list);
                        }else if(dict.contains(temp) && !temp.equals(str)){
                            q.offer(newLadder);
                            map.add(temp);
                            cur++;
                        }
                    }
                    
                }
            }
            if(res.size()>0) return res;
            dict.removeAll(map);
            count = cur;
        }
        return res;
    }  
}
