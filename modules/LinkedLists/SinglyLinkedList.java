package LinkedLists;

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public SinglyLinkedList(int data) {
        this.head = new Node(data);
    }

    public SinglyLinkedList(SinglyLinkedList ll)
    {
        this.head = ll.head;
    }

    public static SinglyLinkedList getMockLinkedList()
    {
        /** 1->2->3->4->NULL **/
        SinglyLinkedList ll     = new SinglyLinkedList();
        ll.head                 = new Node(1);
        ll.head.next            = new Node(2);
        ll.head.next.next       = new Node(3);
        ll.head.next.next.next  = new Node(4);
        return ll;
    }

    public static SinglyLinkedList getMockLinkedListV2()
    {
        /**1->2->3->4->5->6->7->8->NULL **/
        SinglyLinkedList ll = getMockLinkedList();
        ll.head.next.next.next.next                 = new Node(5);
        ll.head.next.next.next.next.next            = new Node(6);
        ll.head.next.next.next.next.next.next       = new Node(7);
        ll.head.next.next.next.next.next.next.next  = new Node(8);
        return ll;
    }

    public static SinglyLinkedList clone(SinglyLinkedList ll)
    {
        SinglyLinkedList llClone = new SinglyLinkedList();
        llClone.head = new Node(ll.head.data);
        Node current = ll.head;
        Node currentClone = llClone.head;

        while (current.next != null){
            current = current.next;
            currentClone.next = new Node(current.data);
            currentClone = currentClone.next;
        }
        return llClone;
    }

    public static SinglyLinkedList getMockPalindromeLinkedList()
    {
        /** 1->2->3->4->NULL **/
        SinglyLinkedList ll     = new SinglyLinkedList();
        ll.head                 = new Node(1);
        ll.head.next            = new Node(2);
        ll.head.next.next       = new Node(2);
        ll.head.next.next.next  = new Node(1);
        return ll;
    }

    public static SinglyLinkedList getMockPalindromeLinkedListV2()
    {
        /** 1->2->3->4->NULL **/
        SinglyLinkedList ll             = new SinglyLinkedList();
        ll.head                         = new Node(1);
        ll.head.next                    = new Node(2);
        ll.head.next.next               = new Node(3);
        ll.head.next.next.next          = new Node(2);
        ll.head.next.next.next.next     = new Node(1);
        return ll;
    }

}
