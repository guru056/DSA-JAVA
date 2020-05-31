package Hashing;

import Utils.ArrayUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://www.geeksforgeeks.org/find-a-pair-swapping-which-makes-sum-of-two-arrays-same/
public class SwappingArraysMakeSumEqual {

    public static void main(String[] args) {
        int[] arr1 = {5,7,4,6};
        int[] arr2 = {1,2,3,8};

        printList(getAllSwappingPairs(arr1,arr2));
    }
    public static List<Pair> getAllSwappingPairs(int[] arr1, int[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;

        int[] setArr = m < n ? arr1 : arr2;
        int[] nonSetArr = setArr == arr1 ? arr2 : arr1;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < setArr.length; i++) {
            set.add(setArr[i]);
        }

        int sumA = ArrayUtils.getSum(setArr);
        int sumB = ArrayUtils.getSum(nonSetArr);

        int diff = ( sumA - sumB ) / 2;

        List<Pair> resultList = new LinkedList<>();
        for (int i = 0; i < nonSetArr.length; i++) {
            if (set.contains(nonSetArr[i] + diff)) {
                resultList.add(new Pair(nonSetArr[i], nonSetArr[i] + diff));
            }
        }
        return resultList;
    }

    private static void printList(List<Pair> list)
    {
        for (Pair p: list) {
            System.out.println(p.i + " ," + p.j);
        }
        System.out.println();
    }
}
