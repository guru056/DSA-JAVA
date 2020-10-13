package Strings;

import java.util.Arrays;

//https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/
public class ZigZagConcatenation {

    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        System.out.println(zigZagConcatenation(str, 4));
        System.out.println(zigZagConcatenation(str, 3));
        System.out.println(zigZagConcatenation("ABCDEFGH", 2));

        System.out.println();
        System.out.println(zigZagConcatenationV2(str, 4));
        System.out.println(zigZagConcatenationV2(str, 3));
        System.out.println(zigZagConcatenationV2("ABCDEFGH", 2));
    }

    /**
     * Input: str = "ABCDEFGH"
     *        n = 2
     * Output: "ACEGBDFH"
     * Explanation: Let us write input string in Zig-Zag fashion
     *              in 2 rows.
     * A   C   E   G
     *   B   D   F   H
     * Now concatenate the two rows and ignore spaces
     * in every row. We get "ACEGBDFH"
     *
     * O(LEN), O(1)
     * @param str
     * @param numRows
     * @return
     */
    public static String zigZagConcatenation(String str, int numRows) {
        int n = str.length();
        String resultString = "";
        for (int i = 0; i < numRows; i++) {
            boolean down = true;

            int j = i;
            while ( j < n ) {
                resultString += str.charAt(j);
                int add ;
                if (i == 0) {
                    add = (numRows - 1 - i) * 2;
                } else if (i == numRows - 1) {
                    add = i * 2;
                } else if (down) {
                    add = (numRows - 1 - i) * 2;
                } else {
                    add = i * 2;
                }
                j += add;
                down = !down;
            }
        }
        return resultString;
    }

    /**
     * O(N), O(N) ; N is the length of string
     * @param str
     * @param numRows
     * @return
     */
    public static String zigZagConcatenationV2(String str, int numRows) {
        int n = str.length();
        String[] arr = new String[numRows]; // stores string corresponding to each row.
        Arrays.fill(arr, "");
        boolean down = true;
        int row = 0;
        for (int i = 0; i < n; i++) {
            arr[row] += str.charAt(i);

            if (row == numRows - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }

            if (down) {
                row++;
            } else {
                row--;
            }
        }

        String resultString = "";
        for (int i = 0; i < arr.length; i++) {
            resultString += arr[i];
        }

        return resultString;
    }


}
