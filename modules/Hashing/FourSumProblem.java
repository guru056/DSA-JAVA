package Hashing;

import java.util.*;

//https://www.geeksforgeeks.org/find-four-elements-sum-given-value-set-3-hashmap/
//https://leetcode.com/problems/4sum/

public class FourSumProblem {

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (i == pair.i || j == pair.j) ||
                    (i == pair.j || j == pair.i);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 9, 7, 8};
        int sum = 23;

        int[] arr1 = {10, 2, 3};
        int sum1 = 17;

        int[] arr2 = {2, -4, -5, -2, -3, -5, 0, 4, -2};
        int sum2 = -14;

        int[] arr3 = {-4, -5, -2, -3};
        int sum3 = -14;

        fourSum(arr,sum);
        fourSum(arr1,sum1);
        fourSum(arr2,sum2);
        fourSum(arr3,sum3);
    }

    public static void fourSum(int[] arr, int sum) {
        System.out.println(hasQuadrupletsWithGivenSum(arr, sum));
        System.out.println(getUniqueQuadruplets(arr, sum));
        System.out.println();
    }

    /**
     * Input - {10, 2, 3, 4, 5, 9, 7, 8} , X = 23
     * Output - true (3 + 5 + 7 + 8 = 23).
     *
     * @param arr
     * @return
     */
    public static boolean hasQuadrupletsWithGivenSum(int[] arr, int sum) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        int n = arr.length;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                currSum = arr[i] + arr[j];
                if (map.containsKey(sum - currSum)) {
                    Pair p = new Pair(i, j);
                    List<Pair> listOfPairs = map.get(sum - currSum);
                    for (int itr = 0; itr < listOfPairs.size(); itr++) {
                        Pair p1 = listOfPairs.get(itr);
                        if (!p.equals(p1))
                            return true;
                    }
                }
                map.putIfAbsent(currSum, new ArrayList<>());
                map.get(currSum).add(new Pair(i, j));
            }
        }
        return false;
    }

    private static List<Integer> getIntegerListFromPairs(int[] arr, Pair p1, Pair p2) {
        return Arrays.asList(arr[p1.i],arr[p1.j],arr[p2.i],arr[p2.j]);
    }

    private static boolean isDuplicateQuadruplet(List<List<Integer>> resultList, List<Integer> searchList) {
        for (List<Integer> list : resultList) {
            if (list.size() == searchList.size() && list.containsAll(searchList) && searchList.containsAll(list))
                return true;
        }
        return false;
    }

    public static List<List<Integer>> getUniqueQuadruplets(int[] arr, int sum) {
        int currSum = 0;
        Map<Integer, List<Pair>> map = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0 ; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                currSum = arr[i] + arr[j];
                if (map.containsKey(sum - currSum)) {
                    Pair p = new Pair(i,j);
                    List<Pair> listOfPairs = map.get(sum - currSum);
                    for (Pair p1: listOfPairs) {
                        if (!p.equals(p1)) { // valid pair
                            List<Integer> l = getIntegerListFromPairs(arr, p, p1);
                            if (!isDuplicateQuadruplet(resultList, l)) {
                                resultList.add(l);
                            }
                        }
                    }
                }
                map.putIfAbsent(currSum, new ArrayList<>());
                map.get(currSum).add(new Pair(i,j));
            }
        }
        return resultList;
    }
}
