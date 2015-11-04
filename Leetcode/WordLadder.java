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
// bi-bfs
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        wordDict.add(endWord);
        if (beginWord.equals(endWord)) return 0;
        int levelLeft = 0, levelRight = 0, len = beginWord.length();
        Set<String> setLeft = new HashSet<String>();
        Set<String> setRight = new HashSet<String>();
        setLeft.add(beginWord);
        setRight.add(endWord);
        while (setLeft.size() > 0 && setRight.size() > 0) {
            if (setLeft.size() <= setRight.size()) {
                levelLeft++;
                if (bfs(setLeft, setRight, wordDict)) return levelLeft + levelRight + 1;
            } else {
                levelRight++;
                if (bfs(setRight, setLeft, wordDict)) return levelLeft + levelRight + 1;
            }
        }
        return 0;
    }

    public boolean bfs(Set<String> set, Set<String> targetSet, Set<String> wordDict) {
        Set<String> nSet = new HashSet<String>();
        for (String word : set) {
            for (int i = 0; i < word.length(); i++)
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == word.charAt(i)) continue;
                    String nWord = word.substring(0, i) + Character.toString(c) + word.substring(i + 1, word.length());
                    if (targetSet.contains(nWord)) return true;
                    if (wordDict.contains(nWord)) {
                        wordDict.remove(nWord);
                        nSet.add(nWord);
                    }
                }
        }
        set.removeAll(set);
        set.addAll(nSet);
        return false;
    }
}
