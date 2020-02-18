package LRUCache;

public class Node {

    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Node(Node node) {
        this.data = node.data;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return data;
    }
}
