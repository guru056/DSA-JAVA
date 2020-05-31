package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/deepest-right-leaf-node-binary-tree-iterative-approach/
public class DeepestRightLeafNodeInBinaryTree {
    static int maxLevel = 0;
    static Node deepestRightLeafNode = null;

    public static void main(String[] args) {
        printDeepestRightLeafNode(BinaryTree.getMockBinaryTree());
        printDeepestRightLeafNode(BinaryTree.getMockBinaryTreeV2());
        printDeepestRightLeafNode(BinaryTree.getMockBinaryTreeV3());
    }

    public static void printDeepestRightLeafNode(BinaryTree tree)
    {
        Node resultNode = getDeepestRightLeafNodeRecursive(tree);
        if (resultNode == null){
            System.out.println("Invalid input");
        } else {
            System.out.println(resultNode.data);
        }
        deepestRightLeafNode = null;
        maxLevel = 0;
        resultNode = getDeepestRightLeafNodeIterative(tree);
        if (resultNode == null){
            System.out.println("Invalid input");
        } else {
            System.out.println(resultNode.data);
        }
    }

    public static Node getDeepestRightLeafNodeRecursive(BinaryTree tree)
    {
        setDeepestRightLeafNodeRecursive(tree.root, 0 , false);
        return deepestRightLeafNode;
    }

    public static void setDeepestRightLeafNodeRecursive(Node node, int level, boolean isRight)
    {
        if (node == null)
            return ;
        if (isRight && BinaryTreeUtils.isLeafNode(node) && level > maxLevel){
            maxLevel = level;
            deepestRightLeafNode = node;
        }
        setDeepestRightLeafNodeRecursive(node.left, level + 1 , false);
        setDeepestRightLeafNodeRecursive(node.right, level + 1 , true);
    }

    public static Node getDeepestRightLeafNodeIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        Node result = null;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
                if (BinaryTreeUtils.isLeafNode(node.right)){
                    result = node.right;
                }
            }
        }

        return result;
    }
}
