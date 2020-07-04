package Arrays.Misc;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindDuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 3, 6, 6};
        int[] arr1 = {1, 2, 3, 4 ,3};
        int[] arr2 = {1, 2, 3, 4 ,0};

        System.out.println(getDuplicates(arr));
        System.out.println(getDuplicates(arr1));
        System.out.println(getDuplicates(arr2));
    }
    public static List<Integer> getDuplicates(int[] arr)
    {
        int n = arr.length;
        List<Integer> duplicates = new ArrayList<>();

        int index;
        for (int i = 0; i < n; i++) {
            index = Math.abs(arr[i]);
            if (arr[index] < 0) {
                duplicates.add(index);
            } else {
                arr[index] = -arr[index];
            }
        }
        return duplicates;
    }
}
