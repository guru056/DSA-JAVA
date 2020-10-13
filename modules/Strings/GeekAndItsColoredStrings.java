package Strings;

//https://www.geeksforgeeks.org/count-number-of-strings-made-of-r-g-and-b-using-given-combination/
public class GeekAndItsColoredStrings {


    public static void main(String[] args) {
        int n = 4, r = 1, g = 1, b = 1;
        System.out.println(getPermutationCount(n, r, g, b));
    }

    public static int getPermutationCount(int n, int r, int g, int b) {

        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        int remaining = n - (r + g + b);
        int permutationCount = 0;
        for (int R = 0; R <= remaining; R++) {
            for (int G = 0; G <= remaining - R; G++) {
                int B = remaining - (R + G);
                permutationCount += ((fact[n]) / (fact[R + r] * fact[G + g] * fact[B + b]));
            }
        }
        return permutationCount;
    }
}
