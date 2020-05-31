package BinaryTree.LeastCommonAncestor;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

//https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
public class MaximumDistanceBetweenNodeAndItsAncestors {
    static int maxDiff = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // https://media.geeksforgeeks.org/wp-content/cdn-uploads/tree_123.jpg
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);

        tree.root.right = new Node(10);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);

        printMaxDiff(tree);
    }

    public static void printMaxDiff(BinaryTree tree)
    {
        System.out.println(getMaxDiff(tree));
    }
    public static int getMaxDiff(BinaryTree tree)
    {
        maxDiff = Integer.MIN_VALUE;
         maxDiffRecursive(tree.root);
         return maxDiff;
    }

    public static int maxDiffRecursive(Node node)
    {
        if (node == null)
            return Integer.MAX_VALUE;
        if (BinaryTreeUtils.isLeafNode(node))
            return node.data;
        int left = maxDiffRecursive(node.left);
        int right = maxDiffRecursive(node.right);

        maxDiff = Math.max(maxDiff, node.data - Math.min(left, right));
        return Math.min(node.data, Math.min(left, right));
    }

}
