package Graph;

import java.util.LinkedList;
import java.util.List;

class Node {
    int node;
    int weight;

    public Node(int node) {
        this.node = node;
        this.weight = node;
    }

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + node +
                ", val=" + weight +
                '}';
    }
}

public class Graph {

    public int V; //no of vertices
    public List<List<Node>> vertices;

    public Graph(int v)
    {
        this.V = v;
        this.vertices = new LinkedList<List<Node>>();
        for (int i = 0 ; i < V; i++) {
            this.vertices.add(new LinkedList<Node>());
        }
    }

    public void addEdge(int src, int dest)
    {
        this.vertices.get(src).add(new Node(dest));
    }

    public void addEdge(int src, int dest, int weight)
    {
        this.vertices.get(src).add(new Node(dest, weight));
    }

    public void printGraph()
    {
        for (int i = 0 ; i < this.vertices.size(); i++) {
            System.out.print("Adjacency list at vertex  : " + i + " :: ");
            for (int j = 0 ; j < this.vertices.get(i).size(); j++) {
                System.out.print(this.vertices.get(i).get(j) + " -> ");
            }
            System.out.println();
        }
    }
}
