package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.Stack;

public class IterativePostOrderTraversal {

//    https://www.geeksforgeeks.org/iterative-postorder-traversal/
//    https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        iterativePostOrderTraversal(tree);
        iterativePostOrderTraversal(BinaryTree.getMockBinaryTreeV2());

        iterativePostOrderTraversalV2(BinaryTree.getMockBinaryTree());
        iterativePostOrderTraversalV2(BinaryTree.getMockBinaryTreeV2());
    }

    public static void iterativePostOrderTraversal(BinaryTree tree)
    {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(tree.root);

        while (!st1.isEmpty()){
            Node node = st1.pop();
            st2.push(node);
            if (node.left != null){
                st1.push(node.left);
            }
            if (node.right != null){
                st1.push(node.right);
            }
        }

        while (!st2.isEmpty()){
            System.out.print(st2.pop().data + " ");
        }
        System.out.println();

    }

    public static void iterativePostOrderTraversalV2(BinaryTree tree)
    {
        Stack<Node> st = new Stack<>();
        Node current ;
        st = pushNodesInStack(tree.root, st);
        while (!st.isEmpty()){
            current = st.pop();
            if (!st.isEmpty() && current.right == st.peek()){
                st.pop();
                st.push(current);
                current = current.right;
            } else {
                System.out.print(current.data + " ");
                current = null;
            }
            if (current != null)
                st = pushNodesInStack(current, st);
        }
        System.out.println();
    }

    private static Stack<Node> pushNodesInStack(Node node, Stack<Node> st)
    {
        while(node != null ){
            if (node.right != null){
                st.push(node.right);
            }
            st.push(node);
            node = node.left;
        }
        return st;
    }
}
