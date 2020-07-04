package LRUCache;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void removeLastNode(){
        if (this.tail == null)
            return;
        if (this.head == this.tail){
            this.head = null;
            this.tail = null;
            return;
        }
        this.tail.prev.next = null;
        this.tail = this.tail.prev;
        this.tail.prev = null;
    }

    public void insertAtFirst(Node node){
        if (this.head == null){
            this.head = node;
            this.tail = this.head;
            return;
        }
        this.head.prev = node;
        node.next = head;
        this.head = node;
    }

    public void moveToFirst(Node node){
        if (this.head == node || this.head == null)
            return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (node == this.tail){
            this.tail = node.prev;
        }
        this.head.prev = node;
        node.prev = null;
        node.next = this.head;
        this.head = node;
    }

}
