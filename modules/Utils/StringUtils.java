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
}
