package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {
//    https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
//    https://www.geeksforgeeks.org/write-program-calculate-size-tree-iterative/
    public static void main(String[] args) {
        printSizeOfBinaryTree(BinaryTree.getMockBinaryTree());
        printSizeOfBinaryTree(BinaryTree.getMockBinaryTreeV2());
    }
    public static void printSizeOfBinaryTree(BinaryTree tree)
    {
        System.out.println(sizeOfBinaryTreeRecursive(tree.root));
        System.out.println(sizeOfBinaryTreeIterative(tree));
        System.out.println();
    }

    public static int sizeOfBinaryTreeRecursive(Node node)
    {
        if (node == null)
            return 0;
        return 1 + sizeOfBinaryTreeRecursive(node.left) + sizeOfBinaryTreeRecursive(node.right);
    }

    public static int sizeOfBinaryTreeIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int size = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            size++;
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return size;
    }
}
