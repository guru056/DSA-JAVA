package LinkedLists;
//https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
public class FindMiddleNode {

    public static Node getMiddleNode(Node head)
    {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node getNodePreviousToMiddleNode(Node head)
    {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (fast != null)
        {
            prev = slow;
            slow = slow.next;
        }
        return prev;
    }
}
