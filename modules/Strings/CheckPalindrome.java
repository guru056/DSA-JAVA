package Strings;

public class CheckPalindrome {

    public static void main(String[] args) {
        String str = "aakaa";
        String str1 = "aakkaa";
        String str2 = "akaa";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));
    }
    public static boolean isPalindrome(String str)
    {
        int n = str.length();
        for (int i = 0 ; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n-1-i))
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(String str, int i, int j) {
        int n = str.length();
        if (i < 0 || j >= n)
            return false;
        int begin = i;
        int end = j;
        while (begin <= end) {
            if (str.charAt(begin) != str.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }
}
