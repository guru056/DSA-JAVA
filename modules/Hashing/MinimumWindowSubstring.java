package Hashing;

//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {


    public static void main(String[] args) {
        String str = "his is a test string";
        String pattern = "tist";

        System.out.println(getMinimumWindowSubstringLength(str,pattern));

    }
    public static String getMinimumWindowSubstringLength(String str, String searchStr)
    {
        int m = str.length();
        int n = searchStr.length();

        if (m < n )
            return "";

        int[] hashStr = new int[256];
        int[] hashSearchStr = new int[256];

        for (int i = 0 ; i < n; i++) {
            hashSearchStr[searchStr.charAt(i)]++;
        }
        int count = 0;
        int start = 0;
        int startIndex = -1;
        int endIndex = 0;
        int minWindowLength = Integer.MAX_VALUE;
        for (int i = 0 ; i < m; i++) {
            hashStr[str.charAt(i)]++;

            if (
                    hashSearchStr[str.charAt(i)] != 0 &&
                    hashStr[str.charAt(i)] <= hashSearchStr[str.charAt(i)])
            {
                count++;
            }
            if (count == n ){
                while (
                        hashSearchStr[str.charAt(start)] == 0 ||
                        hashStr[str.charAt(start)] > hashSearchStr[str.charAt(start)]
                    ){
                    if (hashStr[str.charAt(start)] > hashSearchStr[str.charAt(start)]){
                        hashStr[str.charAt(start)]--;
                    }
                    start++;
                }
                int currWindowLength = i - start + 1;
                if (currWindowLength < minWindowLength ) {
                    startIndex = start;
                    endIndex = i;
                    minWindowLength = currWindowLength;
                }
            }
        }
        return startIndex != -1 ? str.substring(startIndex,endIndex+1) :"";
    }
}
