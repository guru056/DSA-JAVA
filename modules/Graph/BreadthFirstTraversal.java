package Graph;

import Utils.GraphUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.geeksforgeeks.org/bfs-disconnected-graph
//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
public class BreadthFirstTraversal {

    public static void main(String[] args) {
        Graph graph = GraphUtils.getMockGraph();
        System.out.println(getBFSTraversal(graph, 2));
        System.out.println(getBFSTraversal(graph));
    }

    //get BFS traversal for connected graph.
    public static List<Integer> getBFSTraversal(Graph graph, int sourceIndex)
    {
        boolean[] visited = new boolean[graph.V];
        List<Integer> resultList = new LinkedList<>();

        Queue<Integer> queue = new LinkedList<>();
        visited[sourceIndex] = true;
        queue.add(sourceIndex);

        while (!queue.isEmpty()){
            int currentIndex = queue.poll();
            resultList.add(currentIndex);
            List<Node> list = graph.vertices.get(currentIndex);
            for (Node n : list) {
                if (!visited[n.node]) {
                    visited[n.node] = true;
                    queue.add(n.node);
                }
            }
        }
        return resultList;
    }

    //BFS for disconnected graph
    public static List<Integer> getBFSTraversal(Graph graph)
    {
        int V = graph.V;
        boolean[] visited = new boolean[V];
        List<Integer> resultList = new LinkedList<>();
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                resultList.addAll(getBFSForNode(graph, i, visited));
            }
        }
        return resultList;
    }

    private static List<Integer> getBFSForNode(Graph graph, int sourceIndex, boolean[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceIndex);
        visited[sourceIndex] = true;
        List<Integer> resultList = new LinkedList<>();

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            resultList.add(currentIndex);
            List<Node> nodes = graph.vertices.get(currentIndex);
            for(Node n: nodes) {
                if (!visited[n.node]) {
                    visited[n.node] = true;
                    queue.add(n.node);
                }
            }
        }
        return resultList;
    }
}
