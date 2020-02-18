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
            return this.map.get(key).data;
        }
        System.out.println("[MISS] for cache key : " + key);
        return -1;
    }

    public void set(int key, int value)
    {
        value = key;
        Node node = this.map.get(key);
        if (node != null){
            this.dll.moveToFirst(node);
            this.map.put(key, this.dll.getHead());
            return;
        }

        if (this.currentSize < this.CACHE_CAPACITY){
            Node newNode = new Node(value);
            this.dll.insertAtFirst(newNode);
            this.map.put(key,this.dll.getHead());
            this.currentSize++;
            return;
        }

        Node newNode = new Node(value);
        Node tail = this.dll.getTail();
        this.dll.removeLastNode();
        this.map.remove(tail.data);
        this.dll.insertAtFirst(newNode);
        this.map.put(key,this.dll.getHead());
        return;

    }


}

