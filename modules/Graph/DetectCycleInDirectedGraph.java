package Graph;

//https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
public class DetectCycleInDirectedGraph {


    public static boolean isCyclic(Graph graph)
    {
        boolean[] visited = new boolean[graph.V];
        boolean[] recStack = new boolean[graph.V];

        for (int i = 0 ; i < graph.V; i++) {
            if (!visited[i]){
                if (isCyclicRecursive(graph, i, visited, recStack))
                    return true;
            }
        }
        return false;
    }

    public static boolean isCyclicRecursive(Graph graph, int currentNode, boolean[] visited, boolean[] recStack)
    {
        if (recStack[currentNode])
            return true;
//        if (visited[currentNode])
//            return false;
        visited[currentNode] = true;
        recStack[currentNode] = true;

        for (Node node: graph.vertices.get(currentNode)){
            if (!visited[currentNode] && isCyclicRecursive(graph, node.node, visited, recStack))
                return true;
        }
        recStack[currentNode] = false;
        return false;
    }
}
