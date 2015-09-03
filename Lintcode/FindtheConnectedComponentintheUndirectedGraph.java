/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nodes == null || nodes.size() == 0){
            return res;
        }
        HashSet<UndirectedGraphNode> isVisited = new HashSet<>();
        List<Integer> list = new ArrayList<Integer>();
        for(UndirectedGraphNode e: nodes){
            if(!isVisited.contains(e)){
                dfs(res, list, isVisited, e);
                Collections.sort(list);
                res.add(new ArrayList<>(list));
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, HashSet<UndirectedGraphNode> isVisited, UndirectedGraphNode node){
        list.add(node.label);
        isVisited.add(node);
        for(UndirectedGraphNode e: node.neighbors){
            if(!isVisited.contains(e)){
                dfs(res, list, isVisited, e);
            }
        }
    }
}

public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nodes == null || nodes.size() == 0){
            return res;
        }
        HashSet<UndirectedGraphNode> isVisited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(UndirectedGraphNode e: nodes){
            if(!isVisited.contains(e)){
                queue.offer(e);
                isVisited.add(e);
                while(!queue.isEmpty()){
                    UndirectedGraphNode cur =  queue.poll();
                    list.add(cur.label);
                    for(UndirectedGraphNode node: cur.neighbors){
                        if(!isVisited.contains(node)){
                            queue.offer(node);
                            isVisited.add(node);
                        }
                    }
                }
                Collections.sort(list);
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
