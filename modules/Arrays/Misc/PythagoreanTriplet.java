package Arrays.Misc;

import java.util.*;

//https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
public class PythagoreanTriplet {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};
        System.out.println(getPythagoreanTriplet(arr));
    }

    public static List<List<Integer>> getPythagoreanTriplet(int[] arr)
    {
        int n = arr.length;
        squareArray(arr);
        Arrays.sort(arr);

        List<List<Integer>> resultList = new ArrayList<>();
        int fixedPosition = n - 1;
        int left;
        int right;

        while (fixedPosition > 1) {
            left = 0;
            right = fixedPosition - 1;
            while (left < right) {
                if (arr[left] + arr[right] == arr[fixedPosition]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[left]);
                    list.add(arr[right]);
                    list.add(arr[fixedPosition]);
                    resultList.add(list);
                    left++;
                    right--;
                } else if (arr[left] + arr[right] < arr[fixedPosition]) {
                    left++;
                } else {
                    right--;
                }
            }
            fixedPosition -= 1;
        }
        return resultList;
    }

    private static void squareArray(int[] arr)
    {
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = (arr[i] * arr[i]);
        }
    }
}
