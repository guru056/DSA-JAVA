package Heaps;

import Utils.ArrayUtils;

public class MinHeaps extends Heaps{

    public static void main(String[] args) {
        MinHeaps heapObj = new MinHeaps();
        heapObj.insert(30);
        heapObj.insert(20);
        heapObj.insert(40);
        heapObj.insert(10);
        heapObj.display();
    }

    @Override
    public void decreaseKey(int index, int key) {
        if (key >= this.heap[index] || index > this.heapSize - 1)
            return;
        this.heap[index] = key;
        int i = index;
        while (i >= 0 && this.heap[(i-1)/2] > this.heap[i]){
            ArrayUtils.swap(this.heap, i, (i-1)/2);
            i = (i - 1) / 2;
        }
    }

    @Override
    public void increaseKey(int index, int key) {
        if (key <= this.heap[index] || index > this.heapSize - 1)
            return;
        this.heap[index] = key;
        this.heapify(index);
    }

    @Override
    public void insert(int key) {
        if (this.heapSize >= MAX_SIZE){
            System.out.println("Cannot Insert, Heap Overflow!!!");
            return;
        }
        this.heap[this.heapSize] = key;
        int i = this.heapSize;

        while ( i > 0 && this.heap[(i-1)/2] > this.heap[i]){
            ArrayUtils.swap(this.heap, (i - 1)/2, i);
            i = (i - 1 )/2;
        }
        this.heapSize++;

    }

    @Override
    public void heapify(int index) {
        int l = 2*index + 1;
        int r = 2*index + 2;
        int smallest = index;

        if ( l < this.heap.length && this.heap[l] > this.heap[smallest]){
            smallest = l;
        }
        if (r < this.heap.length && this.heap[r] > this.heap[smallest]){
            smallest = r;
        }

        if (smallest != index){
            ArrayUtils.swap(this.heap, index, smallest);
            this.heapify(smallest);
        }
    }

    public int findMin(){
        return this.heap.length > 0 ? this.heap[0] : Integer.MAX_VALUE;
    }

    public void printMin(){
        if (this.findMin() == Integer.MAX_VALUE){
            System.out.println("Empty Heap");
        }
        System.out.println(this.findMin());
    }

    public void deleteMin(){
        if (this.heapSize == 0){
            System.out.println("Cannot Delete, Heap Underflow!");
            return;
        }
        this.heap[0] = this.heap[this.heapSize - 1];
        this.heapify(0);
        this.heapSize--;
    }
}
