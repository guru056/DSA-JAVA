package Strings;

//https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/
public class RemoveConsecutiveDuplicates {

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "aabcca";
        String str3 = "aaaaabbbbbb";
        String str4 = "geeekkeegg";

        System.out.println(removeConsecutiveDuplicatesRecursive(str1));
        System.out.println(removeConsecutiveDuplicatesRecursive(str2));
        System.out.println(removeConsecutiveDuplicatesRecursive(str3));
        System.out.println(removeConsecutiveDuplicatesRecursive(str4));

        System.out.println(removeConsecutiveDuplicates(str1));
        System.out.println(removeConsecutiveDuplicates(str2));
        System.out.println(removeConsecutiveDuplicates(str3));
        System.out.println(removeConsecutiveDuplicates(str4));
    }
    public static String removeConsecutiveDuplicatesRecursive(String str)
    {
        if (str.length() == 0 || str.length() == 1)
            return str;
        if (str.charAt(0) == str.charAt(1)) {
            while (str.length() > 1 && str.charAt(0) == str.charAt(1)) {
                str = str.substring(1);
            }
            return removeConsecutiveDuplicatesRecursive(str);
        }
        String remainingStr = removeConsecutiveDuplicatesRecursive(str.substring(1));
        return str.charAt(0) + remainingStr;
    }

    public static String removeConsecutiveDuplicates(String str)
    {
        int n = str.length();
        String resultString = "";
        for (int i = 0; i < n ; i++) {
            while (i < n - 1 && str.charAt(i) == str.charAt(i+1)) {
                i++;
            }
            resultString += str.charAt(i); // save the last occurrence
        }
        return resultString;
    }

}
