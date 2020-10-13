package Queue;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/
public class FirstNonRepeatingCharacterInStream {

    public static void main(String[] args) {
        String str = "aabcabe";
        String str1 = "geekg";
        String str2 = "ggeek";
        printFirstNonRepeatingCharacterInStream(str);
        printFirstNonRepeatingCharacterInStream(str1);
        printFirstNonRepeatingCharacterInStream(str2);
    }
    /**
     * Input  : a a b c a b e
     * Output : a -1 b b b c c
     * @param str
     */
    public static void printFirstNonRepeatingCharacterInStream(String str)
    {
        int[] charCount = new int[26];
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0 ; i < str.length(); i++){
            charCount[str.charAt(i) - 'a']++;
            queue.add(str.charAt(i));

            while (!queue.isEmpty() && charCount[queue.peek() - 'a'] > 1){
                queue.poll();
            }
            if (queue.isEmpty())
                System.out.print(-1 + " ");
            else
                System.out.print(queue.peek() + " ");
        }
        System.out.println();
    }
}
