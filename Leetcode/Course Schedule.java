import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for(int i = 0 ; i < prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if(!g.containsKey(a)){
                g.put(a, new HashSet<>());
            }
            if(!g.containsKey(b)){
                g.put(b, new HashSet<>());
            }
            g.get(b).add(a);
        }
        Set<Integer> isVisited = new HashSet<>();
        for(int x: g.keySet()){
            if(isVisited.contains(x)) continue;
            if(dfs(g, isVisited, new HashSet<>(), x)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(Map<Integer, Set<Integer>> g, Set<Integer> isVisited, Set<Integer> path, int x){
        isVisited.add(x);
        path.add(x);
        for(int adj: g.get(x)){
            if(path.contains(adj)) return true;
            if(isVisited.contains(adj)) continue;
            if(dfs(g, isVisited, path, adj))
                return true;
        }
        path.remove(x);
        return false;
    }
}

