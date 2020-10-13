package Arrays.Misc;

import java.util.LinkedList;

//https://www.geeksforgeeks.org/program-to-find-number-of-squares-on-a-chessboard/
public class CountSquares {

    /**
     * 8*(8) + 7*(7) + 6*(6) + ... + 1 * 1
     * 1^2 + 2^2 + ... + n^2 = n(n+1)(2n+1)/6
     * n*(n+1) is always even
     * n(n+1)(2n+1)/6 = (n*(n+1)/2) * ((2n+1)/3)
     * @param N
     * @return
     */
    public static int countSquares(int N) {
        return ((N*(N+1))/2) * ((2*N+1)/3);
    }
}
