package Graph;


import java.util.LinkedList;
import java.util.Queue;

class BoardCoordinate {
    int i;
    int j;
    int val;

    public BoardCoordinate(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}


class QueueNode {
    BoardCoordinate coordinate;
    int dist;

    public QueueNode(BoardCoordinate coordinate, int dist) {
        this.coordinate = coordinate;
        this.dist = dist;
    }
}

//https://www.geeksforgeeks.org/snake-ladder-problem-2/
public class SnakeAndLaddersProblem {

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        int[][] board1 = {
                {-1, 4, -1},
                {6, 2, 6},
                {-1, 3, -1}
        };
        int[][] board2 = {
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1}
        };
        int[][] board3 = {
                {-1, -1, 2, -1},
                {14, 2, 12, 3},
                {4, 9, 1, 11},
                {-1, 2, 1, 16}
        };
        int[][] board4 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        int[][] board5 = {
                {-1, -1, -1, 46, 47, -1, -1, -1},
                {51, -1, -1, 63, -1, 31, 21, -1},
                {-1, -1, 26, -1, -1, 38, -1, -1},
                {-1, -1, 11, -1, 14, 23, 56, 57},
                {11, -1, -1, -1, 49, 36, -1, 48},
                {-1, -1, -1, 33, 56, -1, 57, 21},
                {-1, -1, -1, -1, -1, -1, 2, -1},
                {-1, -1, -1, 8, 3, -1, 6, 56}
        };
        System.out.println(snakesAndLadders(board));
        System.out.println(snakesAndLadders(board1));
        System.out.println(snakesAndLadders(board2));
        System.out.println(snakesAndLadders(board3));
        System.out.println(snakesAndLadders(board4));
        System.out.println(snakesAndLadders(board5));

    }

    public static int snakesAndLadders(int[][] board) {
        int N = board.length; //square board.
        BoardCoordinate src = new BoardCoordinate(N - 1, 0, 1);
        BoardCoordinate dest = N % 2 == 0 ? new BoardCoordinate(0, 0, N * N) : new BoardCoordinate(0, N - 1, N * N);
        boolean[][] visited = new boolean[N][N];

        Queue<QueueNode> queue = new LinkedList<>();
        visited[src.i][src.j] = true;
        queue.add(new QueueNode(src, 0));
        QueueNode currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (areSameCoordinates(currentNode.coordinate, dest)) {
                return currentNode.dist;
            }
            for (int i = 1; i <= 6; i++) {
                BoardCoordinate newCoordinate = getCoordinateForDiceRoll(board, currentNode.coordinate, i);
                if (isValidCoordinate(board, visited, newCoordinate)) {
                    visited[newCoordinate.i][newCoordinate.j] = true;
                    if (board[newCoordinate.i][newCoordinate.j] != -1) {
                        int destinationValue = board[newCoordinate.i][newCoordinate.j];
                        newCoordinate = getCoordinateForPosition(board, destinationValue);
                    }
                    if (board[newCoordinate.i][newCoordinate.j] == -1)
                        visited[newCoordinate.i][newCoordinate.j] = true;
                    queue.add(new QueueNode(newCoordinate, currentNode.dist + 1));
                }
            }
        }

        return -1;
    }

    private static BoardCoordinate getCoordinateForPosition(int[][] board, int position) {
        int N = board.length;
        if (position > N * N)
            return null;
        int row = position % N == 0 ? position / N : (position / N) + 1;
        int col = position % N == 0 ? N : position % N;
        row = N - row;
        if (N % 2 != 0) {
            col = row % 2 == 0 ? col - 1 : N - col;
        } else {
            col = row % 2 != 0 ? col - 1 : N - col;
        }
        return new BoardCoordinate(row, col, position);
    }

    private static BoardCoordinate getCoordinateForDiceRoll(int[][] board, BoardCoordinate currentPosition, int diceRollValue) {
        int position = currentPosition.val + diceRollValue;
        return getCoordinateForPosition(board, position);
    }

    private static boolean isValidCoordinate(int[][] board, boolean[][] visited, BoardCoordinate coordinate) {
        return coordinate != null &&
                coordinate.i >= 0 &&
                coordinate.i < board.length &&
                coordinate.j >= 0 &&
                coordinate.j < board[coordinate.i].length &&
                !visited[coordinate.i][coordinate.j];
    }

    private static boolean areSameCoordinates(BoardCoordinate src, BoardCoordinate dest) {
        return src.i == dest.i && src.j == dest.j;
    }

    private static void printBoardCoordinate(BoardCoordinate coordinate) {
        System.out.println(coordinate.i + " , " + coordinate.j + " : " + coordinate.val);
    }
}
