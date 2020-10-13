package Strings;

//https://www.geeksforgeeks.org/check-string-can-obtained-rotating-another-string-2-places/
public class KPlaceRotationsForTwoStrings {

    public static void main(String[] args) {
        int k = 2;
        String string1 = "amazon", string2 = "azonam";
        String string3 = "amazon", string4 = "onamaz";

        System.out.println(checkRotations(string1,string2,k));
        System.out.println(checkRotations(string3,string4,k));
    }
    public static boolean checkRotations(String str1, String str2, int k)
    {
        if (str1.length() != str2.length())
            return false;
        int n = str1.length();
        k = k % n;

        String antiClockwiseRotation = str1.substring(k) + str1.substring(0,k);
        String clockwiseRotation = str1.substring(n-k) + str1.substring(0, n-k) ;
//        k = n - k;
//        String clockwiseRotation = str1.substring(k) + str1.substring(0,k);

        return str2.equals(antiClockwiseRotation) || str2.equals(clockwiseRotation);
    }
}
