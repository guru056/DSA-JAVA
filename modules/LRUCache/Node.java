package LRUCache;

public class Node<K,V> {

    private K key;
    private V data;
    Node<K,V> prev;
    Node<K,V> next;

    public Node(K key, V data)
    {
        this.key = key;
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public K getKey() { return key; }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", data=" + data +
                '}';
    }
}
