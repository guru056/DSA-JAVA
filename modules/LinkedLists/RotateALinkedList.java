package LinkedLists;

import Utils.LinkedListUtils;

//https://www.geeksforgeeks.org/rotate-a-linked-list/
public class RotateALinkedList {

    public static void main(String[] args) {
        SinglyLinkedList ll = SinglyLinkedList.getMockLinkedListV2();
        Node newHead = rotateAntiClockwise(ll.head, 4);
        LinkedListUtils.printLinkedList(newHead);
    }

    public static Node rotateAntiClockwise(Node head, int k)
    {
        //assuming k is less than size of list
        if (head == null || head.next == null)
            return head;
        Node current = head;
        Node prev = null;
        int count = 0;

        while (current != null && count < k) {
            prev = current;
            current = current.next;
            count++;
        }
        if (current == null) // k is greater than size of list
            return head;
        prev.next = null;
        Node newHead = current;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        return newHead;
    }
}
