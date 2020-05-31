package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class BinaryTreeTraversals {

    //    https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        preOrderTraversal(tree);
        inOrderTraversal(tree);
        postOrderTraversal(tree);
    }

    public static void preOrderTraversal(BinaryTree tree)
    {
        preOrderTraversalRecursive(tree.root);
        System.out.println();
    }

    public static void preOrderTraversalRecursive(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraversalRecursive(node.left);
        preOrderTraversalRecursive(node.right);
    }

    public static void inOrderTraversal(BinaryTree tree)
    {
        inOrderTraversalRecursive(tree.root);
        System.out.println();
    }

    public static void inOrderTraversalRecursive(Node node)
    {
        if (node == null)
            return;
        inOrderTraversalRecursive(node.left);
        System.out.print(node.data + " ");
        inOrderTraversalRecursive(node.right);
    }

    public static void postOrderTraversal(BinaryTree tree)
    {
        postOrderTraversalRecursive(tree.root);
        System.out.println();
    }

    public static void postOrderTraversalRecursive(Node node)
    {
        if (node == null)
            return;
        postOrderTraversalRecursive(node.left);
        postOrderTraversalRecursive(node.right);
        System.out.print(node.data + " ");
    }

}
