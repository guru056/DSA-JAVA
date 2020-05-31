package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

//https://www.geeksforgeeks.org/get-maximum-left-node-binary-tree/
public class MaximumLeftNodeInBinaryTree {
    static int maxLeftNode = Integer.MIN_VALUE;

    public static void main(String[] args) {
        printMaximumLeftNode(BinaryTree.getMockBinaryTree());

        BinaryTree tree1 = new BinaryTree();
        Node root       = new Node(7);
        root.left       = new Node(6);
        root.right      = new Node(5);
        root.left.left  = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right= new Node(1);
        tree1.root = root;
        printMaximumLeftNode(tree1);
    }

    public static void printMaximumLeftNode(BinaryTree tree)
    {
        String toPrint = "Maximum Left Node : ";
        System.out.println(toPrint + getMaximumLeftNode(tree));
        maxLeftNode = Integer.MIN_VALUE;
        System.out.println(toPrint + getMaximumLeafNodeRecursiveUtil(tree));
        System.out.println();
    }

    public static int getMaximumLeftNode(BinaryTree tree)
    {
        setMaximumLeftNodeRecursive(tree.root, false);
        return maxLeftNode;
    }

    public static void setMaximumLeftNodeRecursive(Node node, boolean isLeft)
    {
        if (node == null)
            return ;
        if (isLeft && node.data > maxLeftNode)
            maxLeftNode = node.data;
        setMaximumLeftNodeRecursive(node.left, true);
        setMaximumLeftNodeRecursive(node.right, false);
    }


    public static int getMaximumLeafNodeRecursiveUtil(BinaryTree tree)
    {
        return getMaximumLeafNodeRecursiveV2(tree.root, false);
    }

    //use any of the traversals
    public static int getMaximumLeafNodeRecursiveV2(Node node, boolean isLeft)
    {
        if (node == null)
            return Integer.MIN_VALUE;
        int left = getMaximumLeafNodeRecursiveV2(node.left, true);
        int right = getMaximumLeafNodeRecursiveV2(node.right, false);
        int res = isLeft ? node.data : Integer.MIN_VALUE;
        return Math.max(res, Math.max(left,right));
    }
}
