package Arrays.SearchingProblems;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/majority-element-ii/
public class MajorityElementII {

    public static void main(String[] args) {
        int[] arr = {3,2,3};
        int[] arr1 = {1,1,1,3,3,2,2,2};
        int[] arr2 = {1,1,1,2,3,4,5,6};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement(arr1));
        System.out.println(majorityElement(arr2));
    }

    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * @param arr
     * @return
     */
    public static List<Integer> majorityElement(int[] arr)
    {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> candidateList = findCandidates(arr);

        int c1= 0 ;
        int c2 = 0;
        Integer candidate1 = candidateList.get(0);
        Integer candidate2 = candidateList.get(1);

        for (int i = 0; i < arr.length; i++) {
            if (candidate1 != null && arr[i] == candidate1) {
                c1++;
            } else if (candidate2 != null && arr[i] == candidate2) {
                c2++;
            }
        }
        if (c1 > arr.length/3)
            resultList.add(candidateList.get(0));
        if (c2 > arr.length / 3)
            resultList.add(candidateList.get(1));
        return resultList;
    }

    public static List<Integer> findCandidates(int[] arr)
    {
        Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0;
        int count2 = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < arr.length; i++) {
            if (candidate1 != null && arr[i] == candidate1) {
                count1++;
            } else if (candidate2 != null && arr[i] == candidate2){
                count2++;
            } else if(count1 == 0) {
                candidate1 = arr[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = arr[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        list.add(candidate1);
        list.add(candidate2);
        return list;
    }
}
