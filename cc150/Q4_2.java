import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static Graph createNewGraph() {
        Graph g = new Graph(6);
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static void main(String[] args) {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        System.out.println(search(g, start, end));
    }
    public static boolean search(Graph g,Node start,Node end) {  
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        Node u;
        while(!q.isEmpty()) {
            u = q.poll();
            if (u != null) {
                for (Node v : u.getNeighbor()) {
                    if (v.isvisited == false) {
                        if (v == end) {
                            return true;
                        } else {
                            q.add(v);
                        }
                    }
                }
                u.isvisited = true;
            }
        }
        return false;
    }
}

class Graph {
    private Node[] vertices;
    public int count;

    public Graph(int num) {
        vertices = new Node[num];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < vertices.length) {
            vertices[count++] = x;
        } else {
            System.out.println("Full Graph");
        }
    }

    public Node[] getNodes() {
        return vertices;
    }
}

class Node {
    private Node[] neighbor;
    private int count;
    private String vertex;
    public boolean isvisited;

    public Node(String vertex, int neighborlen) {
        this.vertex = vertex;
        isvisited = false;
        count = 0;
        neighbor = new Node[neighborlen];
    }

    public void addAdjacent(Node x) {
        if (count < neighbor.length) {
            this.neighbor[count++] = x;
        } else {
            System.out.println("Full Neighbors");
        }
    }

    public Node[] getNeighbor() {
        return neighbor;
    }

    public String getVertex() {
        return vertex;
    }
}
