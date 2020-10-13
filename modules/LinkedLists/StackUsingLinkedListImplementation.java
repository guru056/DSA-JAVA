package LinkedLists;

//https://www.geeksforgeeks.org/implement-a-stack-using-singly-linked-list/
public class StackUsingLinkedListImplementation {

}

class Stack{

    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int data)
    {
        Node newNode = new Node(data);
        newNode.next = this.top;
        this.top = newNode;
    }

    public int pop()
    {
        if (this.top == null)
            return Integer.MIN_VALUE;
        int result = this.top.data;
        this.top = this.top.next;
        return result;
    }


    public int peek()
    {
        if (this.top == null)
            return Integer.MIN_VALUE;
        return this.top.data;
    }
}
