package Graph;

import java.util.Stack;

public class TopologicalSorting {



    public static void topologicalSort(Graph graph)
    {
        boolean[] visited = new boolean[graph.V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                topologicalSortRecursive(graph, i, visited, st);
            }
        }
        while (!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    public static void topologicalSortRecursive(Graph graph, int currentNode, boolean[] visited, Stack<Integer> st)
    {
        visited[currentNode] = true;
        for (Node node: graph.vertices.get(currentNode)) {
            if (!visited[node.node]) {
                topologicalSortRecursive(graph, node.node, visited, st);
            }
        }
        st.push(currentNode);
    }
}
