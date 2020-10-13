package Strings;

//https://practice.geeksforgeeks.org/problems/last-index-of-1/0
//https://www.geeksforgeeks.org/find-last-index-character-string/
public class LastIndexOfOne {

    public static int lastIndexOfOne(String str) {
        int n = str.length();
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '1')
                return i;
        }
        return -1;
    }

    public static int lastIndexOfCharacter(String str, char ch) {
        int n = str.length();
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == ch)
                return i;
        }
        return -1;
    }
}
