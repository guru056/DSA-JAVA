package Arrays.BasicOperations;

import Utils.ArrayUtils;

public class SortedArray {
    private static final int SIZE = 5;
    private int[] arr = new int[SIZE];
    private int currentSize = 0;

    public static void main(String[] args) {
        SortedArray arrayOperations = new SortedArray();
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize-1);
        arrayOperations.insertElem(1);
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize-1);
        arrayOperations.insertElem(4);
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize-1);
        arrayOperations.insertElem(2);
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize-1);
        arrayOperations.insertElem(3);
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize-1);
        arrayOperations.insertElem(3);
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize-1);
        arrayOperations.insertElem(25);
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize-1);
        arrayOperations.deleteElem(25);
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize-1);
        arrayOperations.deleteElem(3);
        ArrayUtils.printSubArray(arrayOperations.arr,0,arrayOperations.currentSize - 1);

        System.out.println(arrayOperations.search(1));
        System.out.println(arrayOperations.search(3));
        System.out.println(arrayOperations.search(26));
        System.out.println(arrayOperations.searchRecursiveUtil(1));
        System.out.println(arrayOperations.searchRecursiveUtil(3));
        System.out.println(arrayOperations.searchRecursiveUtil(4));

    }

    private int search(int elem){

        int begin = 0;
        int end = this.currentSize - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if(this.arr[mid] == elem){
                return mid;
            } else if(elem < this.arr[mid]){
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return -1;
    }

    private int searchRecursive(int begin, int end, int elem){
        if ( begin > end)
            return -1;
        int mid = ( begin + end ) /2 ;
        if(this.arr[mid] == elem){
            return mid;
        } else if(elem < this.arr[mid]){
            return this.searchRecursive(begin, mid -1 , elem);
        } else {
            return this.searchRecursive(mid + 1, end , elem);
        }
    }

    private int searchRecursiveUtil(int elem){
        return searchRecursive(0, this.currentSize - 1 , elem);
    }

    private void insertElem(int elem){
        if(this.currentSize >= SIZE){
            System.out.println("Size exceeded!");
            return;
        }
        int i;
        for (  i = this.currentSize - 1; (i >= 0 && elem < this.arr[i]); i--){
            this.arr[i+1] = this.arr[i];
        }
        this.arr[i+1] = elem;
        this.currentSize++;

        /*int i = 0;
        while (elem > this.arr[i] && i < this.currentSize){
            i++;
        }
        this.currentSize++;
        for ( int j = this.currentSize - 1 ; j > i; j--){
            this.arr[j] = this.arr[j-1];
        }
        this.arr[i] = elem;*/

    }

    private void deleteElem(int elem){
        int index = this.search(elem);
        if(index == -1){
            System.out.println("Cannot Delete, element not found in array");
            return;
        }
        for (int i = index; i < this.currentSize - 1; i++){
            this.arr[i] = this.arr[i+1];
        }
        this.currentSize--;
    }
}
