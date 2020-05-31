package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class ParentOfNode {

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        printParentOfNode(tree, 1);
        printParentOfNode(tree, 2);
        printParentOfNode(tree, 3);
        printParentOfNode(tree, 4);
        printParentOfNode(tree, 5);
        printParentOfNode(tree, 6);
    }

    public static void printParentOfNode(BinaryTree tree, int searchNode)
    {
        if (tree.root.data == searchNode){
            System.out.println("No parent for root node");
            return;
        }
        Node n = findParentOfNode(tree, searchNode);
        if (n == null){
            System.out.println("Node not found");
            return;
        }
        System.out.println("Parent of node " + searchNode + " is : " + n.data);
    }
    public static Node findParentOfNode(BinaryTree tree, int searchNode)
    {
        return parentOfNodeRecursive(tree.root, searchNode);
    }

    public static Node parentOfNodeRecursive(Node node, int searchNode)
    {
        if (node == null)
            return null;
        if (( node.left != null && node.left.data == searchNode) || (node.right != null && node.right.data == searchNode))
            return node;
        Node left = parentOfNodeRecursive(node.left, searchNode);
        if (left != null)
            return left;
        Node right = parentOfNodeRecursive(node.right, searchNode);
        return right;
    }
}
