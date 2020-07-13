package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsForMobileNumberSequence {

    private static final Map<Integer,String> DIGIT_WORD_MAP = new HashMap<>() {
        {
            put(2,"abc");
            put(3,"def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }
    };

    public static void main(String[] args) {
        int[] arr = {2,5,9};
        System.out.println(getAllPermutationsForNumberSequence(arr, 0));
    }

    public static List<String> getAllPermutationsForNumberSequence(int[] arr, int i)
    {
        List<String> resultList = new ArrayList<>();
        if (i == arr.length - 1 ){
            resultList.addAll(PermutationsOfString.generatePermutationsForString(DIGIT_WORD_MAP.get(arr[i])));
            return resultList;
        }

        List<String> localPermutations = PermutationsOfString.generatePermutationsForString(DIGIT_WORD_MAP.get(arr[i]));
        List<String> localPermutationsNext = getAllPermutationsForNumberSequence(arr, i +1);

        for(String str: localPermutations) {
            for (String strInner: localPermutationsNext) {
                resultList.add(str + strInner);
            }
        }
        return resultList;
    }
}
