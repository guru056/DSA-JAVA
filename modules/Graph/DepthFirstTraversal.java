package Graph;

import Utils.GraphUtils;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstTraversal {
    static List<Integer> resultList = new LinkedList<>();

    public static void main(String[] args) {
        Graph graph = GraphUtils.getMockGraph();
        depthFirstTraversal(graph, 2);
    }

    public static void depthFirstTraversal(Graph graph, int sourceIndex)
    {
        boolean[] visited = new boolean[graph.V];
        dfsRecursive(graph, sourceIndex, visited);
        System.out.println(resultList);
        resultList.clear();
    }

    public static void dfsRecursive(Graph graph, int currentNode, boolean[] visited)
    {
        resultList.add(currentNode);
        visited[currentNode] = true;
        List<Node> list = graph.vertices.get(currentNode);
        for (Node node: list) {
            if (!visited[node.node]) {
                dfsRecursive(graph, node.node, visited);
            }
        }
    }
}
