package Queue;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/implement-a-stack-using-single-queue/
//https://www.geeksforgeeks.org/implement-stack-using-queue/
public class StackUsingQueue {
    public static void main(String[] args) {
        Stack1 st = new Stack1() ;
        st.push(1);
        st.push(2);
        System.out.println(st.peek());
    }
}

class Stack{
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int item)
    {
        queue1.add(item);
    }

    public int poll()
    {
        if (queue1.isEmpty())
            return Integer.MAX_VALUE;
        while (queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        return queue1.poll();
    }

    public int peek()
    {
        if (queue1.isEmpty())
            return Integer.MAX_VALUE;
        while (queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        queue2.add(result);
        return result;
    }
}

class Stack1{
    Queue<Integer> queue = new LinkedList<>();

    public void push(int item)
    {
        queue.add(item);
    }

    public int poll()
    {
        if (queue.isEmpty())
            return Integer.MAX_VALUE;
        for (int i = 0 ; i < queue.size() - 1; i++){
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    public int peek()
    {
        if (queue.isEmpty())
            return Integer.MAX_VALUE;
        int result = queue.peek();
        for (int i = 0 ; i < queue.size() ; i++){
            result = queue.poll();
            queue.add(result);
        }
        return result;
    }
}

