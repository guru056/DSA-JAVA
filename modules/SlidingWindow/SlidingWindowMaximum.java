package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        printSlidingWindowMaximum(arr, k);
    }

    /**
     *  Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
     *  Output: 3 3 4 5 5 5 6
     * @param arr
     * @param k
     */
    public static void printSlidingWindowMaximum(int[] arr, int k)
    {
        Deque<Integer> queue = new LinkedList<>();
        int i ;
        for (i = 0 ; i < k; i++){
            while (!queue.isEmpty() && arr[i] >= queue.peekLast()){
                queue.removeLast();
            }
            queue.add(i);
        }

        while (i < arr.length){
            System.out.print(arr[queue.peek()] + " ");
            while (!queue.isEmpty() && queue.peekFirst() <= i - k){
                queue.removeFirst();
            }
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]){
                queue.removeLast();
            }
            queue.add(i);
            i++;
        }
        if (!queue.isEmpty()){
            System.out.print(arr[queue.peek()] + " ");
        }
        System.out.println();
    }
}
