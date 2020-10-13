package Strings;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderV2(logs)));
        String[] logs1 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        System.out.println(Arrays.toString( reorderV2(logs1)));
    }

    public static String[] reorder(String[] arr)
    {
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int idx1 = o1.indexOf(' ');
                int idx2 = o2.indexOf(' ');
                char ch1 = o1.charAt(idx1 + 1);
                char ch2 = o2.charAt(idx2 + 1);

                if (Character.isDigit(ch1) && Character.isDigit(ch2)) {
                    return 0;
                }
                else if (Character.isDigit(ch2)) {
                    return -1;
                } else if (Character.isDigit(ch1)) {
                    return 1;
                } else {
                    int preCompute =  o1.substring(idx1 + 1).compareTo(o2.substring(idx2+1));
                    if (preCompute == 0 ) {
                        return o1.substring(0,idx1).compareTo(o2.substring(0,idx2));
                    }
                    return preCompute;
                }
            }
        };
        Arrays.sort(arr, cmp);
        return arr;
    }

    public static String[] reorderV2(String[] arr)
    {
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(" ", 2);
                String[] split2 = o2.split(" ", 2);

                char ch1 = split1[1].charAt(0);
                char ch2 = split2[1].charAt(0);

                if (Character.isDigit(ch1) && Character.isDigit(ch2)) {
                    return 0;
                }
                else if (Character.isDigit(ch2)) {
                    return -1;
                } else if (Character.isDigit(ch1)) {
                    return 1;
                } else {
                    int comp = split1[1].compareTo(split2[1]);
                    if (comp == 0)
                        return split1[0].compareTo(split2[1]);
                    return comp;
                }
            }
        };
        Arrays.sort(arr, cmp);
        return arr;
    }
}
