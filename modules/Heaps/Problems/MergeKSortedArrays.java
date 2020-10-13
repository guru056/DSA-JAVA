package Heaps.Problems;

import java.util.*;

//https://www.geeksforgeeks.org/merge-k-sorted-arrays/
//https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
public class MergeKSortedArrays {

    static class Pair {
        int k;
        int index;

        public Pair(int k, int index) {
            this.k = k;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};

        int[][] arr1 = {{1, 3},
                {2, 4, 6},
                {0, 9, 10, 11}};

        int[][] arr2 = {{1, 3, 20},
                {2, 4, 6}};
//        System.out.println(Arrays.toString(mergeKSortedArrays(arr, 4)));
//        System.out.println(mergeKSortedArrays(arr1));
//        System.out.println(mergeKSortedArrays(arr2));

        System.out.println(mergeKSortedArraysV2(arr));
        System.out.println(mergeKSortedArraysV2(arr1));
        System.out.println(mergeKSortedArraysV2(arr2));
    }

    /**
     * k = 3, n = 4
     * arr[][] = { {1, 3, 5, 7},
     * {2, 4, 6, 8},
     * {0, 9, 10, 11}
     * } ;
     * <p>
     * Output: 0 1 2 3 4 5 6 7 8 9 10 11
     * same sized arrays
     *
     * @param arrays
     */
    public static int[] mergeKSortedArrays(int[][] arrays, int n) {
        int k = arrays.length;
        if (k == 0)
            return null;
        int[] resultArr = new int[k * n];

        Comparator<Pair> cmp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return arrays[o1.k][o1.index] - arrays[o2.k][o2.index];
            }
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);
        for (int i = 0; i < k; i++) { // O(K)
            pq.add(new Pair(i, 0));
        }

        int index = 0;
        while (!pq.isEmpty()) { // ( (n*k)*logK )
            Pair p = pq.poll();
            resultArr[index++] = arrays[p.k][p.index];
            if (p.index + 1 < n) {
                pq.add(new Pair(p.k, p.index + 1));
            }
        }
        return resultArr;
    }

    /**
     * works for differently sized arrays also
     * Time Complexity - O((N*K)LogK)
     * Space Complexity - O(K) (for heap)
     *
     * @param arrays
     * @return
     */
    public static List<Integer> mergeKSortedArrays(int[][] arrays) {
        int k = arrays.length;
        if (k == 0)
            return null;
        List<Integer> resultList = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return arrays[o1.k][o1.index] - arrays[o2.k][o2.index];
            }
        });
        for (int i = 0; i < k; i++) {
            if (arrays[i].length > 0)
                pq.add(new Pair(i, 0));
        }

        while (!pq.isEmpty()) { // ( (n*k)*logK )
            Pair p = pq.poll();
            resultList.add(arrays[p.k][p.index]);
            if (p.index + 1 < arrays[p.k].length) {
                pq.add(new Pair(p.k, p.index + 1));
            }
        }
        return resultList;
    }

    /**
     * Time Complexity - O((N*K)LogK)
     * Space Complexity - O(N*K)
     *
     * @param arrays
     * @return
     */
    public static List<Integer> mergeKSortedArraysV2(int[][] arrays) {
        return mergeSortedArraysRecursive(arrays, 0, arrays.length - 1);
    }

    private static List<Integer> mergeSortedArraysRecursive(int[][] arrays, int begin, int end) {
        List<Integer> resultList = new ArrayList<>();
        if (begin > end)
            return resultList;
        if (begin == end) {
            for (int i : arrays[begin]) {
                resultList.add(i);
            }
            return resultList;
        }

        int mid = (begin + end) / 2;
        List<Integer> resultList1 = mergeSortedArraysRecursive(arrays, begin, mid);
        List<Integer> resultList2 = mergeSortedArraysRecursive(arrays, mid + 1, end);
        return mergeTwoSortedArrays(resultList1, resultList2);
    }

    private static List<Integer> mergeTwoSortedArrays(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> resultList = new ArrayList<>();
        int m = arr1.size();
        int n = arr2.size();

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (arr1.get(i) < arr2.get(j)) {
                resultList.add(arr1.get(i));
                i++;
            } else {
                resultList.add(arr2.get(j));
                j++;
            }
        }
        while (i < m) {
            resultList.add(arr1.get(i));
            i++;
        }
        while (j < n) {
            resultList.add(arr2.get(j));
            j++;
        }
        return resultList;
    }
}
