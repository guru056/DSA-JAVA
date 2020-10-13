package Hashing;

//https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
//@TODO https://www.geeksforgeeks.org/length-smallest-sub-string-consisting-maximum-distinct-characters/
public class MinimumWindowSubstringContainingItself {

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println(getMinimumWindowSubstring(str));
    }

    public static String getMinimumWindowSubstring(String string) {
        int m = string.length();

        int[] hashString = new int[256];

        boolean[] presentArr = new boolean[256];
        int distinctCount = 0;
        for (int i = 0 ; i < m; i++) {
            if (!presentArr[string.charAt(i)]) {
                presentArr[string.charAt(i)] = true;
                distinctCount++;
            }
        }

        int count = 0;
        int start = 0;
        int startIndex = -1;
        int minWindowLength = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            hashString[string.charAt(i)]++;
            if (hashString[string.charAt(i)] <= 1) {
                count++;
            }

            if (count == distinctCount) {
                while (hashString[string.charAt(start)] > 1) {
                    hashString[string.charAt(start)]--;
                    start++;
                }
                int windowLen = i - start + 1;
                if (windowLen < minWindowLength) {
                    minWindowLength = windowLen;
                    startIndex = start;
                }
            }
        }
        return startIndex == -1? "": string.substring(startIndex, startIndex + minWindowLength);
    }
}
