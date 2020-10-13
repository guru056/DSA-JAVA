package Strings;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
//https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        String str = "azxxzy";
        String str1 = "abbaca";
        String str2 = "abbbb";
        String str3 = "geeksforgeeg";
        String str4 = "azxxxzy";
        String str5 = "caaabbbaac";
        String str6 = "gghhg";
        String str7 = "aaaacddddcappp";
        String str8 = "aaaaaaaaaa";
        String str9 = "qpaaaaadaaaaadprq";
        String str10 = "acaaabbbacdddd";
        String str11 = "dcbaabbccd";
        String str12 = "azxxzzy";
        String str13 = "aaaaa";

        removeAdjacentDuplicatesUtil(str);
        removeAdjacentDuplicatesUtil(str1);
        removeAdjacentDuplicatesUtil(str2);
        removeAdjacentDuplicatesUtil(str3);
        removeAdjacentDuplicatesUtil(str4);
        removeAdjacentDuplicatesUtil(str5);
        removeAdjacentDuplicatesUtil(str6);
        removeAdjacentDuplicatesUtil(str7);
        removeAdjacentDuplicatesUtil(str8);
        removeAdjacentDuplicatesUtil(str9);
        removeAdjacentDuplicatesUtil(str10);
        removeAdjacentDuplicatesUtil(str11);
        removeAdjacentDuplicatesUtil(str12);
        removeAdjacentDuplicatesUtil(str13);

    }

    public static void removeAdjacentDuplicatesUtil(String str) {
        System.out.println(str);
        System.out.println(removeAdjacentDuplicatesRecursive(str));
        System.out.println(removeAdjacentDuplicatesRecursiveV2(str));
        System.out.println();
    }

    public static String removeAdjacentDuplicatesRecursive(String str)
    {
        if (str.length() == 0 || str.length() == 1)
            return str;
        if (str.charAt(0) == str.charAt(1)) {
            //comment out while for the leetcode problem
            while (str.length() > 1 && str.charAt(0) == str.charAt(1)) {
                str = str.substring(1);
            }
            str = str.substring(1);
            return removeAdjacentDuplicatesRecursive(str);
        }
        String remainingStr = removeAdjacentDuplicatesRecursive(str.substring(1));
        if ( remainingStr.length() != 0 && remainingStr.charAt(0) == str.charAt(0)) {
            return remainingStr.substring(1);
        }
        return str.charAt(0) + remainingStr;
    }

    /**
     * Slight modification to the previous problem: We keep one occurrence in a set of repeating strings
     * @param str
     * @return
     */
    public static String removeAdjacentDuplicatesRecursiveV2(String str)
    {
        if (str.length() == 0 || str.length() == 1)
            return str;
        if (str.charAt(0) == str.charAt(1)) {
            //comment out while for the leetcode problem
            while (str.length() > 1 && str.charAt(0) == str.charAt(1)) {
                str = str.substring(1);
            }
//            str = str.substring(1);
            return removeAdjacentDuplicatesRecursiveV2(str);
        }
        String remainingStr = removeAdjacentDuplicatesRecursiveV2(str.substring(1));
        if ( remainingStr.length() != 0 && remainingStr.charAt(0) == str.charAt(0)) {
            return remainingStr.charAt(0) + remainingStr.substring(1);
        }
        return str.charAt(0) + remainingStr;
    }

}
