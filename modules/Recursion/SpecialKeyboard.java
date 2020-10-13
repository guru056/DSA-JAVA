package Recursion;

import java.util.Arrays;

//https://www.ijraset.com/fileserve.php?FID=24652#:~:text=The%20purpose%20is%20to%20print,complexity%20of%20O(n2).
//https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
public class SpecialKeyboard {

    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            System.out.println("Number of A's for keystrokes i = " + i + " : " + maxPossibleCountRecursive(i));
            System.out.println("Number of A's for keystrokes i = " + i + " : " + maxPossibleCountDP(i));
            System.out.println("Number of A's for keystrokes i = " + i + " : " + maxPossibleCountDPV2(i));
            System.out.println("Number of A's for keystrokes i = " + i + " : " + maxPossibleCount(i));
            System.out.println();
        }
    }

    /**
     * Decision points -
     * - Select A
     * - if no previous selection, Ctrl A + Ctrl C  + Ctrl V
     * - if previous selection, Ctrl A + Ctrl C  + Ctrl V
     * - if previous selection, Ctrl V
     *
     * @param N
     * @return
     */
    public static int maxPossibleLetterCount(int N) {
        currentSelection = 0;
        int result = maxPossibleCountRecursive(N);
        return result;
    }

    static int currentSelection = 0;

    /**
     * @param n
     * @return
     * @TODO complexity analysis
     */
    public static int maxPossibleCountRecursive(int n) {

        if (n <= 6)
            return n;

        int max1 = maxPossibleCountRecursive(n - 1); //Print A
        int max2 = maxPossibleCountRecursive(n - 3) * 2;

        int max = 0;
        for (int j = n - 3; j >= 1; j--) { // best Ctrl V
            currentSelection += 1;
            int curr = (n - j - 1) * maxPossibleCountRecursive(j);
            if (curr > max) {
                max = curr;
            }
        }
//        for (int j = n - 1; j  >= 4 ; j--) { // best Ctrl V
//            int curr = (n - j + 2) * maxPossibleCountRecursive(j-3);
//            if (curr > max) {
//                max = curr;
//            }
//        }
        return Math.max(Math.max(max1, max2), max);
    }

    public static int maxPossibleCountDP(int N) {
        int[] dp = new int[N + 1];

        for (int i = 0; i <= 6 && i <= N; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= N; i++) {
            int max1 = dp[i - 1] + 1; // print A
            int max2 = dp[i - 3] * 2; // Ctrl A + Ctrl C + Ctrl V

//            for (int j = i - 1; j - 3 > 0 ; j--) { // best Ctrl V
//                dp[i] = Math.max(dp[i] , dp[j-3] + ((i-j+1 )*dp[j-3]));
//            }
            for (int j = i - 3; j > 0; j--) {
                dp[i] = Math.max(dp[i], Math.max(dp[i], (i - j + 1 - 3 + 1) * dp[j]));
            }
            dp[i] = Math.max(dp[i], Math.max(max1, max2));
        }
        return dp[N];
    }

    /**
     * As the number of A’s become large, the effect of pressing Ctrl-V more than 3 times starts to become
     * insubstantial as compared to just pressing Ctrl-A, Ctrl-C and Ctrl-V again.
     * So, the above code can be made more efficient by checking the effect of pressing Ctrl-V for 1, 2, and 3 times only.
     *
     * @param N
     * @return
     */
    public static int maxPossibleCountDPV2(int N) {
        int[] dp = new int[N + 1];

        for (int i = 0; i <= 6 && i <= N; i++) {
            dp[i] = i;
        }
        for (int i = 7; i <= N; i++) {
            dp[i] = Math.max(2 * dp[i - 3],
                    Math.max(3 * dp[i - 4], 4 * dp[i - 5]));
        }
        return dp[N];
    }

    /**
     * We are capable of finding the result values for all N, using only a limited set of result values after a breakpoint
     * (N=11, 12, 13, 14, 15).
     * Each result value after the breakpoint is calculated by skipping 4 values behind and multiplying the 5th value by 4.
     * reference -- https://www.ijraset.com/fileserve.php?FID=24652#:~:text=The%20purpose%20is%20to%20print,complexity%20of%20O(n2).
     *
     * @param N
     * @return
     */
    public static int maxPossibleCount(int N) {
        int[] referArray = new int[]{0, 1, 2, 3, 4, 5, 6, 9, 12, 16, 20, 27, 36, 48, 64, 81};

        if (N <= 15)
            return referArray[N];
        int offset = 11 + ((N - 11) % 5);
        int exp = (N - offset) / 5;
        // multiply 4 to referArray[offset] exp times
        return referArray[offset] * (int) Math.pow(4, exp);
    }
}
