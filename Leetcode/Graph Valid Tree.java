/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.
For example:
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0 ; i < n; i++){
            g.put(i, new HashSet<Integer>());
        }
        for(int i = 0 ; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            g.get(a).add(b);
            g.get(b).add(a);
        }
        boolean[] isVisited = new boolean[n];
        if(dfs(g, 0, isVisited, -1)){
            return false;
        }
        
        for(int i = 0 ; i < n; i++){
            if(!isVisited[i]){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(Map<Integer, Set<Integer>> g, int cur, boolean[] isVisited, int parent){
        isVisited[cur] = true;
        for(int adj: g.get(cur)){
            if(isVisited[adj] && adj != parent) return true;
            if(!isVisited[adj] && dfs(g, adj, isVisited, cur)){
                return true;
            }
        }
        return false;
    }
}
