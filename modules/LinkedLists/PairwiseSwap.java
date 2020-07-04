package LinkedLists;

import Utils.LinkedListUtils;

public class PairwiseSwap {
    
    public static void main(String[] args) {
        SinglyLinkedList ll = SinglyLinkedList.getMockLinkedListV2();
        SinglyLinkedList ll2 = SinglyLinkedList.clone(ll);
        LinkedListUtils.printLinkedList(ll);
        LinkedListUtils.printLinkedList(pairwiseSwapRecursiveUtil(ll));

        LinkedListUtils.printLinkedList(ll2);
        LinkedListUtils.printLinkedList(pairwiseSwapIterative(ll2));

    }

    public static Node pairwiseSwapRecursiveUtil(SinglyLinkedList ll)
    {
        return pairwiseSwapRecursive(ll.head);
    }

    /**
     * Input : 1->2->3->4->5->6->NULL
     * Output : 2->1->4->3->6->5->NULL
     *
     */
    public static Node pairwiseSwapRecursive(Node node)
    {
        if (node == null || node.next == null)
            return node;

        Node next = node.next;
        Node nextToNext = node.next.next;
        next.next = node;
        node.next = pairwiseSwapRecursive(nextToNext);

        return next;
    }

    /**
     * Input : 1->2->3->4->5->6->NULL
     * Output : 2->1->4->3->6->5->NULL
     *
     */
    public static Node pairwiseSwapIterative(SinglyLinkedList ll)
    {
        if (ll.head == null || ll.head.next == null)
            return ll.head;

        Node current = ll.head;
        Node prev = null;
        Node next;
        Node nextToNext;
        Node newHead = null;
        while (current != null && current.next != null)
        {
            next = current.next;
            nextToNext = current.next.next;
            if (prev != null)
                prev.next = next;
            if (newHead == null)
                newHead = next;
            prev = current;
            next.next = current;
            current = nextToNext;
        }
        prev.next = current;
        return newHead;
    }
}
