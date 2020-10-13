package LinkedLists;

import Utils.LinkedListUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists
//https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
//https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
public class MergeKSortedLists {

    public static void main(String[] args) {
        int k = 3;
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

//        Node head = mergeKSortedLists(arr);
        Node head = mergeKSortedListsV2(arr);
        LinkedListUtils.printLinkedList(head);
    }

    /**
     * Time Complexity - O(NKLogK)
     * Space Complexity - O(K)
     * @param headNodes
     * @param k
     * @return
     */
    public static Node mergeKSortedLists(Node[] headNodes, int k) {
        if (k == 0)
            return null;
        Node head = new Node(0);
        Node refToHead = head;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });

        for (int i = 0; i < k; i++) {
            if (headNodes[i] != null)
                pq.add(headNodes[i]);
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            refToHead.next = node;
            refToHead = refToHead.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return head.next;
    }

    /**
     * Divide and conquer
     * Time Complexity - O(NKLogK)
     * Space Complexity - O(1)
     * @param nodes
     * @return
     */
    public static Node mergeKSortedLists(Node[] nodes) { //2ms
        return mergeKSortedListsRecursive(nodes, 0, nodes.length-1);
    }

    private static Node mergeKSortedListsRecursive(Node[] nodes, int begin, int end) {
        if (begin > end)
            return null;
        if (begin == end)
            return nodes[begin];
        if (end - begin == 1){ // this condition can be removed but this is avoiding one recursion call
            return sortedMerge(nodes[begin], nodes[end]);
        }
        int mid = (begin + end) / 2;
        Node nodeA = mergeKSortedListsRecursive(nodes, begin, mid);
        Node nodeB = mergeKSortedListsRecursive(nodes, mid + 1, end);
        return sortedMerge(nodeA, nodeB);
    }

    private static Node sortedMerge(Node nodeA, Node nodeB) {
        if (nodeA == null)
            return nodeB;
        if (nodeB == null)
            return nodeA;

        if (nodeA.data < nodeB.data) {
            nodeA.next = sortedMerge(nodeA.next, nodeB);
            return nodeA;
        } else {
            nodeB.next = sortedMerge(nodeA, nodeB.next);
            return nodeB;
        }
    }

    public static Node mergeKSortedListsV2(Node[] nodes) { //3ms
        int k = nodes.length;
        if (k == 0)
            return null;
        int last = k - 1;
        while (last != 0) {
            int i = 0;
            int j = last;

            while (i < j) {
                nodes[i] = sortedMerge(nodes[i], nodes[j]);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }
            }
        }
        return nodes[0];
    }

}
