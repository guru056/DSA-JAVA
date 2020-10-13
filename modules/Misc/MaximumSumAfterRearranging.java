package Misc;

import java.util.Arrays;

public class MaximumSumAfterRearranging {
    public static void main(String[] args) {
        int[] A = {1,9,1,6};
        int[][] R = {{1,1}, {1,2},{1,3}}; // 9 + 15 + 16 = 40
        // 9+10+16 = 35
        int N = 4;
        int M = 3;

        System.out.println(maxSumArrangement(A,R,N,M));
    }

    public static int maxSumArrangement(int A[], int R[][],
                                    int N, int M) {
        // Auxiliary array to find the
        // count of each selected elements
        int count[] = new int[N];
        int i;

        // Finding count of every element
        // to be selected
        for ( i = 0; i < M; ++i) {

            int l = R[i][0], r = R[i][1] + 1;

            // Making it to 0-indexing
//            l--;
//            r--;

            // Prefix sum array concept is used
            // to obtain the count array
            count[l]++;

            if (r < N)
                count[r]--;
        }

        // Iterating over the count array
        // to get the final array
        for (i = 1; i < N; ++i) {
            count[i] += count[i - 1];
        }

        int alice = 0;
        for (int k = 0; k < N; k++) {
            alice += (A[k]*count[k]);
        }
//        // Variable to store the maximum sum
        int ans = 0;

        // Sorting both the arrays
        Arrays.sort( count);
        Arrays.sort(A);

        // Loop to find the maximum sum
//        for (i = N - 1; i >= 0; --i) {
//            ans += A[i] * count[i];
//        }

        for (i = 0; i < N; i++) {
            ans += A[i] * count[i];
        }

        return  Math.abs(ans - alice);
    }
}
