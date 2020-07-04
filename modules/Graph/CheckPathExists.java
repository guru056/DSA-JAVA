package Graph;


import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/
public class CheckPathExists {

    public static void main(String[] args) {
        int[][] M = { { 0, 3, 0, 1 },
                { 3, 0, 3, 3 },
                { 2, 3, 3, 3 },
                { 0, 3, 3, 3 } };
        System.out.println(hasPath(M));
    }

    public static boolean hasPath(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        Coordinate src = null , dest = null;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) { //dest
                    dest = new Coordinate(i,j);
                } else if (mat[i][j] == 1) { //src
                    src = new Coordinate(i, j);
                }
            }
            if (src != null && dest != null)
                break;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<Coordinate> queue = new LinkedList<>();
        visited[src.i][src.j] = true;
        queue.add(src);
        Coordinate currentNode;
        int[] XMovements = {-1,1,0,0};
        int[] YMovements = {0,0,-1,1};

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (areSameCoordinates(currentNode, dest))
                return true;

            for (int i = 0 ; i < 4; i++) {
                int X = currentNode.i + XMovements[i];
                int Y = currentNode.j + YMovements[i];
                if (areValidCoordinates(mat,visited, X,Y)){
                    visited[X][Y] = true;
                    queue.add(new Coordinate(X,Y));
                }
            }
        }

        return false;
    }

    private static boolean areSameCoordinates(Coordinate src, Coordinate dest)
    {
        return src.i == dest.i && src.j == dest.j;
    }


    private static boolean areValidCoordinates(int[][] mat, boolean[][] visited, int i, int j)
    {
        return i >= 0 &&
                i < mat.length &&
                j >= 0 &&
                j < mat[i].length &&
                (mat[i][j] == 3 || mat[i][j] == 2) &&
                !visited[i][j];
    }
}
