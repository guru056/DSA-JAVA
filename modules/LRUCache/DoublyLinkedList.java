package LRUCache;

public class DoublyLinkedList<K,V> {

    private Node<K,V> head;
    private Node<K,V> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node<K,V> getHead() {
        return head;
    }

    public Node<K,V> getTail() {
        return tail;
    }

    public void removeLastNode(){
        if (this.head == null || this.tail == null)
            return;
        if (this.head == this.tail){
            this.head = null;
            this.tail = null;
            return;
        }

        Node prev = this.tail.prev;
        this.tail.prev.next = null;
        this.tail.prev = null;
        this.tail = prev;
    }

    public void insertAtFirst(Node<K,V> node){
        if (this.head == null){
            this.head = node;
            this.tail = this.head;
            return;
        }
        this.head.prev = node;
        node.next = head;
        node.prev = null;
        this.head = node;
    }

    public void moveToFirst(Node<K,V> node){
        if (this.head == node || this.head == null)
            return;
        if (this.tail == node) {
            this.removeLastNode();
            this.insertAtFirst(node);
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.head.prev = node;
        node.prev = null;
        node.next = this.head;
        this.head = node;
    }

}
