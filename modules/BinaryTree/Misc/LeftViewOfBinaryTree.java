package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/print-left-view-binary-tree/
//https://www.geeksforgeeks.org/iterative-method-to-print-left-view-of-a-binary-tree/
public class LeftViewOfBinaryTree {
    static int maxLevel = 0;
    public static void main(String[] args) {
        printLeftView(BinaryTree.getMockBinaryTree());
        printLeftViewRecursiveUtil(BinaryTree.getMockBinaryTree());
        printLeftView(BinaryTree.getMockBinaryTreeV2());
        printLeftViewRecursiveUtil(BinaryTree.getMockBinaryTreeV2());
        printLeftView(BinaryTree.getMockBinaryTreeV3());
        printLeftViewRecursiveUtil(BinaryTree.getMockBinaryTreeV3());
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        tree.root.right.left = new Node(6);
        tree.root.right.left.right = new Node(7);
        printLeftView(tree);
        printLeftViewRecursiveUtil(tree);
    }

    public static void printLeftView(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        int nodeCount = 0;
        queue.add(tree.root);
        Node node;

        while (!queue.isEmpty()){
            nodeCount = queue.size();
//            if (nodeCount == 0)
//                break;
            System.out.print(queue.peek().data + " ");
            while (nodeCount-- > 0){
                node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        System.out.println();
    }

    public static void printLeftViewRecursive(Node node, int level)
    {
        if (node == null)
            return;
        if (maxLevel < level){
            System.out.print(node.data + " ");
            maxLevel = level;
        }
        printLeftViewRecursive(node.left, level + 1);
        printLeftViewRecursive(node.right, level + 1);
    }

    public static void printLeftViewRecursiveUtil(BinaryTree tree)
    {
        printLeftViewRecursive(tree.root, 1);
        System.out.println();
        maxLevel = 0;
    }

}
