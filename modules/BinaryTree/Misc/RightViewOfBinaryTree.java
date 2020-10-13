package BinaryTree.Misc;

import BinaryTree.BinaryTree;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
//https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
//https://www.geeksforgeeks.org/right-view-binary-tree-using-queue/
public class RightViewOfBinaryTree {
    static int maxLevel = 0;
    public static void main(String[] args) {
        printRightView(BinaryTree.getMockBinaryTree());
        printRightViewRecursiveUtil(BinaryTree.getMockBinaryTree());
        printRightView(BinaryTree.getMockBinaryTreeV2());
        printRightViewRecursiveUtil(BinaryTree.getMockBinaryTreeV2());
        printRightView(BinaryTree.getMockBinaryTreeV3());
        printRightViewRecursiveUtil(BinaryTree.getMockBinaryTreeV3());
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        tree.root.right.left = new Node(6);
        tree.root.right.left.right = new Node(7);
        printRightView(tree);
        printRightViewRecursiveUtil(tree);
    }

    public static void printRightView(BinaryTree tree)
    {
        if (tree.root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        int nodeCount = 0;
        queue.add(tree.root);
        Node node = null;

        while (!queue.isEmpty()){
            nodeCount = queue.size();
            while (nodeCount-- > 0){
                node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public static void printRightViewRecursive(Node node, int level)
    {
        if (node == null)
            return;
        if (maxLevel < level){
            System.out.print(node.data + " ");
            maxLevel = level;
        }
        printRightViewRecursive(node.right, level + 1);
        printRightViewRecursive(node.left, level + 1);
    }

    public static void printRightViewRecursiveUtil(BinaryTree tree)
    {
        printRightViewRecursive(tree.root, 1);
        System.out.println();
        maxLevel = 0;
    }
}
