package Heaps;

abstract public class Heaps {
    protected static final int MAX_SIZE = 100;
    protected int heapSize = 0;
    protected int[] heap = new int[MAX_SIZE];

    public void display(){
        for (int i = 0; i < this.heapSize; i++){
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

    abstract public void decreaseKey(int index, int key);
    abstract public void increaseKey(int index, int key);
    abstract public void insert(int key);
    abstract public void heapify(int index);

}
