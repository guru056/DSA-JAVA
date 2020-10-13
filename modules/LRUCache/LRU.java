package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRU<K,V> {
    private final int CACHE_CAPACITY =  3;
    private DoublyLinkedList<K,V> dll;
    private Map<K, Node<K,V>> map;
    private int currentSize ;

    public LRU() {
        this.dll = new DoublyLinkedList();
        this.map = new HashMap<>();
        this.currentSize = 0;
    }

    /**
     * Returns value corresponding to key from cache.
     * Returns null if key is not present
     * Moves the node to the beginning of the list of key is present
     * @param key
     * @return
     */
    public V get(K key)
    {
        Node<K,V> node = this.map.get(key);
        if (node != null){
            this.dll.moveToFirst(node);
            return node.getData();
        }
        System.out.println("[MISS] for cache key : " + key);
        return null;
    }

    /**
     * if map has key present
     *  - update the value
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
    public void set(K key, V value)
    {
        Node<K,V> node = this.map.get(key);
        if (node != null){
            node.setData(value);
            this.map.put(key, node);
            this.dll.moveToFirst(node);
            return;
        }

        Node<K,V> newNode = new Node(key,value);
        if (this.currentSize >= this.CACHE_CAPACITY) {
            this.map.remove(this.dll.getTail().getKey());
            this.dll.removeLastNode();
        }

        this.dll.insertAtFirst(newNode);
        this.map.put(key,this.dll.getHead());
        this.incrementSize();
        return;

    }

    private void incrementSize()
    {
        if (this.currentSize < this.CACHE_CAPACITY) {
            this.currentSize++;
        }
    }


}

