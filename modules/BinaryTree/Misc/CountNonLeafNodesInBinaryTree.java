package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/count-non-leaf-nodes-binary-tree/
public class CountNonLeafNodesInBinaryTree {

    public static void main(String[] args) {
        printCountOfNonLeafNodes(BinaryTree.getMockBinaryTree());
        printCountOfNonLeafNodes(BinaryTree.getMockBinaryTreeV2());
        printCountOfNonLeafNodes(BinaryTree.getMockBinaryTreeV3());
    }

    public static void printCountOfNonLeafNodes(BinaryTree tree)
    {
        System.out.println("Count Of Non Leaf Nodes : " + countNonLeafNodes(tree));
        System.out.println("Count Of Non Leaf Nodes : " + countNonLeafNodesIterative(tree));
        System.out.println();
    }

    public static int countNonLeafNodes(BinaryTree tree)
    {
        return countNonLeafNodesRecursive(tree.root);
    }

    public static int countNonLeafNodesRecursive(Node node)
    {
        if (node == null || BinaryTreeUtils.isLeafNode(node))
            return 0;
        return 1 + countNonLeafNodesRecursive(node.left) + countNonLeafNodesRecursive(node.right);
    }

    public static int countNonLeafNodesIterative(BinaryTree tree)
    {
        if (tree.root == null)
            return 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int count = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (!BinaryTreeUtils.isLeafNode(node))
                count++;
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return count;
    }
}
