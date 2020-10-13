package Recursion;

import Utils.MatrixUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
//https://www.geeksforgeeks.org/flood-fill-algorithm/
//https://leetcode.com/problems/flood-fill/
public class FloodFillAlgorithm {

    private final static int[] XCoordinates = {-1,-1,-1,0,0,1,1,1};
    private final static int[] YCoordinates = {-1,0,-1,1,-1,-1,0,1};

    public static void main(String[] args) {
        int[][] screen = {{1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4;
        int y = 4;
        int newColor = 3;
        fill(screen,x,y,newColor);
//        fillBFS(screen,x,y,newColor);
//        MatrixUtils.printMatrix(screen);

        int[][] screen1 = {{1,1,1}, {1,1,0},{1,0,1}};
        int x1 = 1;int y1 = 1; int newColor1 = 2;
        fill(screen1,x1,y1,newColor1);
        MatrixUtils.printMatrix(screen1);
    }

    /**
     * Note : visited array would be required in both the implementations if newColor can be same as oldColor
     * @param screen
     * @param x
     * @param y
     * @param newColor
     */
    public static void fill(int[][] screen, int x, int y, int newColor) { //1ms
        if (!isValidCoordinate(screen,x,y))
            return;
        int oldColor = screen[x][y];

        fillRecursively(screen, x,y,oldColor,newColor);
    }

    private static void fillRecursively(int[][] screen, int x, int y, int oldColor, int newColor) {
        if (!isValidCoordinateForFilling(screen, x, y, oldColor))
            return;
        screen[x][y] = newColor;
        for (int i = 0; i < XCoordinates.length; i++) {
            fillRecursively(screen, x + XCoordinates[i], y + YCoordinates[i], oldColor,newColor);
        }
    }

    private static boolean isValidCoordinate(int[][] screen, int i, int j) {
        return i >= 0 &&
                i < screen.length &&
                j >= 0 &&
                j < screen[0].length;
    }

    private static boolean isValidCoordinateForFilling(int[][] screen, int x, int y, int oldColor) {
        return isValidCoordinate(screen, x, y) &&
                screen[x][y] == oldColor;
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void fillBFS(int[][] screen, int x, int y, int newColor) { //2ms
        if (!isValidCoordinate(screen,x,y))
            return;
        int oldColor = screen[x][y];

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x,y));
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            screen[coordinate.x][coordinate.y] = newColor;
            for (int i = 0 ; i < XCoordinates.length; i++) {
                if (isValidCoordinateForFilling(screen, coordinate.x + XCoordinates[i], coordinate.y + YCoordinates[i], oldColor))
                    queue.add(new Coordinate(coordinate.x + XCoordinates[i], coordinate.y + YCoordinates[i]));
            }
        }
    }
}
