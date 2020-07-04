package Stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
//https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
public class GetMinimumFromStack {
    /**
     * Consider the following SpecialStack
     * 16  --> TOP
     * 15
     * 29
     * 19
     * 18
     *
     */
}

class SpecialStack extends Stack<Integer>
{
    Stack<Integer> minStack = new Stack<>();
    public void push(int item)
    {
        super.push(item);
        if (minStack.isEmpty() || minStack.peek() > item)
            minStack.push(item);
    }

    public Integer pop()
    {
        int result = super.pop();
        if (!minStack.isEmpty() && minStack.peek() == result)
            minStack.pop();
        return result;
    }

    public Integer peek()
    {
        return super.peek();
    }

    public Integer getMin()
    {
        return minStack.peek();
    }

}

/**
 * How 2*x - minEle is less than x in push()?
 * x < minEle which means x - minEle < 0
 *
 * // Adding x on both sides
 * x - minEle + x < 0 + x
 *
 * 2*x - minEle < x
 *
 * We can conclude 2*x - minEle < new minEle
 *
 */
class SpecialStackOptimized extends Stack<Integer>
{
    int minElement = Integer.MAX_VALUE ;
    public void push(int item)
    {
        if (this.minElement == Integer.MAX_VALUE){
            this.minElement = item;
            super.push(item);
        } else if(item >= this.minElement){
            super.push(item);
        } else{
            super.push(2*item - this.minElement);
            this.minElement = item;
        }
    }

    public Integer poll()
    {
        int result = super.pop();
        if (result < this.minElement){
            this.minElement = 2*this.minElement - result;
        }
        return result;
    }

    public Integer getMin()
    {
        return this.minElement;
    }



}
