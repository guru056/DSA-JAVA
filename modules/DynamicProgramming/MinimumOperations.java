package DynamicProgramming;

//https://www.geeksforgeeks.org/minimum-cost-to-reach-a-point-n-from-0-with-two-different-operations-allowed/
public class MinimumOperations {

    public static void main(String[] args) {
        int N = 9;
        int P = 5;
        int Q = 1;

        System.out.println(minOperations(N, P, Q));
        System.out.println(minOperationIterative(N, P, Q));
    }

    public static int minOperations(int N, int P, int Q)
    {
        if (N == 0)
            return 0;
        if (N < 0)
            return Integer.MAX_VALUE;

        int costQ = Integer.MAX_VALUE;
        int costP = P + minOperations(N-1, P, Q);

        if (N % 2 == 0){
            costQ = Q + minOperations(N/2, P, Q);
        }

        return Math.min(costP, costQ);
    }

    public static int minOperationIterative(int N, int P, int Q)
    {
        int cost = 0;

        while (N > 0){
            if (N % 2 != 0){
                N--;
                cost += P;
            } else{
                int steps = N/2;
                if (Q < steps*P){
                    cost += Q;
                } else {
                    cost += steps*P;
                }
                N /= 2;
            }
        }
        return cost;
    }
}
