package LRUCache;

public class Node {

    private int data;
    private int key;
    Node prev;
    Node next;

    public Node(int key, int data)
    {
        this.key = key;
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public int getKey() { return key; }
}
