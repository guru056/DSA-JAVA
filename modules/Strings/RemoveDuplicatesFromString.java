package Strings;

//https://www.geeksforgeeks.org/remove-duplicates-from-a-string-in-o1-extra-space/
//https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
public class RemoveDuplicatesFromString {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String str1 = "characters";
        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicates(str1));
    }

    public static String removeDuplicates(String str)
    {
        int[] charCount = new int[256];
        String resultString = "";

        for (int i = 0 ; i < str.length(); i++) {
            if (charCount[str.charAt(i) - 'a'] == 0) {
                charCount[str.charAt(i) - 'a'] = -1;
                resultString += str.charAt(i);
            }
        }
        return resultString;
    }
}
