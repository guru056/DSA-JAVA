package Arrays.OrderStatistics;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(kthLargest(arr,k));
        System.out.println(kthSmallest(arr,k));
    }

    public static int kthLargest(int[] arr, int k)
    {
        int n = arr.length;
        Queue<Integer> pq = new PriorityQueue<>();

        int i;
        for (i = 0 ; i < k; i++) {
            pq.add(arr[i]);
        }

        for ( i = k ; i < n; i++) {
            if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static int kthSmallest(int[] arr, int k) {
        int n = arr.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i;
        for (i = 0 ; i < k; i++) { // O(k)
            pq.add(arr[i]);
        }

        for ( i = k ; i < n; i++) { // (n-k)*logK
            if (arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
}
