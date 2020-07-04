package LinkedLists;

public class DetectLoop {

    public static boolean detectLoop(SinglyLinkedList ll)
    {
        Node slow = ll.head;
        Node fast = ll.head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void detectAndRemoveLoop(SinglyLinkedList ll )
    {
        Node slow = ll.head;
        Node fast = ll.head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast)
            return;
        slow = ll.head;
        while (slow.next != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
}
