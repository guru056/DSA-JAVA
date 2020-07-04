package Utils;

import LinkedLists.Node;
import LinkedLists.SinglyLinkedList;

public class LinkedListUtils {


    public static void printLinkedList(SinglyLinkedList ll)
    {
        Node current = ll.head;
        if (current == null)
            return;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void printLinkedList(Node head)
    {
        Node current = head;
        if (current == null)
            return;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static int getNodeCount(SinglyLinkedList ll)
    {
        Node current = ll.head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }
}
