package Utils;

public class StringUtils {
    public static String swap(String str, int i, int j)
    {
        char[] charArr = str.toCharArray();
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;

        return new String(charArr);
    }
    public static String swapSubstring(String str, int begin, int end) {
        char[] charArr = str.toCharArray();
        int s = begin;
        int e = end;
        while (s < e) {
            char temp = charArr[s];
            charArr[s] = charArr[e];
            charArr[e] = temp;
            s++;
            e--;
        }
        return new String(charArr).substring(begin, end+1);
    }
}
