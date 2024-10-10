package LinkedLists;

import Utils.LinkedListUtils;

//https://www.geeksforgeeks.org/find-intersection-point-of-two-linked-lists-without-finding-the-length/
//https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class IntersectionPoint {

    public static void main(String[] args) {
        SinglyLinkedList ll1 = SinglyLinkedList.getMockLinkedList();
        ll1.head.next.next.next.next = new Node(5);

        SinglyLinkedList ll2 = new SinglyLinkedList(6);
        ll2.head.next = ll1.head.next.next.next;

        LinkedListUtils.printLinkedList(ll1);
        LinkedListUtils.printLinkedList(ll2);

        printIntersectionNode(ll1,ll2);

    }

    public static void printIntersectionNode(SinglyLinkedList ll1, SinglyLinkedList ll2)
    {
        Node intersectionNode = getIntersectionNode(ll1, ll2);
        if (intersectionNode == null){
            System.out.println("No intersection point present!");
        } else {
            System.out.println("Intersection point : " + intersectionNode.data);
        }

        intersectionNode = getIntersectionNodeV2(ll1,ll2);
        if (intersectionNode == null){
            System.out.println("No intersection point present!");
        } else {
            System.out.println("Intersection point : " + intersectionNode.data);
        }
    }

    public static Node getIntersectionNode(SinglyLinkedList ll1, SinglyLinkedList ll2)
    {
        int c1 = LinkedListUtils.getNodeCount(ll1);
        int c2 = LinkedListUtils.getNodeCount(ll2);

        Node current1 = ll1.head;
        Node current2 = ll2.head;

        if (c1 < c2){
            current1 = ll2.head;
            current2 = ll1.head;
        }

        int diff = Math.abs(c1 - c2);
        int c = 0;
        while (current1 != null && c < diff){
            current1 = current1.next;
            c++;
        }

        while(current1 != null && current2 != null){
            if (current1 == current2)
                return current1;
            current1 = current1.next;
            current2 = current2.next;
        }
        return null;
    }
    /**
     * Approach: Take two pointers for the heads of both the linked lists.
     * If one of them reaches the end earlier then use it by moving it to the beginning of the other list.
     * Once both of them go through reassigning they will be equidistance from the collision point.
     * NOTE: works only if it is given that there exists an intersection point in the lists
     * */
    public static Node getIntersectionNodeV2(SinglyLinkedList ll1, SinglyLinkedList ll2)
    {
        Node current1 = ll1.head;
        Node current2 = ll2.head;

        while (current1 != current2) {
            current1 = current1 == null ? ll2.head: current1.next;
            current2 = current2 == null ? ll1.head: current2.next;
        }
        return null;
    }
}
