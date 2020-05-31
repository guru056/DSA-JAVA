package Hashing;

import java.util.*;

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
//https://www.geeksforgeeks.org/find-four-elements-sum-given-value-set-3-hashmap/
//https://leetcode.com/problems/4sum/
public class FourSumProblem {

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 9, 7, 8};
        int sum = 23;

        int[] arr1 = {10, 2, 3};
        int sum1 = 17;

        int[] arr2 = {2,-4,-5,-2,-3,-5,0,4,-2};
        int sum2 = -14;

        int[] arr3 = {-4,-5,-2,-3};
        int sum3 = -14;

        System.out.println(hasQuadrupletsWithGivenSum(arr,sum));
        System.out.println(getUniqueQuadrupletsWithGivenSum(arr,sum));
        System.out.println(getUniqueQuadrupletsWithGivenSumV2(arr,sum));

        System.out.println(hasQuadrupletsWithGivenSum(arr1,sum1));
        System.out.println(getUniqueQuadrupletsWithGivenSum(arr1,sum1));
        System.out.println(getUniqueQuadrupletsWithGivenSumV2(arr1,sum1));

        System.out.println(hasQuadrupletsWithGivenSum(arr2,sum2));
        System.out.println(getUniqueQuadrupletsWithGivenSum(arr2,sum2));
        System.out.println(getUniqueQuadrupletsWithGivenSumV2(arr2,sum2));

        System.out.println(hasQuadrupletsWithGivenSum(arr3,sum3));
        System.out.println(getUniqueQuadrupletsWithGivenSum(arr3,sum3));
        System.out.println(getUniqueQuadrupletsWithGivenSumV2(arr3,sum3));

    }
    /**
     * Input - {10, 2, 3, 4, 5, 9, 7, 8} , X = 23
     * Output - true (3 + 5 + 7 + 8 = 23).
     *
     * @param arr
     * @return
     */
    public static boolean hasQuadrupletsWithGivenSum(int[] arr, int sum)
    {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        int n = arr.length;
        int currSum = 0;

        // not required
//        for (int i = 0 ; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int localSum = arr[i] + arr[j];
//                List<Pair> list;
//                if (!map.containsKey(localSum)) {
//                    list = new ArrayList<>();
//                } else {
//                    list = map.get(localSum);
//                }
//                list.add(new Pair(i,j));
//                map.put(localSum, list);
//            }
//        }


        for (int i = 0 ; i < n; i++)
        {
            for (int j = i + 1 ; j < n; j++)
            {
                currSum  = arr[i] + arr[j];
                if (map.containsKey(sum - currSum)) {
                    Pair p = new Pair(i,j);
                    List<Pair> listOfPairs = map.get(sum - currSum);
                    for (int itr = 0; itr < listOfPairs.size(); itr++) {
                        Pair p1 = listOfPairs.get(itr);
                        if (isValidPairCombo(p1,p))
                            return true;
                    }
                }
                List<Pair> list;
                if (!map.containsKey(currSum)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(currSum);
                }
                list.add(new Pair(i,j));
                map.put(currSum, list);
            }
        }
        return false;
    }

    private static boolean isValidPairCombo( Pair p1, Pair p2)
    {
        return  p1.i != p2.i && p1.i != p2.j && p1.j != p2.i && p1.j != p2.j  ;
    }

    public static List<List<Integer>> getUniqueQuadrupletsWithGivenSum(int[] arr, int sum)
    {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        int n = arr.length;
        int currSum = 0;

        for (int i = 0 ; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int localSum = arr[i] + arr[j];
                List<Pair> list;
                if (!map.containsKey(localSum)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(localSum);
                }
                list.add(new Pair(i,j));
                map.put(localSum, list);
            }
        }
        for (int i = 0 ; i < n; i++)
        {
            for (int j = i + 1 ; j < n; j++)
            {
                currSum  = arr[i] + arr[j];
                if (map.containsKey(sum - currSum)) {
                    Pair p = new Pair(i,j);
                    List<Pair> listOfPairs = map.get(sum - currSum);
                    for (int itr = 0; itr < listOfPairs.size(); itr++) {
                        Pair p1 = listOfPairs.get(itr);
                        if (isValidPairCombo(p1,p)) {
                            List<Integer> l = getIntegerListFromPairs(arr,p,p1);
                            if (!isDuplicateQuadruplet(resultList, l)) {
                                resultList.add(l);
                            }
                        }
                    }
                }
            }
        }
        return resultList;
    }

    private static List<Integer> getIntegerListFromPairs(int[] arr,Pair p1, Pair p2)
    {
        List<Integer> list = new ArrayList<>();
        list.add(arr[p1.i]);
        list.add(arr[p1.j]);
        list.add(arr[p2.i]);
        list.add(arr[p2.j]);
        return list;
    }

    private static boolean isDuplicateQuadruplet(List<List<Integer>> resultList, List<Integer> searchList)
    {
        for (List<Integer> list: resultList){
            if (list.size() == searchList.size() && list.containsAll(searchList) && searchList.containsAll(list))
                return true;
        }
        return false;
    }

    private static void printMap(Map<Integer, List<Pair>> map)
    {
        for (Map.Entry<Integer, List<Pair>> e: map.entrySet()) {
            List<Pair> l = e.getValue();
            System.out.print(e.getKey() + " : " );
            for (Pair p : l) {
                System.out.print("[" + p.i + " , " + p.j + " ] ,");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getUniqueQuadrupletsWithGivenSumV2(int[] arr, int sum)
    {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        int n = arr.length;
        int currSum = 0;

        for (int i = 0 ; i < n; i++)
        {
            for (int j = i + 1 ; j < n; j++)
            {
                currSum  = arr[i] + arr[j];
                if (map.containsKey(sum - currSum)) {
                    Pair p = new Pair(i,j);
                    List<Pair> listOfPairs = map.get(sum - currSum);
                    for (int itr = 0; itr < listOfPairs.size(); itr++) {
                        Pair p1 = listOfPairs.get(itr);
                        if (isValidPairCombo(p1,p)) {
                            List<Integer> l = getIntegerListFromPairs(arr,p,p1);
                            if (!isDuplicateQuadruplet(resultList, l)) {
                                resultList.add(l);
                            }
                        }
                    }
                }
                List<Pair> list;
                if (!map.containsKey(currSum)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(currSum);
                }
                list.add(new Pair(i,j));
                map.put(currSum, list);
            }
        }
        return resultList;
    }
}
