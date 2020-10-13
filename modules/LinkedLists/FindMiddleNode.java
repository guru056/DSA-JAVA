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
            fast = fast.next.next;
        }
        return slow;
    }
}
