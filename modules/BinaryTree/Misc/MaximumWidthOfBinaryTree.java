package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        printMaxWidth(BinaryTree.getMockBinaryTree());
        printMaxWidth(BinaryTree.getMockBinaryTreeV2());
        printMaxWidth(BinaryTree.getMockBinaryTreeV3());
    }

    public static void printMaxWidth(BinaryTree tree)
    {
        System.out.println("Maximum Width: " + maxWidthIterative(tree));
        System.out.println("Maximum Width: " + maxWidthV2(tree));
        System.out.println();
    }

    public static int maxWidthV2(BinaryTree tree)
    {
        int height = HeightOfBinaryTree.heightOfBinaryTree(tree);
        int maxWidth = 0;
        for (int i = 1; i <= height; i++){
            maxWidth = Math.max(maxWidth, widthOfGivenLevelRecursive(tree.root, i));
        }
        return maxWidth;
    }

    public static int widthOfGivenLevelRecursive(Node node, int level)
    {
        if (node == null)
            return 0;
        if (level == 1)
            return 1;
        return widthOfGivenLevelRecursive(node.left, level - 1) + widthOfGivenLevelRecursive(node.right, level - 1);
    }

    public static int maxWidthIterative(BinaryTree tree)
    {
        if (tree.root == null)
            return 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int maxWidth = 0 ;
        int nodeCount ;

        while (!queue.isEmpty()){
            nodeCount = queue.size();
            maxWidth = Math.max(maxWidth, nodeCount);
            while (nodeCount-- > 0){
                Node node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return maxWidth;
    }
}
