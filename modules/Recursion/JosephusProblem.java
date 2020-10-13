package Recursion;

//https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
public class JosephusProblem {

    public static void main(String[] args) {

        System.out.println(josephus(7,2));
        System.out.println(josephusV2(7));
        System.out.println(josephusRecursiveV2(7,2));
        System.out.println(josephus(5,2));
        System.out.println(josephusV2(5));
        System.out.println(josephusRecursiveV2(5,2));

    }

    /**
     * returns 0 based index.
     * Time Complexity: O(n)
     * @param n
     * @param k
     * @return
     */
    public static int josephus(int n, int k) {
        if (n == 1)
            return 0;
        return (josephus(n-1,k) + k) % n;
    }

    /**
     * returns 1 based index
     * for +(k -1) part, take example of n =2 , k = 2
     * @param n
     * @param k
     * @return
     */
    public static int josephusRecursiveV2(int n, int k) {
        if (n == 1)
            return 1;
        return ((josephusRecursiveV2(n-1,k) + k-1) % n) + 1;
    }

    /**
     * For special case of k = 2.
     * N = 2^a + L
     * if L == 0, answer = 1
     * if L != 0, answer = 2 * L + 1
     * @param n
     * @return
     */
    public static int josephusV2(int n) {
        int i = 1;
        while (i <= n) {
            i = i * 2;
        }
        if (i == n)
            return 1;
        return 2 * (n - (i / 2)) + 1;
    }
}
