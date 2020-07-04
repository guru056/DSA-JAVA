package Queue;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/
public class FirstNonRepeatingCharacterInStream {

    public static void main(String[] args) {
        String str = "aabcabe";
        printFirstNonRepeatingCharacterInStream(str);
        printFirstNonRepeatingCharacterInStreamV2(str);
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

    public static void printFirstNonRepeatingCharacterInStreamV2(String str)
    {
        boolean[] charCount = new boolean[26];
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0 ; i < str.length(); i++){

            if (!queue.isEmpty() && queue.peek() == str.charAt(i)) {
                queue.poll();
            } else if (!charCount[str.charAt(i) - 'a']){
                queue.add(str.charAt(i));
                charCount[str.charAt(i) - 'a'] = true;
            }

            if (queue.isEmpty())
                System.out.print(-1 + " ");
            else
                System.out.print(queue.peek() + " ");
        }
    }
}
