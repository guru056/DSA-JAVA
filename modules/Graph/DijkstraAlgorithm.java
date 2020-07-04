package Graph;

import Utils.ArrayUtils;
import Utils.GraphUtils;

import java.util.*;

//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue
public class DijkstraAlgorithm {

    public static void main(String[] args) {
        int graph[][] = new int[][] {
                                        { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
                                    };
        ArrayUtils.printArr(getShortestPaths(graph,0));

        Graph graph1 = GraphUtils.getMockWeightedGraph();
        ArrayUtils.printArr(getShortestPaths(graph1, 0));
    }

    public static int[] getShortestPaths(int[][] graph, int src)
    {
        int V = graph.length;

        boolean[] shortestPathSet = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        for (int i = 0; i < V; i++ ) {
            int minIndex = getMinDistanceIndex(dist, shortestPathSet);
            shortestPathSet[minIndex] = true;

            for (int v = 0 ; v < V; v++) {

                if (
                        graph[minIndex][v] != 0 && //there must exist a path from u to v
                        !shortestPathSet[v] && //shortest path for this vertex is not finalized yet
                        dist[minIndex] != Integer.MAX_VALUE &&
                        dist[minIndex] + graph[minIndex][v] < dist[v]
                ) {
                    dist[v]  = dist[minIndex] + graph[minIndex][v];
                }
            }
        }
        return dist;
    }

    private static int getMinDistanceIndex(int[] dist, boolean[] shortestSetPath)
    {
        int minIndex = -1;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0 ; i < dist.length; i++) {
            if (!shortestSetPath[i] && dist[i] <= minVal){
                minIndex = i;
                minVal = dist[i];
            }
        }
        return minIndex;
    }

    public static int[] getShortestPaths(Graph graph, int src)
    {
        int V = graph.V;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Set<Integer> settled = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if (node1.weight < node2.weight)
                    return -1;
                else if (node1.weight > node2.weight)
                    return 1;
                return 0;
            }
        });

        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (settled.size() != V) {
            Node currentNode = pq.poll();
            settled.add(currentNode.node);

            List<Node> adjacentNodes = graph.vertices.get(currentNode.node);
            for(Node n: adjacentNodes) {
                if (
                        !settled.contains(n.node) && //process only if the node has not been finalized yet
                        dist[currentNode.node] != Integer.MAX_VALUE &&
                        dist[currentNode.node] + n.weight < dist[n.node]
                ) {
                        dist[n.node] = dist[currentNode.node] + n.weight;
                }
                pq.add(new Node(n.node, dist[n.node]));
            }
        }
        return dist;
    }
}
