package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        printMinimumDepth(BinaryTree.getMockBinaryTree());
        printMinimumDepth(BinaryTree.getMockBinaryTreeV2());
        printMinimumDepth(BinaryTree.getMockBinaryTreeV3());
    }

    public static void printMinimumDepth(BinaryTree tree)
    {
        System.out.println(minimumDepthRecursiveUtil(tree));
        System.out.println(minimumDepthRecursiveUtilV2(tree));
        System.out.println(minimumDepthIterative(tree));
        System.out.println();
    }

    public static int minimumDepthRecursiveUtil(BinaryTree tree)
    {
        return minimumDepthRecursive(tree.root, 1);
    }

    public static int minimumDepthRecursiveUtilV2(BinaryTree tree)
    {
        return minimumDepthRecursiveV2(tree.root, 0);
    }

    public static int minimumDepthRecursive(Node node, int level)
    {
        if (node == null)
            return 0;
        if (BinaryTreeUtils.isLeafNode(node))
            return level;
        return Math.min(
                minimumDepthRecursive(node.left,level + 1),
                minimumDepthRecursive(node.right, level + 1)
        );
    }

    public static int minimumDepthRecursiveV2(Node node, int level)
    {
        if (node == null)
            return level;
        return Math.min(
                minimumDepthRecursiveV2(node.left,level + 1),
                minimumDepthRecursiveV2(node.right, level + 1)
        );
    }

    public static int minimumDepthIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int depth = 0 ;
        int nodeCount ;

        while (!queue.isEmpty()){
            nodeCount = queue.size();
            depth++;
            while (nodeCount-- > 0){
                Node node = queue.poll();
                if (BinaryTreeUtils.isLeafNode(node))
                    return depth;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return 0;
    }
}
