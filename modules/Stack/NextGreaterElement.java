package Stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {4,5,2,25};
        printNextGreaterElement(arr);
    }
    /**
     * Element       NGE
     *    4      -->   5
     *    5      -->   25
     *    2      -->   25
     *    25     -->   -1
     * @param arr
     */
    public static void printNextGreaterElement(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++)
        {
            while (!st.isEmpty() && arr[i] > st.peek()){
                System.out.println("NGE for " + st.pop() + " is " + arr[i]);
            }
            st.push(arr[i]);
        }
        while(!st.isEmpty()){
            System.out.println("NGE for " + st.pop() + " is -1" );
        }
    }
}
