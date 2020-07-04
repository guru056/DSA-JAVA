package LinkedLists;

import Utils.LinkedListUtils;

public class ReverseLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList ll = SinglyLinkedList.getMockLinkedList();
        LinkedListUtils.printLinkedList(ll);
        reverseRecursiveUtil(ll);
        LinkedListUtils.printLinkedList(ll);
        reverseIterative(ll);
        LinkedListUtils.printLinkedList(ll);
    }

    public static void reverseRecursiveUtil(SinglyLinkedList ll)
    {
        ll.head = reverseRecursive(null, ll.head);
    }

    public static Node reverseRecursiveUtil(Node head)
    {
        return reverseRecursive(null, head);
    }

    public static Node reverseRecursive(Node prev, Node current)
    {
        if (current == null)
            return prev;

        Node temp = current.next;
        current.next = prev;
        return reverseRecursive(current, temp);
    }

    public static void reverseIterative(SinglyLinkedList ll)
    {
        Node prev = null;
        Node current = ll.head;

        while (current != null)
        {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ll.head = prev;
    }
}
