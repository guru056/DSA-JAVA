package Graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MinimumStepsByKnight {
    static int[] XCoordinates = {-2, -2, 2, 2, 1, -1, 1, -1};
    static int[] YCoordinates = {1, -1, 1, -1, 2, 2, -2, -2};

    static class Coordinate {
        int i;
        int j;
        int distance;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Coordinate(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return i == that.i &&
                    j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static void main(String[] args) {
        int N = 30;
        Coordinate src = new Coordinate(0, 0);
        Coordinate dest = new Coordinate(29, 29);

        System.out.println(getMinSteps(N, src, dest));

        int N1 = 6;
        Coordinate src1 = new Coordinate(4, 3);
        Coordinate dest1 = new Coordinate(0, 0);

        System.out.println(getMinSteps(N1, src1, dest1));

    }

    public static int getMinSteps(int n, Coordinate src, Coordinate dest) {
        boolean[][] visited = new boolean[n][n];

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(src);
        visited[src.i][src.j] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (current.equals(dest)) {
                return current.distance;
            }

            for (int x = 0; x < XCoordinates.length; x++) {
                int X = current.i + XCoordinates[x];
                int Y = current.j + YCoordinates[x];
                if (areValidCoordinates(n, visited, X, Y)) {
                    visited[X][Y] = true;
                    queue.add(new Coordinate(X, Y, current.distance + 1));
                }
            }
        }
        return -1;
    }

    private static boolean areValidCoordinates(int n, boolean[][] visited, int i, int j) {
        return i >= 0 &&
                i < n &&
                j >= 0 &&
                j < n &&
                !visited[i][j];
    }
}
