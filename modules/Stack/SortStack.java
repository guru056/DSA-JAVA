package Stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>() {{
            push(30);
            push(-5);
            push(18);
            push(14);
            push(-3);
        }}  ;
        System.out.println(st);
        sort(st);
        System.out.println(st);
    }

    /**
     *
     * @param st
     * @return
     */
    public static void sort(Stack<Integer> st) {
        if (st.isEmpty())
            return;
        int top = st.pop();
        sort(st);
//        sortedInsert(st, top);
        sortedInsertRecursive(st, top);
    }

    public static void sortedInsert(Stack<Integer> st, int elem) {
        Stack<Integer> tempStack = new Stack<>();
        while (!st.isEmpty() && st.peek() > elem) {
            tempStack.push(st.pop());
        }
        st.push(elem);
        while (!tempStack.isEmpty()) {
            st.push(tempStack.pop());
        }
    }

    public static void sortedInsertRecursive(Stack<Integer> st, int elem) {
        if (st.isEmpty() || st.peek() <= elem) {
            st.push(elem);
            return;
        }
        int top = st.pop();
        sortedInsertRecursive(st, elem);
        st.push(top);
    }

}
