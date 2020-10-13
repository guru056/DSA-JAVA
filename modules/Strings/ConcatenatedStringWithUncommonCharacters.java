package Strings;

//https://www.geeksforgeeks.org/concatenated-string-uncommon-characters-two-strings/
public class ConcatenatedStringWithUncommonCharacters {

    public static void main(String[] args) {
        String str1 = "aacdb";
        String str2 = "gafd";

        System.out.println(getConcatenatedString(str1, str2));

        String str3 = "abcs";
        String str4 = "cxzca";

        System.out.println(getConcatenatedString(str3, str4));
    }
    public static String getConcatenatedString(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[] map = new int[256];
        for (int i = 0; i < n; i++) {
            map[str2.charAt(i)] = 1;
        }

        String resultString = "";
        for (int i = 0; i < m; i++) {
            if (map[str1.charAt(i)] == 0) {
                resultString += str1.charAt(i);
            } else if (map[str1.charAt(i)] == 1) {
                map[str1.charAt(i)] = 2;
            }
        }

        for (int i = 0; i < n; i++) {
            if (map[str2.charAt(i)] == 1) {
                resultString += str2.charAt(i);
            }
        }
        return resultString;
    }
}
