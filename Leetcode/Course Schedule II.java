import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            return null;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < numCourses; i++){
            map.put(i, new HashSet<Integer>());
        }
        for(int[] e: prerequisites){
            int a = e[0];
            int b = e[1];
            map.get(b).add(a);
        }
        Set<Integer> isVisited = new HashSet<>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < numCourses; i++){
            if(isVisited.contains(i)) continue;
            if(dfs(map, isVisited, new HashSet<Integer>(), i, stack)){
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for(int i = 0; i< numCourses; i++) res[i] = stack.pop();
        return res;
    }
    public boolean dfs(Map<Integer, Set<Integer>> map, Set<Integer> isVisited, Set<Integer> path, int node, Stack<Integer> stack){
        isVisited.add(node);
        path.add(node);
        for(int adj: map.get(node)){
            if(path.contains(adj)) return true;
            if(isVisited.contains(adj)) continue;
            if(dfs(map, isVisited, path, adj, stack))
                return true;
        }
        path.remove(node);
        stack.push(node);
        return false;
    }
}
