package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;
//    https://www.geeksforgeeks.org/deepest-left-leaf-node-binary-tree-iterative-approach/
//    https://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
public class DeepestLeftLeafNodeInBinaryTree {
    static int maxLevel = 0;
    static Node deepestLeftLeafNode = null;

    public static void main(String[] args) {
        printDeepestLeftLeafNode(BinaryTree.getMockBinaryTree());
        printDeepestLeftLeafNode(BinaryTree.getMockBinaryTreeV2());
        printDeepestLeftLeafNode(BinaryTree.getMockBinaryTreeV3());
    }

    public static void printDeepestLeftLeafNode(BinaryTree tree)
    {
        Node resultNode = getDeepestLeftLeafNodeRecursive(tree);
        if (resultNode == null){
            System.out.println("Invalid input");
        } else {
            System.out.println(resultNode.data);
        }
        deepestLeftLeafNode = null;
        maxLevel = 0;
        resultNode = getDeepestLeftLeafNodeIterative(tree);
        if (resultNode == null){
            System.out.println("Invalid input");
        } else {
            System.out.println(resultNode.data);
        }
    }

    public static Node getDeepestLeftLeafNodeRecursive(BinaryTree tree)
    {
        setDeepestLeftLeafNodeRecursive(tree.root, 0 , false);
        return deepestLeftLeafNode;
    }

    public static void setDeepestLeftLeafNodeRecursive(Node node, int level, boolean isLeft)
    {
        if (node == null)
            return ;
        if (isLeft && BinaryTreeUtils.isLeafNode(node) && level > maxLevel){
            maxLevel = level;
            deepestLeftLeafNode = node;
        }
        setDeepestLeftLeafNodeRecursive(node.left, level + 1 , true);
        setDeepestLeftLeafNodeRecursive(node.right, level + 1 , false);
    }

    public static Node getDeepestLeftLeafNodeIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        Node result = null;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.left != null){
                queue.add(node.left);
                if (BinaryTreeUtils.isLeafNode(node.left)){
                    result = node.left;
                }
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

        return result;
    }

}
