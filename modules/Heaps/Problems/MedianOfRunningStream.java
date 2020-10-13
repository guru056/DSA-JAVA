package Heaps.Problems;

import java.util.*;

//https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl/
public class MedianOfRunningStream {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        System.out.println(printMedianOfRunningStream(arr));
    }

    public static List<Double> printMedianOfRunningStream(int[] arr)
    {
        Queue<Integer> largerHalf = new PriorityQueue<>();
        Queue<Integer> smallerHalf = new PriorityQueue<>(Collections.reverseOrder());

        List<Double> resultList = new ArrayList<>();
        resultList.add((double) arr[0]);
        smallerHalf.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (smallerHalf.size() == largerHalf.size()) {
                if (arr[i] < smallerHalf.peek()) {
                    smallerHalf.add(arr[i]);
                    resultList.add((double)smallerHalf.peek());
                } else {
                    largerHalf.add(arr[i]);
                    resultList.add((double)largerHalf.peek());
                }
            } else if (smallerHalf.size() > largerHalf.size()) {
                if (arr[i] < smallerHalf.peek()) {
                    largerHalf.add(smallerHalf.poll());
                    smallerHalf.add(arr[i]);
                } else {
                    largerHalf.add(arr[i]);
                }
                resultList.add( (double)(smallerHalf.peek() + largerHalf.peek())/2 );

            } else {
                if (arr[i] < largerHalf.peek()) {
                    smallerHalf.add(arr[i]);
                } else {
                    smallerHalf.add(largerHalf.poll());
                    largerHalf.add(arr[i]);
                }
                resultList.add( (double)(smallerHalf.peek() + largerHalf.peek())/2 );
            }
        }
        return resultList;
    }
}
