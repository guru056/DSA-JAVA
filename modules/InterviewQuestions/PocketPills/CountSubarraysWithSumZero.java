package InterviewQuestions.PocketPills;

import java.util.ArrayList;
import java.util.HashMap;

public class CountSubarraysWithSumZero {

    public static void main(String[] args) {
        int[] arr = {1,-2,3,0,-2,2};
        System.out.println(countSubArraysWithSumZero(arr));
    }

    public static int countSubArraysWithSumZero(int[] arr){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int count = 0 ;
        int sum = 0 ;

        for (int i = 0 ; i < arr.length; i++){
            sum += arr[i];
            if (sum == 0){
                System.out.println("index 0 to index " + i);
                count += 1;
            }
            ArrayList<Integer> indices = new ArrayList<>();
            if (map.containsKey(sum)){
                indices = map.get(sum);
                for (int it = 0; it < indices.size(); it++){
                    if (indices.get(it) + 1 != i){
                        System.out.println("index " + (indices.get(it) + 1)  + " to index " + i);
                        count++;
                    }
                }
            }
            indices.add(i);
            map.put(sum, indices);
        }
        return count;
    }
}
