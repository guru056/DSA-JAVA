package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.Stack;

public class IterativeInorderTraversal {

    //    https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        inOrderTraversal(tree);
    }

    public static void inOrderTraversal(BinaryTree tree)
    {
        Node root = tree.root;
        Stack<Node> st = new Stack<Node>();
        Node current = root;
        st = BinaryTreeUtils.pushLeftNodesInStack(current, st);

        while (!st.isEmpty()){
            Node temp = st.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null){
                current = temp.right;
                st = BinaryTreeUtils.pushLeftNodesInStack(current, st);
            }
        }
    }
}
