package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Misc.ParentOfNode;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

public class InOrderPredecessor {

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        printPreOrderPredecessor(tree, tree.root);
        printPreOrderPredecessor(tree, tree.root.left);
        printPreOrderPredecessor(tree, tree.root.right);
        printPreOrderPredecessor(tree, tree.root.left.left);
        printPreOrderPredecessor(tree, tree.root.left.right);
    }
    public static void printPreOrderPredecessor(BinaryTree tree, Node searchNode)
    {
        Node n = getInOrderPredecessorOfNode(tree, searchNode);
        if (n == null){
            System.out.println("No Inorder predecessor found for node " +searchNode.data + "!");
            return;
        }
        System.out.println("Inorder predecessor of " + searchNode.data + " is " + n.data);
    }

    /**
     *
     * @param tree
     * @param searchNode
     * @return
     * CASE 1: searchNode is the leftmost node of tree
     *      result - no inorder predecessor present
     * CASE 2: left child of searchNode is not null
     *      result - Inorder predecessor is the rightmost node of searchNode's left subtree
     * CASE 3: left child of searchNode is null
     *      SUB-CASE 1: searchNode is its parent's right child
     *          result - parent node is the inorder predecessor
     *      SUB CASE 2: searchNode is its parent's left child
     *          result - If p is the parent of searchNode, then the result is the node n such that n.right = p
     *
     */
    public static Node getInOrderPredecessorOfNode(BinaryTree tree, Node searchNode)
    {
        Node leftMostNode = BinaryTreeUtils.getLeftMostNode(tree.root);
        if (leftMostNode == searchNode)
            return null;
        if (searchNode.left != null){
            return BinaryTreeUtils.getRightMostNode(searchNode.left);
        }
        Node parent = ParentOfNode.findParentOfNode(tree, searchNode.data);
        if (parent == null)
            return null;
        if (parent.right == searchNode)
            return parent;
        return findParentForNode(tree.root, searchNode);
    }

    //find parent p for node x such that p.right = x
    private static Node findParentForNode(Node node, Node x)
    {
        if (node == null)
            return null;
        if (node.right == x)
            return node;
        Node left = findParentForNode(node.left, x);
        return left != null ? left : findParentForNode(node.right, x);
    }
}
