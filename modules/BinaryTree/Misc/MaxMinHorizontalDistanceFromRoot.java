package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class MaxMinHorizontalDistanceFromRoot {
    static int maxHD = 0;
    static int minHD = 0;

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTreeV2();
        printMaxMinHorizontalDistance(tree);
        tree.root.right.left.right = new Node(10);
        tree.root.right.right.right = new Node(11);
        printMaxMinHorizontalDistance(tree);
    }

    public static void printMaxMinHorizontalDistance(BinaryTree tree)
    {
        int[] hd = setMaxMinHorizontalDistance(tree);
        System.out.println("Min horizontal distance : " + hd[0]);
        System.out.println("Max horizontal distance : " + hd[1]);
        System.out.println();
    }

    public static int[] setMaxMinHorizontalDistance(BinaryTree tree)
    {
        int[] hd = new int[2];
        setMaxMinHorizontalDistanceRecursive(tree.root, 0);
        hd[0] = minHD;
        hd[1] = maxHD;
        return hd;
    }

    public static void setMaxMinHorizontalDistanceRecursive(Node node, int hd)
    {
        if (node == null)
            return;
        if (hd < minHD)
            minHD = hd;
        if (hd > maxHD)
            maxHD = hd;

        setMaxMinHorizontalDistanceRecursive(node.left, hd - 1);
        setMaxMinHorizontalDistanceRecursive(node.right, hd + 1);
    }
}
