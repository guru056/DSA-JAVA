package LinkedLists;

//https://www.geeksforgeeks.org/queue-linked-list-implementation/
public class QueueUsingLinkedListImplementation {


}

class Queue{

    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void add(int data)
    {
        Node newNode = new Node(data);
        if (this.front == null){
            this.front = newNode;
            this.rear = this.front;
            return;
        }
        this.rear.next = newNode;
        this.rear = this.rear.next;
    }

    public int poll()
    {
        if (this.front == null)
            return Integer.MIN_VALUE;
        int result = this.front.data;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        return result;
    }

    public int peek()
    {
        if (this.front == null)
            return Integer.MIN_VALUE;
        return this.front.data;
    }
}