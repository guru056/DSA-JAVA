package DynamicProgramming;

//https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
public class EggDroppingPuzzle {

    public static void main(String[] args) {
        int numFloors = 10;
        int numEggs = 2;

        System.out.println(getLeastEggDroppingsRecursive(numFloors, numEggs));
        System.out.println(getLeastEggDroppingsDP(numFloors, numEggs));
    }

    public static int getLeastEggDroppingsRecursive(int numFloors, int numEggs) {
        if (numFloors == 0 || numFloors == 1) { // for one or zero floors
            return numFloors;
        }
        if (numEggs == 1) {
            return numFloors;
        }

        int res = Integer.MAX_VALUE;
        for (int floor = 1; floor <= numFloors; floor++) {
            int resultEggBreaks = getLeastEggDroppingsRecursive(floor - 1, numEggs - 1); // egg breaks
            int resultEggDoesntBreak = getLeastEggDroppingsRecursive(numFloors - floor, numEggs);

            res = Math.min(res, 1 + Math.max(resultEggBreaks, resultEggDoesntBreak));
        }
        return res;
    }

    /**
     * floors = 10, eggs = 2
     * 0 1 2 3 4 5 6 7 8 9 10
     * 0 0 1
     * 1 0 1 2 3 4 5 6 7 8 9 10
     * 2 0 1 2 2 3 3 3 4 4 4 4
     * <p>
     * <p>
     * i = 2
     * j = 3
     * x = 1 to 3
     * x = 1
     * 1 + max (dp[i-1][x-1],dp[i][j-x] ) = 1 + max(dp[1][0], dp[2][2]) = 2
     * <p>
     * x = 2
     * 1 + max(dp[1][1], dp[2][1])
     * int eggBreak = dp[egg-1][floor-1] = 2
     * int eggDoesntBreak = dp[egg][j-floor]
     *
     * @param numFloors
     * @param numEggs
     * @return
     */
    public static int getLeastEggDroppingsDP(int numFloors, int numEggs) {

        int[][] dp = new int[numEggs + 1][numFloors + 1];
        for (int i = 0; i <= numEggs; i++) { // if we have 0 or 1 floors
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 0; i <= numFloors; i++) { // if we have only one egg
            dp[1][i] = i;
        }

        for (int i = 2; i <= numEggs; i++) {
            for (int j = 2; j <= numFloors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int floor = 1; floor <= j; floor++) {
                    int eggBreaks = dp[i-1][floor-1];
                    int eggDoesntBreak = dp[i][j - floor];
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(eggBreaks, eggDoesntBreak));
                }
            }
        }
        return dp[numEggs][numFloors];
    }
}
