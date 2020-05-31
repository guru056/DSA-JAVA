package Hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
public class DistinctElementsInSlidingWindow {

    public static void main(String[] args) {
        int arr[] =  {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println(countDistinctElementsInEveryWindow(arr,k));
    }

    public static List<Integer> countDistinctElementsInEveryWindow(int[] arr, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
                count++;
            }
        }

        resultList.add(count);
        for (int i = k; i < arr.length; i++) {
            int outOfWindowElement = arr[i-k];
            int currentWindowElement = arr[i];

            if (map.get(outOfWindowElement) == 1) {
                map.remove(outOfWindowElement);
                count--;
            } else {
                map.put(outOfWindowElement, map.get(outOfWindowElement) - 1);
            }

            if (!map.containsKey(currentWindowElement)) {
                count++;
                map.put(currentWindowElement, 1);
            } else {
                map.put(currentWindowElement, map.get(currentWindowElement) + 1);
            }

            resultList.add(count);
        }
        return resultList;
    }
}
