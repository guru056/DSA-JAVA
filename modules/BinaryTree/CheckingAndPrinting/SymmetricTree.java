package BinaryTree.CheckingAndPrinting;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
//https://www.geeksforgeeks.org/check-symmetric-binary-tree-iterative-approach/
public class SymmetricTree {
    static int maxDiameter = Integer.MIN_VALUE;
    public static boolean checkSymmetricTree(BinaryTree tree)
    {
        if (tree == null)
            return true;
        return MirrorTrees.checkMirrorTrees(tree.root.left, tree.root.right);
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
