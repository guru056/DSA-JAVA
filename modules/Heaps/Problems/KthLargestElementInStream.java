package Heaps.Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
//https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/
public class KthLargestElementInStream {

    /**
     * the array may have lesser elements than k, hence the condition i < nums.length;
     * Example - ["KthLargest","add","add","add","add","add"]
     *          [[2,[0]],[-1],[1],[-2],[-4],[3]]
     *
     * the array may have more elements than k, hence the second loop
     * Example - ["KthLargest","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add"]
     *           [[7,[-10,1,3,1,4,10,3,9,4,5,1]],[3],[2],[3],[1],[2],[4],[5],[5],[6],[7],[7],[8],[2],[3],[1],[1],[1],[10],[11],[5],[6],[2],[4],[7],[8],[5],[6]]
     */
    static class KthLargest {
        PriorityQueue<Integer> pq;
        int k;
        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            this.k = k;
            for (int i = 0; i < k && i < nums.length; i++) {
                pq.add(nums[i]);
            }
            for(int i = k; i < nums.length; i++) {
                this.add(nums[i]);
            }
        }

        public int add(int val) {
            if (pq.isEmpty() || pq.size() < k) {
                pq.add(val);
            } else if (val > pq.peek()) {
                pq.remove();
                pq.add(val);
            }
            return pq.peek();
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 11, 70, 50, 40, 100, 5};
        int[] arr1 = {0, -1, 1, -2, -4, 3};
        System.out.println(kthLargestInStream(arr,3));
        System.out.println(kthLargestInStream(arr1,2));

        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(4));
    }


    public static List<Integer> kthLargestInStream(int[] arr, int k) {
        List<Integer> kthLargest = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k-1; i++) {
            kthLargest.add(null);
            pq.add(arr[i]);
        }
        pq.add(arr[k-1]);
        kthLargest.add(pq.peek());
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
            kthLargest.add(pq.peek());
        }
        return kthLargest;
    }
}
