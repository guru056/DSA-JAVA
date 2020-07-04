package LRUCache;

public class LRU_Utility {
    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.set(1,34);
        lru.set(2,35);
        lru.set(5,36);
        lru.set(3,37);
//        lru.set(1,34);
//        lru.set(1,34);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        System.out.println(lru.get(5));
        System.out.println(lru.get(3));
    }
}
