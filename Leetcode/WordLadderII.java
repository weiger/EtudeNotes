public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Queue<Ladder> queue = new LinkedList<>();
        queue.offer(new Ladder(null, beginWord));
        while (!queue.isEmpty()) {
            HashSet<String> rec = new HashSet<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Ladder cur = queue.poll();
                for (int j = 0; j < cur.word.length(); j++) {
                    char[] arr = cur.word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String newstr = new String(arr);
                        Ladder newladder = new Ladder(cur, newstr);
                        if (newstr.equals(endWord)) {
                            List<String> list = new ArrayList<>();
                            while (newladder != null) {
                                list.add(newladder.word);
                                newladder = newladder.prev;
                            }
                            Collections.reverse(list);
                            res.add(list);
                        } else if (wordList.contains(newstr) && !cur.word.equals(newstr)){
                            rec.add(newstr);
                            queue.offer(newladder);
                        }
                    }
                }
            }
            if (res.size() > 0) return res; 
            wordList.removeAll(rec);
        }
        return res;
    }
    class Ladder{
        Ladder prev;
        String word;
        Ladder(Ladder prev, String word){
            this.prev = prev;
            this.word = word;
        }
    }
}
