package Arrays.Misc;

import java.util.*;

//https://leetcode.com/problems/intersection-of-two-arrays
//https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
        System.out.println(Arrays.toString(intersectionV2(arr1, arr2)));
    }

    /**
     * Each element in the result must be unique.
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] intersection(int[] arr1, int[] arr2) { // 2ms
        List<Integer> resultList = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0)
            return new int[0];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                resultList.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }

        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }

    /**
     * Each element in the result must be unique.
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] getIntersectionForTwoSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        List<Integer> list = new LinkedList<>();
        int i = 0, j = 0;
        int commonElement = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                commonElement = arr1[i];
                list.add(commonElement);
                i++;
                j++;
                while (i < m && arr1[i] == commonElement)
                    i++;
                while (j < n && arr2[j] == commonElement)
                    j++;
            }
        }
        int[] resultArr = new int[list.size()];
        for (int k = 0; k < list.size(); k++)
            resultArr[k] = list.get(k);
        return resultArr;
    }

    /**
     * Each element in the result should appear as many times as it shows in both arrays.
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] intersectionV2(int[] arr1, int[] arr2) { // 2ms
        List<Integer> resultList = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0)
            return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                resultList.add(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
                if (map.get(arr2[i]) == 0)
                    map.remove(arr2[i]);
            }
        }

        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }


    /**
     * Each element in the result should appear as many times as it shows in both arrays.
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] getIntersectionForTwoSortedArraysV2(int[] arr1, int[] arr2) { // 3ms
        int m = arr1.length;
        int n = arr2.length;

        List<Integer> list = new LinkedList<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        int[] resultArr = new int[list.size()];
        for (int k = 0; k < list.size(); k++)
            resultArr[k] = list.get(k);
        return resultArr;
    }

}
