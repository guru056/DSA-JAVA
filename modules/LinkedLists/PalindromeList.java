package LinkedLists;
//https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
public class PalindromeList {

    public static boolean isPalindrome(SinglyLinkedList ll)
    {
        Node prevMiddleNode = FindMiddleNode.getNodePreviousToMiddleNode(ll.head);
        Node middleNode = prevMiddleNode.next;

        prevMiddleNode.next = null;
        Node headReverse = ReverseLinkedList.reverseRecursiveUtil(middleNode);

        //compareLists
        boolean isPalindrome = compareLists(ll.head, headReverse);

        prevMiddleNode.next = ReverseLinkedList.reverseRecursiveUtil(headReverse);
        return isPalindrome;
    }

    private static boolean compareLists(Node headA, Node headB)
    {
        while (headA != null && headB != null)
        {
            if (headA.data != headB.data)
                return false;
            headA = headA.next;
            headB = headB.next;
        }
        return headA == null && headB == null;
    }
}
