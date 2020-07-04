package LinkedLists;

import Utils.LinkedListUtils;

//https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists-set-3
//https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
public class AddTwoLists {

    public static void main(String[] args) {
        SinglyLinkedList ll1 = new SinglyLinkedList();
        ll1.head = new Node(5);
        ll1.head.next = new Node(6);
        ll1.head.next.next = new Node(3);

        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll2.head = new Node(8);
        ll2.head.next = new Node(4);
        ll2.head.next.next = new Node(2);

        LinkedListUtils.printLinkedList(ll1);
        LinkedListUtils.printLinkedList(ll2);
        Node resultList = addTwoLists(ll1.head, ll2.head);
        LinkedListUtils.printLinkedList(resultList);

        SinglyLinkedList ll3 = new SinglyLinkedList();
        ll3.head = new Node(7);
        ll3.head.next = new Node(5);
        ll3.head.next.next = new Node(9);
        ll3.head.next.next.next = new Node(4);
        ll3.head.next.next.next.next = new Node(6);

        SinglyLinkedList ll4 = new SinglyLinkedList();
        ll4.head = new Node(8);
        ll4.head.next = new Node(4);

        LinkedListUtils.printLinkedList(ll3);
        LinkedListUtils.printLinkedList(ll4);
        resultList = addTwoLists(ll3.head, ll4.head);
        LinkedListUtils.printLinkedList(resultList);

        LinkedListUtils.printLinkedList(ll4);
        LinkedListUtils.printLinkedList(ll3);
        resultList = addTwoLists(ll4.head, ll3.head);
        LinkedListUtils.printLinkedList(resultList);

        SinglyLinkedList ll5 = new SinglyLinkedList();
        ll5.head = new Node(9);
        ll5.head.next = new Node(9);

        SinglyLinkedList ll6 = new SinglyLinkedList();
        ll6.head = new Node(9);

        LinkedListUtils.printLinkedList(ll5);
        LinkedListUtils.printLinkedList(ll6);
        resultList = addTwoLists(ll5.head, ll6.head);
        LinkedListUtils.printLinkedList(resultList);

    }

    /**
     * Input: List1: 5->6->3  // represents number 365
     *        List2: 8->4->2 //  represents number 248
     * Output: Resultant list: 3->1->6  // represents number 613
     *
     * Input: List1: 7->5->9->4->6  // represents number 64957
     *        List2: 8->4 //  represents number 48
     * Output: Resultant list: 5->0->0->5->6  // represents number 65005
     */

    public static Node addTwoListsV2(Node headA, Node headB)
    {
        Node head = null;
        int carry = 0;
        int sum = 0;
        Node prev = null;

        while (headA != null && headB != null){
            sum = carry + headA.data + headB.data;
            carry = sum / 10;
            sum = sum % 10;
            Node sumNode = new Node(sum);
            if (prev != null){
                prev.next = sumNode;
            } else{
                head = sumNode;
            }
            prev = sumNode;
            headA = headA.next;
            headB = headB.next;
        }

        if (headB != null){
            headA = headB;
        }

        while (headA != null){
            sum = carry + headA.data;
            carry = sum / 10;
            sum = sum % 10;
            Node sumNode = new Node(sum);
            prev.next = sumNode;
            prev = sumNode;
            headA = headA.next;
        }

        if (carry != 0 ){
            prev.next = new Node(carry);
        }
        return head;
    }

    public static Node addTwoLists(Node headA, Node headB)
    {
        Node head = headA;
        int carry = 0;
        int sum = 0;
        Node prev = null;

        while (headA != null && headB != null){
            sum = carry + headA.data + headB.data;
            carry = sum / 10;
            sum = sum % 10;
            headA.data = sum;
            prev = headA;
            headA = headA.next;
            headB = headB.next;
        }

        if (headB != null){
            prev.next = headB;
            headA = headB;
        }

        while (headA != null){
            sum = carry + headA.data;
            carry = sum / 10;
            sum = sum % 10;
            headA.data = sum;
            prev = headA;
            headA = headA.next;
        }

        if (carry != 0 ){
            prev.next = new Node(carry);
        }
        return head;
    }
}
