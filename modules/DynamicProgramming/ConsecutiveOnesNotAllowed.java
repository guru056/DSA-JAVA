package DynamicProgramming;

//https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
//@todo solve in logN
//@TODO https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
public class ConsecutiveOnesNotAllowed {

    public static void main(String[] args) {
        System.out.println(countStringsWithoutConsecutiveOnes(0));
        System.out.println(countStringsWithoutConsecutiveOnes(1));
        System.out.println(fib(3));
        System.out.println(countStringsWithoutConsecutiveOnes(2));
        System.out.println(fib(4));
        System.out.println(countStringsWithoutConsecutiveOnes(3));
        System.out.println(fib(5));
        System.out.println(countStringsWithoutConsecutiveOnes(4));
        System.out.println(fib(6));
        System.out.println(countStringsWithoutConsecutiveOnes(5));
        System.out.println(fib(7));
    }

    public static int countStringsWithoutConsecutiveOnes(int n)
    {
        if (n == 0 )
            return 0;
        int[] stringsEnding0 = new int[n];
        int[] stringsEnding1 = new int[n];

        stringsEnding0[0] = stringsEnding1[0] = 1;

        for (int i = 1; i < n; i++){
            stringsEnding0[i] = stringsEnding0[i-1] + stringsEnding1[i-1];
            stringsEnding1[i] = stringsEnding0[i-1];
        }

        return stringsEnding0[n-1] + stringsEnding1[n-1];
    }

    public static int fib(int n) {
        if (n == 0)
            return 0;
        int[][] F = new int[][]{{1,1},{1,0}};
        powerV2(F, n - 1);
        return F[0][0];
    }

    public static void power(int[][] F, int n) {
        int[][] M = new int[][] {{1,1},{1,0}};

        for (int i = 0 ; i < n; i++) {
            multiply(F, M);
        }
    }

    public static void multiply(int[][] F, int[][] M) {

        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int t = F[1][0] * M[1][0] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = t;
    }


    public static void powerV2(int[][] F, int n) {
        if (n == 0 || n == 1)
            return;

        int[][] M = new int[][] {{1,1},{1,0}};

        powerV2(F, n/2);
        multiply(F,F);

        if (n % 2 != 0)
            multiply(F,M);
    }

    /* Function to calculate x raised to the power y */
    static int power(int x, int y)
    {
        int temp;
        if (y == 0)
            return 1;
        temp = power(x, y/2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }
}
