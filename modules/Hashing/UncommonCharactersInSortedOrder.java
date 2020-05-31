package Hashing;

//https://www.geeksforgeeks.org/find-uncommon-characters-two-strings/
public class UncommonCharactersInSortedOrder {

    public static void main(String[] args) {
        String str1 = "characters";
        String str2 = "alphabets";

        System.out.println(getUncommonCharacters( str1, str2));
    }

    public static String getUncommonCharacters(String str1, String str2)
    {
        String result = "";
        int[] presentArr = new int[26];
        for (int i = 0 ; i < str1.length(); i++) {
            presentArr[str1.charAt(i) - 'a'] = 1;
        }

        for (int i = 0 ; i < str2.length(); i++) {
            int index = str2.charAt(i) - 'a';
            if (presentArr[index] == 1 ) {
                presentArr[index] = 2;
            } else if (presentArr[index] == 0) {
                presentArr[index] = -1;
            }
        }

        for (int i = 0 ; i < presentArr.length; i++) {
            if (presentArr[i] == 1 || presentArr[i] == -1)
                result += (char)(i + 'a');
        }
        return result;
    }
}
