package Queue;

import Utils.MatrixUtils;

import java.util.LinkedList;
import java.util.Queue;

class OrangePosition {
    int i;
    int j;

    public OrangePosition(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
public class RottenOranges {

    public static void main(String[] args) {
        int[][] mat = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        System.out.println(getTimeToRotAllOranges(mat));
        MatrixUtils.printMatrix(mat);
    }

    public static int getTimeToRotAllOranges(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int timeToRot = 0;
        Queue<OrangePosition> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0 || mat[i][j] == 1)
                    continue;
                visited[i][j] = true;
                queue.add(new OrangePosition(i, j));
            }
        }

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            while (nodeCount-- > 0) {
                OrangePosition currentOrange = queue.poll();
                if (checkValidPosition(currentOrange.i - 1, currentOrange.j, mat, visited)) {
                    visited[currentOrange.i - 1][currentOrange.j] = true;
                    mat[currentOrange.i - 1][currentOrange.j] = 2;
                    queue.add(new OrangePosition(currentOrange.i - 1, currentOrange.j));
                }
                if (checkValidPosition(currentOrange.i + 1, currentOrange.j, mat, visited)) {
                    visited[currentOrange.i + 1][currentOrange.j] = true;
                    mat[currentOrange.i + 1][currentOrange.j] = 2;
                    queue.add(new OrangePosition(currentOrange.i + 1, currentOrange.j));
                }
                if (checkValidPosition(currentOrange.i, currentOrange.j - 1, mat, visited)) {
                    visited[currentOrange.i][currentOrange.j - 1] = true;
                    mat[currentOrange.i][currentOrange.j - 1] = 2;
                    queue.add(new OrangePosition(currentOrange.i, currentOrange.j - 1));
                }
                if (checkValidPosition(currentOrange.i, currentOrange.j + 1, mat, visited)) {
                    visited[currentOrange.i][currentOrange.j + 1] = true;
                    mat[currentOrange.i][currentOrange.j + 1] = 2;
                    queue.add(new OrangePosition(currentOrange.i, currentOrange.j + 1));
                }
            }
            if (!queue.isEmpty())
                timeToRot++;
        }
        return areAllOrangesRotted(mat) ? timeToRot : -1;
    }

    public static boolean checkValidPosition(int i, int j, int[][] mat, boolean[][] visited) {
        return i >= 0 &&
                i < mat.length &&
                j >= 0 &&
                j < mat[0].length &&
                visited[i][j] == false &&
                mat[i][j] == 1;
    }

    public static boolean areAllOrangesRotted(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}
