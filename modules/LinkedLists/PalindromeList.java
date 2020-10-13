package LinkedLists;

import Utils.LinkedListUtils;

//https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeList {
    public static void main(String[] args) {
        SinglyLinkedList ll = SinglyLinkedList.getMockLinkedList();
        System.out.println(isPalindrome(ll));
    }

    /**
     * 1 -> 2 -> 3 -> 4
     * 1 -> 2 -> 3 -> 4 -> 5
     * @param ll
     * @return
     */
    public static boolean isPalindrome(SinglyLinkedList ll)
    {
        if (ll.head == null || ll.head.next == null)
            return true;

        Node prevMiddleNode = null;
        Node slow = ll.head;
        Node fast = ll.head;
        Node mid = null;

        while (fast != null && fast.next != null) {
            prevMiddleNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            mid = slow;
            slow = slow.next;
        }

        Node middleNode = slow;
        prevMiddleNode.next = null;
        Node headReverse = ReverseLinkedList.reverseRecursiveUtil(middleNode);

        //compareLists
        boolean isPalindrome = compareLists(ll.head, headReverse);
        if (mid != null) {
            prevMiddleNode.next = mid;
            mid.next = ReverseLinkedList.reverseRecursiveUtil(headReverse);
        } else {
            prevMiddleNode.next = ReverseLinkedList.reverseRecursiveUtil(headReverse);
        }

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
