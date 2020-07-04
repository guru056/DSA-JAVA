package Heaps;

import Utils.ArrayUtils;

public class MaxHeaps extends Heaps{

    public static void main(String[] args) {
        MaxHeaps heapObj = new MaxHeaps();
        heapObj.insert(10);
        heapObj.insert(20);
        heapObj.insert(30);
        heapObj.insert(40);
        heapObj.display();
        heapObj.deleteMax();
        heapObj.display();
        heapObj.decreaseKey(0, 5);
        heapObj.display();
        heapObj.insert(55);
        heapObj.insert(25);
        heapObj.display();
        heapObj.decreaseKey(0, 15);
        heapObj.display();

    }

    public  void heapify(int index){
        int l = 2*index + 1;
        int r = 2*index + 2;
        int largest = index;

        if ( l < this.heap.length && this.heap[l] > this.heap[largest]){
            largest = l;
        }
        if (r < this.heap.length && this.heap[r] > this.heap[largest]){
            largest = r;
        }

        if (largest != index){
            ArrayUtils.swap(this.heap, index, largest);
           this.heapify(largest);
        }
    }

    public void insert(int element){
         if (this.heapSize >= MAX_SIZE){
             System.out.println("Cannot Insert, Heap Overflow!!!");
             return;
         }

         this.heap[this.heapSize] = element;
         int i = this.heapSize;

         while ( i > 0 && this.heap[(i-1)/2] < this.heap[i]){
             ArrayUtils.swap(this.heap, (i - 1)/2, i);
             i = (i - 1 )/2;
         }
        this.heapSize++;
    }

    public void increaseKey(int index, int key){
         if (key <= this.heap[index] || index > this.heapSize - 1)
             return;
         this.heap[index] = key;
         int i = index;
         while (i >= 0 && this.heap[(i-1)/2] < this.heap[i]){
             ArrayUtils.swap(this.heap, i, (i-1)/2);
             i = (i - 1) / 2;
         }
    }

    public void decreaseKey(int index, int key){
        if (key >= this.heap[index] || index > this.heapSize - 1)
            return;
        this.heap[index] = key;
        this.heapify(index);
    }

    public int findMax(){
        return this.heap.length > 0 ? this.heap[0] : Integer.MIN_VALUE;
    }

    public void printMax(){
        if (this.findMax() == Integer.MIN_VALUE){
            System.out.println("Empty Heap");
        }
        System.out.println(this.findMax());
    }

    public void deleteMax(){
        if (this.heapSize == 0){
            System.out.println("Cannot Delete, Heap Underflow!");
            return;
        }
        this.heap[0] = this.heap[this.heapSize - 1];
        this.heapify(0);
        this.heapSize--;
    }

}
