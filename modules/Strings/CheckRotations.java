package Strings;

//https://www.geeksforgeeks.org/check-strings-rotations-not-set-2/
//https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
public class CheckRotations {

    public static void main(String[] args) {
        String str1 = "ABACD";
        String str2 = "CDABA";
        System.out.println(isRotation(str1, str2));
        System.out.println(isRotationV2(str1, str2));
    }
    /**
     * Find the longest common suffix in str1 which is a prefix on str2.
     *
     * Eg, str1 - ABACD
     *     str2 - CDABA
     *     LPS = [0,0,0,1,2]
     *     While constructing LPS, we know that the last two characters of str1 and first two
     *     characters of str2 already match. We need to check if all characters from 0 in str1
     *     and kth index in str2 match or not.
     * Time Complexity - O(N)
     * Space Complexity - O(N)
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isRotation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if (n != m)
            return false;
        int[] LPS = new int[n];
        int i = 1;
        int LPSLengthSoFar = 0;

        while (i < n) {
            if (str1.charAt(i) == str2.charAt(LPSLengthSoFar)) {
                LPS[i++] = ++LPSLengthSoFar;
            } else if (LPSLengthSoFar == 0 ) {
                LPS[i++] = 0;
            } else {
                LPSLengthSoFar = LPS[LPSLengthSoFar - 1];
            }
        }
        i = 0;
        for (int k = LPS[n-1]; k < m; k++) {
            if (str1.charAt(i++) != str2.charAt(k))
                return false;
        }
        return true;
    }

    /**
     * Time complexity depends on implementation of strstr.
     * Assuming KMP is being used, it is O(N)
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isRotationV2(String str1, String str2) {
        return str1.length() == str2.length() && (str1 + str1).indexOf(str2) != -1;
    }
}
