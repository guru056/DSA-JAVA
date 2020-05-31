package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.Stack;

public class IterativePreOrderTraversal {
//    https://www.geeksforgeeks.org/iterative-preorder-traversal/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        iterativePreOrderTraversal(tree);
        iterativePreOrderTraversalV2(tree);
    }

    public static void iterativePreOrderTraversal(BinaryTree tree)
    {
        Stack<Node> st  = new Stack<Node>();
        st.add(tree.root);

        while (!st.isEmpty()){
            Node node = st.pop();
            System.out.print(node.data + " ");

            if (node.right != null){
                st.push(node.right);
            }
            if (node.left != null){
                st.push(node.left);
            }
        }
        System.out.println();
    }

    public static void iterativePreOrderTraversalV2(BinaryTree tree)
    {
        Stack<Node> st  = new Stack<Node>();
        Node current = tree.root;

        while (!st.isEmpty() || current != null){
            while (current != null){
                System.out.print(current.data + " ");
                if (current.right != null)
                    st.push(current.right);
                current = current.left;
            }
            if (!st.isEmpty()){
                current = st.pop();
            }
        }
    }
}
