package Arrays.OptimizationProblems;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class SubArraysWithGivenSum {


    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int sum = 33;

        int[] arr1 = {1, 1, 1};
        int sum1 = 2;

        int[] arr2 = {1, 4, 3, 0, 0, 5, 3, 6};
        int sum2 = 8;

        int[] arr3 = {1, 4, 3, 0, 5, 3, 6};
        int sum3 = 8;

        int[] arr4 = {0,0,0,0,0,0,0,0,0,0};
        int sum4 = 0;

        int[] arr5 = {-1,-1,1};
        int sum5 = 0;

//        printSubArraysWithGivenSum(arr, sum);
//        System.out.println(getSubArraysCountWithGivenSum(arr,sum));
//
//        printSubArraysWithGivenSum(arr1, sum1);
//        System.out.println(getSubArraysCountWithGivenSum(arr1,sum1));
//
//        printSubArraysWithGivenSum(arr2, sum2);
//        System.out.println(getSubArraysCountWithGivenSum(arr2, sum2));
//
//        printSubArraysWithGivenSum(arr3, sum3);
//        System.out.println(getSubArraysCountWithGivenSum(arr3, sum3));

//        printSubArraysWithGivenSum(arr4, sum4);
//        System.out.println(getSubArraysCountWithGivenSum(arr4, sum4));

        printSubArraysWithGivenSum(arr5, sum5);
//        System.out.println(getSubArraysCountWithGivenSum(arr5, sum5));


    }

    /**
     * arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     * arr[] = {-1,-1,1}, sum = 0
     * <p>
     * APPROACH 1: SLIDING WINDOW.
     * - This approach is valid for positive numbers only.
     * - O(N), O(1)
     *
     * @param arr
     * @param sum
     * @return
     */
    public static List<Pair> getSubArraysWithGivenSum(int[] arr, int sum) {
        int n = arr.length;
        int left = 0;
        int right = 0;
        int localSum = 0;
        List<Pair> resultList = new ArrayList<>();

        while (right < n) {
            localSum += arr[right];

            if (localSum > sum) {
                while (left < right && localSum > sum) {
                    localSum -= arr[left++];
                }
            }
            if (localSum == sum) {
                resultList.add(new Pair(left, right));
                if (arr[left] == 0) {
                    left++;
                    while (left < right && localSum == sum) {
                        resultList.add(new Pair(left++, right));
                    }
                }
            }

            right++;
        }
        return resultList;
    }

    private static void printSubArraysWithGivenSum(int[] arr, int sum) {
//        List<Pair> resultList = getSubArraysWithGivenSum(arr, sum);
        List<Pair> resultList = getSubArraysWithGivenSumV3(arr, sum);
        for (Pair p : resultList) {
            for (int i = p.i; i <= p.j; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    private static int getSubArraysCountWithGivenSum(int[] arr, int sum) {
//        List<Pair> resultList = getSubArraysWithGivenSum(arr, sum);
//        List<Pair> resultList = getSubArraysWithGivenSumV2(arr, sum);
        List<Pair> resultList = getSubArraysWithGivenSumV3(arr, sum);
        return resultList.size();
    }

    /**
     *
     * @param arr
     * @param sum
     * @return
     */
    public static List<Pair> getSubArraysWithGivenSumV2(int[] arr, int sum)
    {
        int n  = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        int localSum = 0 ;
        List<Pair> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            localSum += arr[i];
            if (localSum == sum) {
                resultList.add(new Pair(0, i));
            }
            int remainingSum =  localSum - sum;
            if (map.containsKey(remainingSum)) {
                for (Integer j: map.get(remainingSum)) {
                    resultList.add(new Pair(j, i));
                }
            }
            List<Integer> l ;
            if (map.containsKey(localSum)) {
                l = map.get(localSum);
            } else{
                l = new ArrayList<>();
            }
            l.add(i);
            map.put(localSum, l);
        }
        return resultList;
    }

    public static List<Pair> getSubArraysWithGivenSumV3(int[] arr, int sum)
    {
        int n  = arr.length;

        int minVal = ArrayUtils.getMinimum(arr);
        int minValAbs = Math.abs(minVal);

        int localSum = 0 ;
        int left = 0;
        int right = 0;
        List<Pair> resultList = new ArrayList<>();

        while (right < n) {
            localSum += (arr[right] + minValAbs);
            int windowLength = right - left ;
            if (localSum - (windowLength*minValAbs) > sum) {
                while (left < right && localSum > sum) {
                    localSum -= (arr[left++] + minValAbs);
                }
            }
            if (localSum - ((right - left + 1)*minValAbs) == sum) {
                resultList.add(new Pair(left, right));
//                if (arr[left] == 0) {
//                    left++;
//                    while (left < right && localSum == sum) {
//                        resultList.add(new Pair(left++, right));
//                    }
//                }
            }

            right++;
        }
        return resultList;
    }
}
