package SystemDesign;

import java.util.Random;

public class GenerateRandomString {
    public static void main(String[] args) {
        int num = 50000000;
        System.out.println(base62Encode(num));
    }
    private static final String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NO_OF_CHARS = 7;
    public static String getRandomString()
    {
        String resultStr = "";
        Random random = new Random();
        for (int i = 0 ; i < NO_OF_CHARS; i++) {
            resultStr += str.charAt(random.nextInt(62));
        }
        return resultStr;
    }

    public static String base62Encode(int num)
    {
        String resultStr = "";
        while (num > 0) {
            resultStr += str.charAt(num%62);
            num /= 10;
        }
        return resultStr;
    }
}
