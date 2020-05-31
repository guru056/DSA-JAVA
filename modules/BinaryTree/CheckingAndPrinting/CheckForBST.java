package BinaryTree.CheckingAndPrinting;

import BinaryTree.Node;

public class CheckForBST {
//    https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    public static boolean checkForBST(Node node, int min, int max)
    {
        if (node == null)
            return true;
        if (node.data > max || node.data < min)
            return false;

        return  checkForBST(node.left, min, node.data - 1) &&
                checkForBST(node.right, node.data + 1, max) ;
    }

    public static boolean checkForBSTV2(Node node, int min, int max)
    {
        if (node == null)
            return true;
        if (node.data >= max || node.data <= min)
            return false;

        return  checkForBSTV2(node.left, min, node.data ) &&
                checkForBSTV2(node.right, node.data , max) ;
    }
}
