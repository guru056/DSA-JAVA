package LinkedLists;

//https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
public class NthNodeFromEnd {
    static Node nthNodeFromEnd = null;
    static int count = 0;
    public static void main(String[] args) {
        SinglyLinkedList ll = SinglyLinkedList.getMockLinkedListV2();
        printNthNodeFromEnd(ll, 1);
        printNthNodeFromEnd(ll, 8);
        printNthNodeFromEnd(ll, 3);
        printNthNodeFromEnd(ll, 9);
    }
    public static void printNthNodeFromEnd(SinglyLinkedList ll, int n)
    {
        Node nthNode = NthNodeFromEndIterative(ll, n);
        if (nthNode == null){
            System.out.println("Invalid input !!");
        } else{
            System.out.println("Nth node from end : " + nthNode.data);
        }
        setNthNodeFromRecursive(ll.head, n);
        if (nthNodeFromEnd == null){
            System.out.println("Invalid input !!");
        } else{
            System.out.println("Nth node from end : " + nthNodeFromEnd.data);
        }
        resetNthNodeFromEnd();
    }

    public static void setNthNodeFromRecursive(Node node, int n)
    {
        if (node == null)
            return;
        setNthNodeFromRecursive(node.next, n);
        count++;
        if (count == n)
            nthNodeFromEnd = node;
    }


    public static Node NthNodeFromEndIterative(SinglyLinkedList ll, int n)
    {
        Node mainPtr = ll.head;
        Node refPtr = ll.head;

        int count = 0;
        while (refPtr != null && count < n)
        {
            refPtr = refPtr.next;
            count++;
        }
        if (refPtr == null && count < n)
            return null;
        while (refPtr != null){
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return mainPtr;
    }

    private static void resetNthNodeFromEnd()
    {
        count = 0;
        nthNodeFromEnd = null;
    }
}
