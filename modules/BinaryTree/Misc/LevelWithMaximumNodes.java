package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/level-maximum-number-nodes/
public class LevelWithMaximumNodes {

    public static void main(String[] args) {
        printLevelWithMaxWidth(BinaryTree.getMockBinaryTree());
        printLevelWithMaxWidth(BinaryTree.getMockBinaryTreeV2());
        printLevelWithMaxWidth(BinaryTree.getMockBinaryTreeV3());
    }

    public static void printLevelWithMaxWidth(BinaryTree tree)
    {
        System.out.println("Level With Maximum Width: " + levelWithMaxWidthIterative(tree));
        System.out.println("Level With Maximum Width: " + levelWithMaxWidthV2(tree));
        System.out.println();
    }

    public static int levelWithMaxWidthV2(BinaryTree tree)
    {
        int height = HeightOfBinaryTree.heightOfBinaryTree(tree);
        int maxWidth = 0;
        int levelWithMaxWidth = 0;
        for (int i = 1; i <= height; i++){
            int width = widthOfGivenLevelRecursive(tree.root, i);
            if (width > maxWidth){
                maxWidth = width;
                levelWithMaxWidth = i;
            }
        }
        return levelWithMaxWidth;
    }

    public static int widthOfGivenLevelRecursive(Node node, int level)
    {
        if (node == null)
            return 0;
        if (level == 1)
            return 1;
        return widthOfGivenLevelRecursive(node.left, level - 1) + widthOfGivenLevelRecursive(node.right, level - 1);
    }

    public static int levelWithMaxWidthIterative(BinaryTree tree)
    {
        if (tree.root == null)
            return 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int maxWidth = 0 ;
        int nodeCount ;
        int level = 0;
        int levelWithMaxWidth = 0;

        while (!queue.isEmpty()){
            nodeCount = queue.size();
            level++;
            if (nodeCount > maxWidth){
                maxWidth = nodeCount;
                levelWithMaxWidth = level;
            }
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
        return levelWithMaxWidth;
    }
}
