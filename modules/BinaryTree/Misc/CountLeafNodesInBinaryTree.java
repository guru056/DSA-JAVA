package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/iterative-program-count-leaf-nodes-binary-tree/
//https://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
public class CountLeafNodesInBinaryTree {

    public static void main(String[] args) {
        printCountOfLeafNodes(BinaryTree.getMockBinaryTree());
        printCountOfLeafNodes(BinaryTree.getMockBinaryTreeV2());
        printCountOfLeafNodes(BinaryTree.getMockBinaryTreeV3());
    }

    public static void printCountOfLeafNodes(BinaryTree tree)
    {
        System.out.println("Count Of Leaf Nodes : " + countLeafNodes(tree));
        System.out.println("Count Of Leaf Nodes : " + countLeafNodesIterative(tree));
        System.out.println();
    }

    public static int countLeafNodes(BinaryTree tree)
    {
        return countLeafNodesRecursive(tree.root);
    }
    public static int countLeafNodesRecursive(Node node)
    {
        if (node == null)
            return 0;
        if (BinaryTreeUtils.isLeafNode(node))
            return 1;
        return countLeafNodesRecursive(node.left) + countLeafNodesRecursive(node.right);
    }

    public static int countLeafNodesIterative(BinaryTree tree)
    {
        if (tree.root == null)
            return 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int count = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (BinaryTreeUtils.isLeafNode(node))
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
