package LRUCache;

import java.util.*;

class QueueNode<K,V> {
    private K key;
    private V value;

    public QueueNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class LRU_Dequeue<K,V> {

    private final int CACHE_CAPACITY =  3;
    private Deque<QueueNode<K,V>> dll;
    private Map<K, QueueNode<K,V>> map;
    private int currentSize;


    public LRU_Dequeue() {
        this.dll = new LinkedList<>();
        this.map = new HashMap<>();
        this.currentSize = 0;
    }

    public V get(K key) {
        QueueNode<K,V> node = this.map.get(key);
        if (node != null){
            //move to first
            this.dll.remove(node);
            this.dll.addFirst(node);
            return node.getValue();
        }
        System.out.println("[MISS] for cache key : " + key);
        return null;
    }

    public void set(K key, V value) {

        QueueNode<K,V> node = this.map.get(key);
        if (node != null){
            this.dll.remove(node);
            this.dll.addFirst(node);
//            this.map.put(key, this.dll.getHead()); //not needed
            return;
        }

        if (this.currentSize < this.CACHE_CAPACITY){
            QueueNode<K,V> newNode = new QueueNode<>(key,value);
            this.dll.addFirst(newNode);
            this.map.put(key,newNode);
            this.currentSize++;
            return;
        }

        QueueNode<K,V> newNode = new QueueNode<>(key, value);
        QueueNode<K,V> tail = this.dll.peekLast();
        this.dll.removeLast();
        this.map.remove(tail.getKey());
        this.dll.addFirst(newNode);
        this.map.put(key,newNode);
        return;
    }
}
