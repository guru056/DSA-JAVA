package Strings;

import Utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsOfString {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println( generatePermutationsForString(str) );
    }

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

}
