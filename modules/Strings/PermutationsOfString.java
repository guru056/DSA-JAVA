package Strings;

import Utils.StringUtils;

import java.util.*;

//https://www.geeksforgeeks.org/java-program-to-print-distinct-permutations-of-a-string
public class PermutationsOfString {

    public static void main(String[] args) {
        String str = "abc";
        String str1 = "aba";
        System.out.println( generatePermutationsForString(str) );
        System.out.println( generatePermutationsForString(str1) );
    }

    /**
     * Time complexity - O(n*n!)
     * There are n! permutations and it requires O(n) time to print a a permutation.
     * @param str
     * @return
     */
    public static List<String> generatePermutationsForString(String str)
    {
        List<String> resultList = new ArrayList<>();
        if (str.length() == 1)
        {
            resultList.add(str);
            return resultList;
        }

        for (int i = 0; i < str.length(); i++) {
            String newString = StringUtils.swap(str, 0, i);
            List<String> substrPermutations = generatePermutationsForString(newString.substring(1));
            for(String s : substrPermutations) {
                resultList.add(newString.charAt(0) + s);
            }
        }
        return resultList;
    }

    public static Set<String> generateDistinctPermutationsForString(String str)
    {
        Set<String> resultSet = new HashSet<>();
        if (str.length() == 1)
        {
            resultSet.add(str);
            return resultSet;
        }

        for (int i = 0; i < str.length(); i++) {
            String newString = StringUtils.swap(str, 0, i);
            Set<String> substrPermutations = generateDistinctPermutationsForString(newString.substring(1));
            for(String s : substrPermutations) {
                resultSet.add(newString.charAt(0) + s);
            }
        }
        return resultSet;
    }

}
