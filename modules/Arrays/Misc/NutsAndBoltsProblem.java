package Arrays.Misc;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem-set-2-hashmap
//https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem/
public class NutsAndBoltsProblem {

    public static void main(String[] args) {
        char[] nuts = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        nutsAndBolts(nuts, bolts);
    }

    public static void nutsAndBolts(char[] nuts, char[] bolts)
    {
        int n = nuts.length;
        Map<Character, Integer> map = new HashMap<>();

        for (int i  = 0 ; i < nuts.length; i++) {
            map.put(nuts[i], i); //assuming no duplicates
        }

        for (int i = 0 ; i < bolts.length; i++) {
            if (map.containsKey(bolts[i])) {
                nuts[i] = bolts[i];
            }
        }
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}
