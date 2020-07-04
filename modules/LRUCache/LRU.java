package LRUCache;

import java.util.HashMap;

public class LRU {
    public final int CACHE_CAPACITY =  3;
    public DoublyLinkedList dll;
    public HashMap<Integer, Node> map;
    public int currentSize ;

    public LRU() {
        this.dll = new DoublyLinkedList();
        this.map = new HashMap<Integer, Node>();
        this.currentSize = 0;
    }

    public int get(int key)
    {
        Node node = this.map.get(key);
        if (node != null){
            this.dll.moveToFirst(node);
            return node.getData();
        }
        System.out.println("[MISS] for cache key : " + key);
        return -1;
    }

    /**
     * if map has key present
     *  - Move node to first
     * if map does not have key present
     *  - If current capacity is less than cache capacity
     *      - insert node at first
     *      - set in map -> key, ll.getHead
     *      - increment size
     *  - else
     *      - remove tail Node from LL
     *      - remove tail key from map
     *      - insert new node at first
     *      - set in map -> key, ll.getHead
     * @param key
     * @param value
     */
    public void set(int key, int value)
    {
        Node node = this.map.get(key);
        if (node != null){
            this.dll.moveToFirst(node);
//            this.map.put(key, this.dll.getHead()); //not needed
            return;
        }

        if (this.currentSize < this.CACHE_CAPACITY){
            Node newNode = new Node(key,value);
            this.dll.insertAtFirst(newNode);
            this.map.put(key,this.dll.getHead());
            this.currentSize++;
            return;
        }

        Node newNode = new Node(key, value);
        Node tail = this.dll.getTail();
        this.dll.removeLastNode();
        this.map.remove(tail.getKey());
        this.dll.insertAtFirst(newNode);
        this.map.put(key,this.dll.getHead());
        return;

    }


}

