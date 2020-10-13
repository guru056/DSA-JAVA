package Arrays.Misc;

import java.util.*;

//https://www.geeksforgeeks.org/count-triplets-such-that-one-of-the-numbers-can-be-written-as-sum-of-the-other-two/
public class CountTriplets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 1, 1, 2, 2};
        System.out.println(getDistinctTriplets(arr));
        System.out.println(getDistinctTriplets(arr1));

        System.out.println(countAllTriplets(arr));
        System.out.println(countAllTriplets(arr1));
    }

    public static Set<List<Integer>> getDistinctTriplets(int[] arr) {
        Arrays.sort(arr);

        Set<List<Integer>> resultList = new HashSet<>();

        int fixedPosition = arr.length - 1;
        int left = 0;
        int right = fixedPosition - 1;
        int sum = 0;
        int localSum = 0;
        while (fixedPosition > 1) {
            sum = arr[fixedPosition];
            left = 0;
            right = fixedPosition - 1;
            while (left < right) {
                localSum = arr[left] + arr[right];
                if (localSum == sum) {
                    resultList.add(new ArrayList<>(Arrays.asList(arr[left], arr[right], arr[fixedPosition])));
                    left++;
                    right--;
                } else if (localSum > sum) {
                    right--;
                } else {
                    left++;
                }
            }
            fixedPosition -= 1;
        }
        return resultList;
    }

    /**
     * Given an array A[] of N integers.
     * The task is to find the number of triples (i, j, k) ,
     * where i, j, k are indices and (1 <= i < j < k <= N),
     * such that in the set { A_i, A_j, A_k} at least one of the numbers can be
     * written as the sum of the other two.
     * <p>
     * Input : A[] = {1, 2, 3, 4, 5}
     * Output : 4
     * The valid triplets are:
     * (1, 2, 3), (1, 3, 4), (1, 4, 5), (2, 3, 5)
     * <p>
     * Input : A[] = {1, 1, 1, 2, 2}
     * Output : 6
     * <p>
     * This is a counting problem. Lets say f(x) represents the frequency of number x in our array.
     * <p>
     * There exist four cases:
     * <p>
     * 1. All three numbers are equal to 0. The number of ways = f(0)C3 (where pCq is the number of ways of choosing q numbers from p numbers).
     * 2. One number is equal to 0, the other two are equal to some x > 0: f(0) * f(x)C2.
     * 3. Two numbers are equal to some x>0, the third is 2*x: f(x)C2 * f(2 * x).
     * 4. The three numbers are x, y and x + y, 0 < x, y: f(x) * f(y) * f(x + y).
     *
     * @param arr
     * @return
     */
    public static int countAllTriplets(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        int result = 0;
        int zeroCount = map.getOrDefault(0, 0);

        //case 1: 0,0,0, f(0)C3
        if (zeroCount >= 3) {
            result += (zeroCount * (zeroCount - 1) * (zeroCount - 2)) / 6;
        }

        //case 2: 0,x,x. f(0)C1* f(x)C2
        //case 3: x,x,2*x , f(x)C2* f(2*x)C1
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int elemX = e.getKey();
            int elem2X = elemX * 2;
            int countX = e.getValue();
            int count2X = map.getOrDefault(elem2X, 0);
            //case 2: 0,x,x. f(0)C1* f(x)C2
            if (zeroCount >= 1 && elemX != 0 && countX >= 2) {
                result += (zeroCount) * (((countX) * (countX - 1)) / 2);
            }
            //case 3: x,x,2*x , f(x)C2* f(2*x)C1
            if (elemX != 0 && countX >= 2 && count2X >= 1) {
                result += (count2X) * (((countX) * (countX - 1)) / 2);
            }
        }

        // case 4: x,y,x+y, f(x)C1 * f(y)C1 * f(x+y)C1
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int arrI = list.get(i);
                int arrJ = list.get(j);
                int countX = map.getOrDefault(arrI, 0);
                int countY = map.getOrDefault(arrJ, 0);
                int countXY = map.getOrDefault(arrI + arrJ, 0);
                if (arrI != 0 && arrJ != 0 && countXY != 0) {
                    result += (countX * countY * countXY);
                }
            }
        }
        return result;
    }


}
