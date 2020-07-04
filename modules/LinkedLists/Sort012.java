package LinkedLists;
//https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/
public class Sort012 {

    public static Node sort012(SinglyLinkedList ll)
    {
        Node zeroD = new Node(0); //dummy node for 0s
        Node oneD = new Node(0); //dummy node for 1s
        Node twoD = new Node(0); //dummy node for 2s

        Node zero = zeroD; //iterator for zeroD node
        Node one = oneD; //iterator for oneD node
        Node two = twoD; //iterator for twoD node

        Node current = ll.head;
        while (current != null)
        {
            if (current.data == 0){
                zero.next = current;
                zero = zero.next;
            } else if(current.data == 1){
                one.next = current;
                one = one.next;
            } else{
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }
        zero.next = oneD.next != null ? oneD.next: twoD.next;
        one.next = twoD.next;
        two.next = null;

        return zeroD.next;
    }
}
