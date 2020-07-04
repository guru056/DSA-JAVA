package Graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix
//https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
//@todo https://leetcode.com/problems/shortest-path-visiting-all-nodes/
//@todo https://leetcode.com/problems/all-paths-from-source-to-target/
class Coordinate{
    int i;
    int j;
    int dist;

    public Coordinate(int i, int j, int dist) {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
    public Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class ShortestPathInBinaryMaze {
    static int[] row = {-1,1,0,0};
    static int[] col = {0,0,-1,1};
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
        Coordinate src = new Coordinate(0,0);
        Coordinate dest = new Coordinate(3,4);
        System.out.println(getShortestPath(mat, src,dest));
        System.out.println(getShortestPathV2(mat, src,dest));
    }

    public static int getShortestPath(int[][] mat, Coordinate src, Coordinate dest)
    {
        int m = mat.length;
        int n = mat[0].length;
        int shortestPathLength = 0;

        boolean[][] visited = new boolean[m][n];
        Queue<Coordinate> queue = new LinkedList<>();
        visited[src.i][src.j] = true;
        queue.add(src);
        Coordinate currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            shortestPathLength = currentNode.dist ;
            if ( areSameNodes(currentNode, dest) ){
                return shortestPathLength;
            }
            shortestPathLength++;
            //top cell
            if (areValidCoordinates(mat, visited, currentNode.i-1,currentNode.j)) {
                visited[currentNode.i-1][currentNode.j] = true;
                queue.add(new Coordinate(currentNode.i-1,currentNode.j,shortestPathLength));
            }
            //bottom cell
            if (areValidCoordinates(mat, visited, currentNode.i+1,currentNode.j)) {
                visited[currentNode.i+1][currentNode.j] = true;
                queue.add(new Coordinate(currentNode.i+1,currentNode.j,shortestPathLength));
            }
            //left cell
            if (areValidCoordinates(mat, visited, currentNode.i,currentNode.j-1)) {
                visited[currentNode.i][currentNode.j-1] = true;
                queue.add(new Coordinate(currentNode.i,currentNode.j-1,shortestPathLength));
            }
            //right cell
            if (areValidCoordinates(mat, visited, currentNode.i,currentNode.j+1)) {
                visited[currentNode.i][currentNode.j+1] = true;
                queue.add(new Coordinate(currentNode.i,currentNode.j+1,shortestPathLength));
            }
        }
        return -1;
    }

    private static boolean areSameNodes(Coordinate src, Coordinate dest)
    {
        return src.i == dest.i && src.j == dest.j;
    }

    private static boolean areValidCoordinates(int[][] mat, boolean[][] visited, int i, int j)
    {
        return i >= 0 &&
                i < mat.length &&
                j >= 0 &&
                j < mat[i].length &&
                mat[i][j] == 1 &&
                !visited[i][j];
    }

    public static int getShortestPathV2(int[][] mat, Coordinate src, Coordinate dest)
    {
        int m = mat.length;
        int n = mat[0].length;
        int shortestPathLength = 0;

        boolean[][] visited = new boolean[m][n];
        Queue<Coordinate> queue = new LinkedList<>();
        visited[src.i][src.j] = true;
        queue.add(src);
        Coordinate currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            shortestPathLength = currentNode.dist ;
            if ( areSameNodes(currentNode, dest) ){
                return shortestPathLength;
            }
            shortestPathLength++;
            for (int i = 0 ; i < row.length; i++) {
                int XCoordinate = currentNode.i+row[i];
                int YCoordinate = currentNode.j+col[i];
                if (areValidCoordinates(mat,visited,XCoordinate,YCoordinate)){
                    visited[XCoordinate][YCoordinate] = true;
                    queue.add(new Coordinate(XCoordinate,YCoordinate,shortestPathLength));
                }
            }
        }
        return -1;
    }

}
