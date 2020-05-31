package Hashing;


import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/check-if-frequency-of-all-characters-can-become-same-by-one-removal/
//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class CheckForEqualFrequencies {

    public static void main(String[] args) {
        String str  = "xyyz";
        String str1 = "xyyzz";
        String str2 = "xxxxyyzz";
        String str3 = "aabbcd";
        String str4 = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";

//        System.out.println(areEqualFrequenciesPossible(str));
//        System.out.println(areEqualFrequenciesPossible(str1));
//        System.out.println(areEqualFrequenciesPossible(str2));
        System.out.println(areEqualFrequenciesPossible(str3));
//        System.out.println(areEqualFrequenciesPossible(str4));

        System.out.println("==============");
//        System.out.println(areEqualFrequenciesPossibleV2(str));
//        System.out.println(areEqualFrequenciesPossibleV2(str1));
//        System.out.println(areEqualFrequenciesPossibleV2(str2));
        System.out.println(areEqualFrequenciesPossibleV2(str3));
//        System.out.println(areEqualFrequenciesPossibleV2(str4));
    }
    public static boolean areEqualFrequenciesPossible(String str)
    {
        int n = str.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0 ; i < n; i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        int firstCount = map.get(str.charAt(0));
        int secondCount = 0;
        int f = 0;
        int s = 0;

        for(Map.Entry<Character,Integer> m: map.entrySet())
        {
            int val = m.getValue();
            if (firstCount == 0){
                firstCount = val;
                f++;
                continue;
            }
            if (val == firstCount){
                f++;
                continue;
            }
            if (secondCount == 0 ){
                secondCount = val;
            }

            if (val != firstCount && val != secondCount){
                return false;
            }
            s++;
        }
        if (f == 1 && s >= 0 ){
            if (firstCount == 1 || s == 0)
                return true;
            return firstCount - secondCount == 1;
        }
        if (f > 1 && s <= 1){
            if (secondCount == 1 ||s == 0)
                return true;
            return secondCount - firstCount == 1;
        }
        return false;
    }

    public static boolean areEqualFrequenciesPossibleV2(String str)
    {
        int M = 26;
        int N = str.length();
        int[] freq = new int[M];

        for (int i = 0; i < N; i++){
            freq[getIndex(str.charAt(i))]++;
        }

        if (haveEqualFrequency(freq))
            return true;

        for (int i = 0 ; i < freq.length; i++) {
            if (freq[i] == 0)
                continue;
            freq[i]--;
            if (haveEqualFrequency(freq))
                return true;
            freq[i]++;
        }

        return false;

    }

    private static int getIndex(char c)
    {
        return c - 'a';
    }

    private static boolean haveEqualFrequency(int[] freq)
    {
        int same = 0;
        int i ;
        for (i = 0 ; i < freq.length; i++) {
            if (freq[i] != 0) {
                same = freq[i];
                break;
            }
        }

        for (int j = i + 1; j < freq.length; j++) {
            if (freq[j] != 0 && freq[j] != same)
                return false;
        }

        return true;
    }
}
