package Utils;

import Graph.Graph;

public class GraphUtils {

    public static Graph getMockGraphV2()
    {

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        return graph;
    }

    public static Graph getMockGraph()
    {
        Graph graph = new Graph(5);
        graph.addEdge(0,2);
        graph.addEdge(2,0);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        return graph;
    }

    public static Graph getMockWeightedGraph()
    {
        Graph graph = new Graph(5);
        graph.addEdge(0,1,9);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(0,4,3);
        graph.addEdge(2,1,2);
        graph.addEdge(2,3,4);

        return graph;
    }
}
