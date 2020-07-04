package Stack;

import java.util.Stack;
//https://www.geeksforgeeks.org/queue-using-stacks/
public class QueueUsingStack {


}

class Queue {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public void add(int item)
    {
        st1.push(item);
    }

    public int poll()
    {
        if (st1.isEmpty() && st2.isEmpty())
            return Integer.MAX_VALUE;
        if (!st2.isEmpty())
            return st2.pop();
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.pop();
    }

    public int peek()
    {
        if (st1.isEmpty() && st2.isEmpty())
            return Integer.MAX_VALUE;
        if (!st2.isEmpty())
            return st2.peek();
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.peek();
    }

}
