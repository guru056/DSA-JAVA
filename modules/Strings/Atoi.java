package Strings;

//https://leetcode.com/problems/string-to-integer-atoi/
//https://www.geeksforgeeks.org/recursive-implementation-of-atoi/
//https://www.geeksforgeeks.org/write-your-own-atoi/
public class Atoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("123"));
        System.out.println(myAtoiRecursive("123", 3));
    }

    /**
     * - Invalid characters
     * - Negative Numbers
     * - Integer overflow
     * Returns the corresponding integer for valid input and 0 for invalid input
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        if (i == str.length())
            return 0;

        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        int result = 0;
        for (; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                break;
            if (Integer.MAX_VALUE / 10 < result || result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i) - '0');
        }
        return result * sign;
    }

    public static int myAtoiRecursive(String str, int n) {
        if (n == 1)
            return str.charAt(n - 1) - '0';
        return 10 * myAtoiRecursive(str, n - 1) + str.charAt(n - 1) - '0';
    }

}
