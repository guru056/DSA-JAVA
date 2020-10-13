package Stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>() {{
            push(4);
            push(3);
            push(2);
            push(1);
        }}  ;
        System.out.println(st);
        reverse(st);
        System.out.println(st);
    }

    public static void reverse(Stack<Integer> st) {
        if (st.isEmpty())
            return;
        int elem = st.pop();
        reverse(st);
        insertAtBottom(st, elem);
    }

    public static void insertAtBottom(Stack<Integer> st, int elem) {
        if (st.isEmpty()) {
            st.push(elem);
            return;
        }

        int e = st.pop();
        insertAtBottom(st, elem);
        st.push(e);
    }

}
