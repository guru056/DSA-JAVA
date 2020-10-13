package BinaryTree.LeastCommonAncestor;

import BinaryTree.BinaryTree;
import BinaryTree.CheckingAndPrinting.PrintPathFromRootToGivenNode;
import BinaryTree.Node;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class LeastCommonAncestorInBinaryTree {

    static boolean firstNodePresent = false;
    static boolean secondNodePresent = false;

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTreeV2();
        printLCA(tree, 4,16);
    }
    public static void printLCA(BinaryTree tree, int n1, int n2)
    {
        Node lca = findLCA(tree, n1, n2);
        if (lca == null){
            System.out.println("LCA NOT FOUND");
        } else {
            System.out.println("LCA (" + n1 + " , " + n2 + " ) = " + lca.data);
        }
        lca = findLCARecursiveUtil(tree, n1, n2);
        if (lca == null){
            System.out.println("LCA NOT FOUND");
        } else {
            System.out.println("LCA (" + n1 + " , " + n2 + " ) = " + lca.data);
        }
        lca = findLCARecursiveUtilV2(tree, n1, n2);
        if (lca == null){
            System.out.println("LCA NOT FOUND");
        } else {
            System.out.println("LCA (" + n1 + " , " + n2 + " ) = " + lca.data);
        }
        System.out.println();
    }

    public static Node findLCA(BinaryTree tree, int n1, int n2)
    {
        ArrayList<Node> path1 = PrintPathFromRootToGivenNode.getPathFromRootToNode(tree, n1);
        ArrayList<Node> path2 = PrintPathFromRootToGivenNode.getPathFromRootToNode(tree, n2);
        if (path1.isEmpty()){
            System.out.println(n1 + " is not present in tree");
            return null;
        }
        if (path2.isEmpty()){
            System.out.println(n2 + " is not present in tree");
            return null;
        }
        int i = 0;
        for ( i =0; i < path1.size() && i < path2.size(); i++){
            if (path1.get(i).data != path2.get(i).data)
                break;
        }
        return path1.get(i - 1);
    }

    public static Node findLCARecursiveUtilV2(BinaryTree tree, int n1, int n2)
    {
        firstNodePresent = false;
        secondNodePresent = false;
        Node lca = findLCARecursiveV2(tree.root, n1, n2);
        if(firstNodePresent && secondNodePresent)
            return lca;
        if (!firstNodePresent)
            System.out.println(n1 + " is not present");
        if (!secondNodePresent)
            System.out.println(n2 + " is not present");
        return null;
    }

    public static Node findLCARecursiveUtil(BinaryTree tree, int n1, int n2)
    {
        return findLCARecursive(tree.root, n1, n2);
    }

    /**
     * If one node is found, we dont traverse the tree in this approach.
     * @param node
     * @param n1
     * @param n2
     * @return
     */
    public static Node findLCARecursive(Node node, int n1, int n2)
    {
        if (node == null)
            return null;
        if (node.data == n1 || node.data == n2)
            return node;
        Node left = findLCARecursive(node.left, n1, n2);
        Node right = findLCARecursive(node.right, n1, n2);

        if (left != null && right != null)
            return node;
        return left != null ? left : right;
    }

    public static Node findLCARecursiveV2(Node node, int n1, int n2)
    {
        if (node == null)
            return null;
        if (node.data == n1)
            firstNodePresent = true;

        if (node.data == n2)
            secondNodePresent = true;

        Node left = findLCARecursiveV2(node.left, n1, n2);
        Node right = findLCARecursiveV2(node.right, n1, n2);

        if (node.data == n1 || node.data == n2)
            return node;
        if (left != null && right != null)
            return node;
        return left != null ? left : right;
    }

}
