public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> g = getGraph(words);
        Stack<Character> stack = new Stack<Character>();
        if(words.length == 1) return words[0];
        if(topSort(g, stack)) return "";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public boolean topSort(Map<Character, Set<Character>> g, Stack<Character> stack){
        Set<Character> isVisited = new HashSet<>();
        for(char c: g.keySet()){
            if(isVisited.contains(c)) continue;
            if(dfs(isVisited, new HashSet<Character>(), c, g, stack)) return true;
        }
        return false;
    }
    public boolean dfs(Set<Character> isVisited, Set<Character> path, char c, Map<Character, Set<Character>> g, Stack<Character> stack){
        isVisited.add(c);
        path.add(c);
        for(char adj: g.get(c)){
            if(path.contains(adj)) return true;
            if(isVisited.contains(adj)) continue;
            if(dfs(isVisited, path, adj, g, stack)) return true;
        }
        stack.push(c);
        return false;
    }
    public Map<Character, Set<Character>> getGraph(String[] words){
        Map<Character, Set<Character>> g = new HashMap<>();
        int maxLen = 0;
        for(String s: words){
            maxLen = Math.max(maxLen, s.length());
        }
        for(int i = 0 ; i < maxLen; i++){
            for(int j = 0; j < words.length - 1; j++){
                if(i < words[j].length() && !g.containsKey(words[j].charAt(i))){
                    g.put(words[j].charAt(i), new HashSet<Character>());
                }
                if(i < words[j + 1].length() && !g.containsKey(words[j + 1].charAt(i))){
                    g.put(words[j + 1].charAt(i), new HashSet<Character>());
                }
                if(i == 0 || (i < words[j + 1].length() && i < words[j].length() && words[j].substring(0, i).equals(words[j + 1].substring(0, i)))){
                    char a = words[j].charAt(i);
                    char b = words[j + 1].charAt(i);
                    if(a != b){
                        g.get(a).add(b);
                    }
                }
            }
        }
        return g;
    }
}
