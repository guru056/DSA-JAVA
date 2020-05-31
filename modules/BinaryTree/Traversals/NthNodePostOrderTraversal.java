package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class NthNodePostOrderTraversal {
    static int count = 0;

//    https://www.geeksforgeeks.org/find-n-th-node-in-postorder-traversal-of-a-binary-tree/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
//        printNthNodePostOrderTraversal(tree, 1);
//        printNthNodePostOrderTraversal(tree, 2);
        printNthNodePostOrderTraversal(tree, 3);
//        printNthNodePostOrderTraversal(tree, 4);
//        printNthNodePostOrderTraversal(tree, 5);
//        printNthNodePostOrderTraversal(tree, 6);
    }

    public static void printNthNodePostOrderTraversal(BinaryTree tree, int n )
    {
        Node nthNode = getNthNodePostOrderTraversalRecursive(tree.root, n);
//        Node nthNode = getNthNodeInOrderTraversalRecursive(tree.root, n);
        if (nthNode == null){
            System.out.println("Invalid value of n provided");
            return;
        }
        System.out.println("Node no " + n + " in Inorder traversal : "  + nthNode.data);
    }

    public static Node getNthNodePostOrderTraversalRecursive(Node node, int n)
    {
        if (node == null)
            return null;
        Node left = getNthNodePostOrderTraversalRecursive(node.left, n);
        if (left != null) return left;
        Node right = getNthNodePostOrderTraversalRecursive(node.right, n);
        if (right != null) return right;
        count++;
        if ( count == n){
            return node;
        }
        return null;
    }


}
