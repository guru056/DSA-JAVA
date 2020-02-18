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
        this.tail.prev = null;
    }

    public void insertAtFirst(Node node){
        Node newNode = new Node(node);
        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
            return;
        }
        this.head.prev = newNode;
        newNode.next = head;
        this.head = newNode;
    }

    public void moveToFirst(Node node){
        if (this.head == node || this.head == null)
            return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (node == this.tail){
            this.tail = node.prev;
        }
        node.prev = null;
        node.next = this.head;
        this.head = node;
    }

}
