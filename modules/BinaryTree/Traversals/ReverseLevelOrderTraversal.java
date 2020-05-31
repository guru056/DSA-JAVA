package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Misc.HeightOfBinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

//    https://www.geeksforgeeks.org/reverse-level-order-traversal/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        printReverseLevelOrderTraversalIterative(tree);
        printReverseLevelOrderTraversalIterativeV2(tree);
    }

    public static void printReverseLevelOrderTraversal(BinaryTree tree)
    {
        int height = HeightOfBinaryTree.heightOfBinaryTree(tree);
        boolean reverse = true;
        for (int i = height; i >= 1; i--){
            printGivenLevel(tree.root, i);
        }
        System.out.println();
    }

    public static void printGivenLevel(Node node, int level)
    {
        if (node == null)
            return;
        if (level == 1){
            System.out.print(node.data + " ");
            return;
        }
        printGivenLevel(node.left, level - 1);
        printGivenLevel(node.right, level - 1);
    }

    public static void printReverseLevelOrderTraversalIterative(BinaryTree tree){
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> st = new Stack<Node>();

        queue.add(tree.root);
        st.push(tree.root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.right != null){
                queue.add(node.right);
                st.push(node.right);
            }
            if (node.left != null){
                queue.add(node.left);
                st.push(node.left);
            }
        }
        while (!st.isEmpty()){
            Node node = st.pop();
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public static void printReverseLevelOrderTraversalIterativeV2(BinaryTree tree){
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> st = new Stack<Node>();

        queue.add(tree.root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            st.push(node);
            if (node.right != null){
                queue.add(node.right);
            }
            if (node.left != null){
                queue.add(node.left);
            }
        }
        while (!st.isEmpty()){
            Node node = st.pop();
            System.out.print(node.data + " ");
        }
        System.out.println();
    }
}
