package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class PrintNodesAtAGivenLevel {

    public static void main(String[] args) {
        printNodesAtGivenLevel(BinaryTree.getMockBinaryTree(), 1);
        printNodesAtGivenLevel(BinaryTree.getMockBinaryTree(), 2);
        printNodesAtGivenLevel(BinaryTree.getMockBinaryTree(), 3);
        printNodesAtGivenLevel(BinaryTree.getMockBinaryTree(), 4);
    }

    public static void printNodesAtGivenLevel(BinaryTree tree, int givenLevel)
    {
        printNodesAtGivenLevelRecursive(tree.root, 1, givenLevel);
        System.out.println();
    }

    public static void printNodesAtGivenLevelRecursive(Node node, int level, int givenLevel)
    {
        if (node == null)
            return;
        if (level == givenLevel)
            System.out.print(node.data + " ");
        printNodesAtGivenLevelRecursive(node.left, level + 1, givenLevel);
        printNodesAtGivenLevelRecursive(node.right, level + 1, givenLevel);
    }
}
