package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.Stack;

public class NthNodeInOrderTraversal {
//    https://www.geeksforgeeks.org/find-n-th-node-inorder-traversal/
    static int count = 0;
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        printNthNodeInOrderTraversal(tree,1);
        printNthNodeInOrderTraversal(tree,2);
        printNthNodeInOrderTraversal(tree,3);
        printNthNodeInOrderTraversal(tree,4);
        printNthNodeInOrderTraversal(tree,5);
        printNthNodeInOrderTraversal(tree,6);
    }

    public static void printNthNodeInOrderTraversal(BinaryTree tree, int n )
    {
        Node nthNode = getNthNodeInOrderTraversalIterative(tree, n);
//        Node nthNode = getNthNodeInOrderTraversalRecursive(tree.root, n);
        if (nthNode == null){
            System.out.println("Invalid value of n provided");
            return;
        }
        System.out.println("Node no " + n + " in Inorder traversal : "  + nthNode.data);
    }

    public static Node getNthNodeInOrderTraversalRecursive(Node node, int n)
    {
        if (node == null)
            return null;
        Node left = getNthNodeInOrderTraversalRecursive(node.left, n);
        if (left != null) return left;
        count++;
        if ( count == n){
            return node;
        }
        return getNthNodeInOrderTraversalRecursive(node.right, n );
    }

    public static Node getNthNodeInOrderTraversalIterative(BinaryTree tree, int n )
    {
        Stack<Node> st = new Stack<>();
        st = BinaryTreeUtils.pushLeftNodesInStack(tree.root, st);
        int count = 0;
        while (!st.isEmpty()){
            count++;
            Node node = st.pop();
            if (count == n) return node;
            if (node.right != null){
                st = BinaryTreeUtils.pushLeftNodesInStack(node.right, st);
            }
        }
        return null;
    }

}
