package Strings;

//https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
public class FirstNonRepeatingCharacter {

    static class CharInfo
    {
        int firstOccurrenceIndex;
        int frequency;

        public CharInfo(int firstOccurrenceIndex, int frequency) {
            this.firstOccurrenceIndex = firstOccurrenceIndex;
            this.frequency = frequency;
        }
    }
    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        String str1 = "geeg";
        String str2 = "leetcode";
        printFirstNonRepeatingCharacter(str);
        printFirstNonRepeatingCharacter(str1);
        printFirstNonRepeatingCharacter(str2);
    }

    public static void printFirstNonRepeatingCharacter(String str)
    {
        int charAscii = getFirstNonRepeatingCharacter(str);
        if (charAscii == -1){
            System.out.println("No non repeating character present");
        } else{
            System.out.println((char)charAscii);
        }
        charAscii = getFirstNonRepeatingCharacterV2(str);
        if (charAscii == -1){
            System.out.println("No non repeating character present");
        } else{
            System.out.println((char)charAscii);
        }
        System.out.println();
    }
    /**
     *  input - GeeksforGeeks
     *  output - f
     *  return -1 if no non repeating character is present
     * @param str
     * @return
     */
    public static int getFirstNonRepeatingCharacter(String str)
    {
        int[] charCount = new int[256];
        for (int i = 0 ; i < str.length(); i++){
            charCount[(int)str.charAt(i)]++;
        }
        for (int i = 0 ; i < str.length(); i++){
            if(charCount[(int)str.charAt(i)] == 1)
                return str.charAt(i); //automatically type casted as return type is int
        }
        return -1;
    }

    public static int getFirstNonRepeatingCharacterV2(String str)
    {
        CharInfo[] charCount = new CharInfo[256];
        CharInfo current;
        int index;
        for (int i = 0 ; i < str.length(); i++){
            index = str.charAt(i) ;
            current = charCount[index];
            if (current == null){
                charCount[index] = new CharInfo(i, 1);
            } else{
                charCount[index].frequency++;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0 ; i < charCount.length; i++){
            if (charCount[i] != null && charCount[i].frequency == 1)
                minIndex = Math.min( minIndex, charCount[i].firstOccurrenceIndex );
        }
        return minIndex == Integer.MAX_VALUE ? -1 : str.charAt(minIndex);
    }
}
