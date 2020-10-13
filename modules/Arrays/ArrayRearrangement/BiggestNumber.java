package Arrays.ArrayRearrangement;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/largest-number/
//https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
public class BiggestNumber {

    public static void main(String[] args) {
        int[] arr = {54, 546, 548, 60};
        System.out.println(Arrays.toString(rearrangeArrayToGetLargestNumber(arr)));
    }

    public static String getLargestNumberFormedFromArray(int[] arr)
    {
        int n = arr.length;
        String[] strArr = new String[n];
        for (int i = 0 ; i < n; i++){
            strArr[i] = Integer.toString(arr[i]);
        }
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(strArr, cmp);
        String result = "";
        for (int i = 0 ; i < n; i++){
            result += strArr[i];
        }
        return result.charAt(0) == '0' && result.charAt(result.length() - 1) == '0' ? "0" : result;
    }

    public static int[] rearrangeArrayToGetLargestNumber(int[] arr) {
        int n = arr.length;
        Integer[] input = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = Integer.toString(o1);
                String s2 = Integer.toString(o2);
                String first = s1+s2;
                String second = s2+s1;
                return second.compareTo(first);
            }
        };
        Arrays.sort(input, cmp);
        return Arrays.stream(input).mapToInt(Integer::intValue).toArray();
    }
}
