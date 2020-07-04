package Arrays.Misc;

import java.util.ArrayList;
import java.util.List;

public class JumpingCaterpillars {

    public static void main(String[] args) {
        int k = 3;
        int[] jumpFactor = {2,3,4};
        int n = 10;

        System.out.println(jumpingCaterpillars(jumpFactor, k, n));
    }

    /**
     * @param jumpFactor - jump factor for each caterpillar
     * @param k - number of caterpillars
     * @param n - number of leaves.
     * @return
     */
    public static List<Integer> jumpingCaterpillars(int[] jumpFactor, int k, int n)
    {
        List<Integer> unEatenLeaves = new ArrayList<>();
        boolean[] leavesState = new boolean[n+1];
        int currentJumpFactor;
        for (int i = 0; i < k; i++) {
            currentJumpFactor = jumpFactor[i];
            int iterator = currentJumpFactor;
            while (iterator <= n) {
                leavesState[iterator] = true;
                iterator += currentJumpFactor;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!leavesState[i]) {
                unEatenLeaves.add(i);
            }
        }

        return unEatenLeaves;
    }
}
