package Arrays.BasicOperations;


import Utils.ArrayUtils;

public class UnsortedArray {

    private static final int SIZE = 1;
    private int[] arr = new int[SIZE];
    private int currentSize = 0;

    public static void main(String[] args) {
        UnsortedArray arrayOperations = new UnsortedArray();
        ArrayUtils.printArr(arrayOperations.arr);
        arrayOperations.insertAtEnd(2);
        arrayOperations.insertAtFirst(1);
        ArrayUtils.printArr(arrayOperations.arr);
    }

    private void insertAtFirst(int elem){
        if ( this.currentSize > SIZE){
            System.out.println("Size exceeeded");
            return;
        }
        for (int i = this.currentSize - 1; i > 0; i--){
            this.arr[i] = this.arr[i-1];
        }
        this.arr[0] = elem;
        this.currentSize++;
    }

    private void insertAtEnd(int elem){
        if ( this.currentSize > SIZE){
            System.out.println("Size exceeeded");
            return;
        }
        if ( this.currentSize == 0){
            this.insertAtFirst(elem);
        }
        this.arr[currentSize-1] = elem;
        this.currentSize++;
    }

    private void deleteFirst(){
        for (int i = 0 ; i < this.currentSize - 1 ; i++) {
            this.arr[i] = this.arr[i+1];
        }
        this.currentSize--;
    }

    private void deleteLast(){
        if ( this.currentSize > 0) {
            this.currentSize--;
        }
    }

    private int search(int elem){
        for (int i = 0; i < this.currentSize; i++){
            if ( this.arr[i] == elem)
                return i;
        }
        return -1;
    }

    private void deleteSpecific(int elem){
        int index = this.search(elem);
        if ( index == -1 ){
            System.out.println("Element not found!");
            return;
        }
        for ( int i = index ; i < this.currentSize - 1; i++){
            this.arr[i] = this.arr[i+1];
        }
        this.currentSize--;
    }

}
