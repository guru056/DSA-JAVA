package DPPractice;


import java.util.*;

public class Practice {

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        System.out.println(countDistinctInEveryWindowK(arr, 4));
    }

    public static List<Integer> countDistinctInEveryWindowK(int[] arr, int k)
    {
        int n = arr.length;
        List<Integer> resultList = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        int i ;
        for (i = 0 ; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        resultList.add(map.size());

        for (i = k; i < n; i++) {
            int newElement = arr[i];
            int outDatedIndex = i - k;
            int outDatedElement = arr[outDatedIndex];

            if (map.get(outDatedElement) > 1) {
                map.put(outDatedElement, map.get(outDatedElement) - 1);
            } else {
                map.remove(outDatedElement);
            }
            map.put(newElement, map.getOrDefault(newElement, 0) + 1);
            resultList.add(map.size());
        }
        return resultList;
    }


}
