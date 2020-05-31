package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
//    https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
//    https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
public class DiameterOfBinaryTree {
    static int maxDiameter = Integer.MIN_VALUE;
    public static void main(String[] args) {
        System.out.println(getDiameterOfBinaryTree(BinaryTree.getMockBinaryTree()));
        System.out.println(getDiameterOfBinaryTree(BinaryTree.getMockBinaryTreeV2()));
    }

    public static int getDiameterOfBinaryTree(BinaryTree tree)
    {
        return diameter(tree.root);
    }

    public static int diameter(Node node)
    {
        if (node == null)
            return 0;
        int lHeight = diameter(node.left);
        int rHeight = diameter(node.right);

        maxDiameter = Math.max(maxDiameter, 1 + lHeight + rHeight);
        return 1 + Math.max(lHeight, rHeight);
    }
}
