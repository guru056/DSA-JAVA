package LinkedLists;

import Utils.LinkedListUtils;

//https://www.geeksforgeeks.org/reverse-a-linked-list-in-groups-of-given-size-iterative-approach/
//https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
public class ReverseInGroups {

    /**
     * Input: 1->2->3->4->5->6->7->8->NULL, K = 3
     * Output: 3->2->1->6->5->4->8->7->NULL
     */
    public static void main(String[] args) {
        SinglyLinkedList ll = SinglyLinkedList.getMockLinkedListV2();
        LinkedListUtils.printLinkedList(ll);
        int k = 3;
        reverseInGroupsRecursiveUtil(ll, k);
        LinkedListUtils.printLinkedList(ll);
        reverseInGroupsIterativeUtil(ll, k);
        LinkedListUtils.printLinkedList(ll);
    }

    public static void reverseInGroupsRecursiveUtil(SinglyLinkedList ll, int k )
    {
        ll.head = reverseInGroupsRecursive(ll.head, k);
    }

    public static Node reverseInGroupsRecursive(Node node, int k)
    {
        if (node == null)
            return null;

        int count = 0;
        Node current = node;
        Node prev = null;
        Node next;
        while (current != null && count < k ){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        node.next = reverseInGroupsRecursive(current, k);

        return prev;
    }

    /**
     * Input: 1->2->3->4->5->6->7->8->NULL, K = 3
     * Output: 3->2->1->6->5->4->8->7->NULL
     */

    public static void reverseInGroupsIterativeUtil(SinglyLinkedList ll, int k)
    {
        ll.head = reverseInGroupsIterative(ll,k);
    }

    public static Node reverseInGroupsIterative(SinglyLinkedList ll, int k)
    {
        Node current = ll.head;
        Node prev = null;
        Node next;
        Node newHead = null;
        Node head = null;
        Node tail = null;

        while (current != null){
            int count = 0;
            head = current;
            prev = null;
            while (current != null && count < k){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            if (newHead == null)
                newHead = prev;
            if (tail != null)
                tail.next = prev;

            tail = head;
        }
        return newHead;
    }
}
