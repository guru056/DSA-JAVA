package Hashing;

import Utils.ArrayUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://www.geeksforgeeks.org/find-a-pair-swapping-which-makes-sum-of-two-arrays-same/
public class SwappingArraysMakeSumEqual {

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,8};
        int[] arr2 = {5,7,4,6};

        int[] arr3 = {1,4,5};
        int[] arr4 = {4,6,3};

        printList(getAllSwappingPairs(arr2,arr1));
//        printList(getAllSwappingPairs(arr3,arr4));
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

        int diff = ( sumA - sumB ) ;

        List<Pair> resultList = new LinkedList<>();
        if (diff % 2 != 0) { // Explanation below
            return resultList;
        }
        diff /= 2;

        for (int i = 0; i < nonSetArr.length; i++) {
            if (set.contains(nonSetArr[i] + diff)) {
                resultList.add(new Pair(nonSetArr[i], nonSetArr[i] + diff));
            }
            if (set.contains(nonSetArr[i] - diff)) {
                resultList.add(new Pair(nonSetArr[i], nonSetArr[i] - diff));
            }
        }
        return resultList;
    }

    // we have only integers in our arrays.
    // Lets say the diff is 9, in that case,
    // we want that swapping would increase the value in an array by 4 and decrease the value in the array by 5,
    // which won't be possible for an integer array, the amount by which one array increases is same as the amount by which the other array reduces.
    private static void printList(List<Pair> list)
    {
        if (list.isEmpty()) {
            System.out.println("No valid pairs!");
            return;
        }
        for (Pair p: list) {
            System.out.println(p.i + " ," + p.j);
        }
        System.out.println();
    }
}
