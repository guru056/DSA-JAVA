package Arrays.Sorting;

import java.util.*;

//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;

        Arrays.sort(arr);
        int fixedPosition = n - 1;
        int left, right, sum, localSum;
        while (fixedPosition > 1) {
            left = 0;
            right = fixedPosition - 1;
            sum = -arr[fixedPosition];
            while (left < right) {
                localSum = arr[left] + arr[right];
                if (localSum == sum) {
                    set.add(new ArrayList<>(Arrays.asList(arr[left], arr[right], arr[fixedPosition])));
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

        return new ArrayList<>(set);
    }
}
