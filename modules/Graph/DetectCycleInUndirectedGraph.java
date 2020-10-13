package Graph;

import Utils.GraphUtils;

//https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {
        Graph graph = GraphUtils.getMockGraph();
        System.out.println(isCyclic(graph));
    }

    public static boolean isCyclic(Graph graph) {
        boolean[] visited = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i] && isCyclicRecursive(graph, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCyclicRecursive(Graph graph, boolean[] visited, int currentNode, int parentNode) {
        visited[currentNode] = true;

        for (Node node : graph.vertices.get(currentNode)) {
            if (!visited[node.node]) {
                return isCyclicRecursive(graph, visited, node.node, currentNode);
            } else if (node.node != parentNode) {
                return true;
            }
        }
        return false;
    }
}
