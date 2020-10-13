package Strings;

//https://www.geeksforgeeks.org/print-string-ignoring-alternate-occurrences-character/
public class StringIgnorance {

    public static void main(String[] args) {
        String str = "It is a long day Dear.";
        System.out.println(printStringWithAlternateIgnorance(str));
    }

    /**
     * Alternate Approach:
     * Check if the count becomes odd, then print the current character, else not.
     * @param str
     * @return
     */
    public static String printStringWithAlternateIgnorance(String str) {
        int[] charCount = new int[26];
        String resultString = "";
        int index;
        for (int i = 0 ; i < str.length(); i++) {
            index = Character.toLowerCase(str.charAt(i));
            if (charCount[index] == 0) {
                charCount[index]++;
                resultString += str.charAt(i);
            } else {
                charCount[index] = 0;
            }
        }
        return resultString;
    }
}
