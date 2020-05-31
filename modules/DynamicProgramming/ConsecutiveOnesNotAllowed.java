package DynamicProgramming;

//https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
//@todo solve in logN
public class ConsecutiveOnesNotAllowed {

    public static void main(String[] args) {
        System.out.println(countStringsWithoutConsecutiveOnes(3));
    }

    public static int countStringsWithoutConsecutiveOnes(int n)
    {
        int[] stringsEnding0 = new int[n+1];
        int[] stringsEnding1 = new int[n+1];

        stringsEnding0[0] = stringsEnding0[1] = stringsEnding1[0] = stringsEnding1[1] = 1;

        for (int i = 2; i <= n; i++){
            stringsEnding0[i] = stringsEnding0[i-1] + stringsEnding1[i-1];
            stringsEnding1[i] = stringsEnding0[i-1];
        }

        return stringsEnding0[n] + stringsEnding1[n];
    }
}
