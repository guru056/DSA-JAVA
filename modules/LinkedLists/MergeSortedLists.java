package LinkedLists;

import Utils.LinkedListUtils;

//https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
public class MergeSortedLists {

    /**
     * For example if the first linked list a is 5->10->15
     * and the other linked list b is 2->3->20, then SortedMerge() should return a pointer to the head node of the merged list 2->3->5->10->15->20.
     * 5->10->15->NULL
     * 2->3->20->NULL
     * */
    public static void main(String[] args) {
        SinglyLinkedList ll1 = new SinglyLinkedList(5);
        ll1.head.next = new Node(10);
        ll1.head.next.next = new Node(15);

        SinglyLinkedList ll2 = new SinglyLinkedList(2);
        ll2.head.next = new Node(3);
        ll2.head.next.next = new Node(20);

        SinglyLinkedList ll3 = SinglyLinkedList.clone(ll1);
        SinglyLinkedList ll4 = SinglyLinkedList.clone(ll2);

        Node head = mergeSortedLinkedListRecursiveUtil(ll1, ll2);
        LinkedListUtils.printLinkedList(head);
        head = mergeSortedListsIterative(ll3, ll4);
        LinkedListUtils.printLinkedList(head);
    }

    public static Node mergeSortedLinkedListRecursiveUtil(SinglyLinkedList ll1, SinglyLinkedList ll2)
    {
        Node head = mergeSoredListsRecursive(ll1.head, ll2.head);
        return head;
    }

    public static Node mergeSoredListsRecursive(Node headA, Node headB)
    {
        if (headA == null)
            return headB;
        if (headB == null)
            return headA;

        if (headA.data < headB.data){
            headA.next = mergeSoredListsRecursive(headA.next, headB);
            return headA;
        } else{
            headB.next = mergeSoredListsRecursive(headA, headB.next);
            return headB;
        }
    }

    public static Node mergeSortedListsIterative(SinglyLinkedList ll1, SinglyLinkedList ll2)
    {
        Node dummyNode = new Node(0);
        Node headA = ll1.head;
        Node headB = ll2.head;
        Node refToDummy = dummyNode;
        while (headA != null && headB != null){
            if (headA.data < headB.data){
                dummyNode.next = headA;
                headA = headA.next;
            } else{
                dummyNode.next = headB;
                headB = headB.next;
            }
            dummyNode = dummyNode.next;
        }
        if (headA != null){
            dummyNode.next = headA;
        }
        if (headB != null){
            dummyNode.next = headB;
        }
        return refToDummy.next;
    }
}
