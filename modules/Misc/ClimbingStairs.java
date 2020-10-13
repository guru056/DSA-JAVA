package Misc;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climb(7,3));
    }
    public static int climb(int n, int k) {
        int []includes_3 = new int[n + 1];

        // Array including number of
        // ways that doesn't includes 3
        int []not_includes_3 = new int[n + 1];

        // Initially to reach 3 stairs by
        // taking 3 steps can be
        // reached by 1 way
//        includes_3[3] = 1;
        int j = 3;
        while (k-- > 0) {
            if ( j % 3 == 0) {
                includes_3[j] += includes_3[j-3];
            } else {
                includes_3[j] = includes_3[j-1];
            }
            j++;
        }

        not_includes_3[0] = 1;
        not_includes_3[1] = 1;
        not_includes_3[2] = 2;
//        not_includes_3[3] = 3;

        // Loop to find the number
        // the number of ways to reach Nth stair
        for (int i = 3; i <= n; i++)
        {
            includes_3[i]
                    = includes_3[i - 1] + includes_3[i - 2] +
                    not_includes_3[i - 3];
            not_includes_3[i]
                    = not_includes_3[i - 1] + not_includes_3[i - 2];
        }
        return includes_3[n];
    }
}
