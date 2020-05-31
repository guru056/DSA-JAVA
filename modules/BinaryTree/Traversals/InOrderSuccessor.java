package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.Stack;

class PreviousNode{
    Node pNode;
    public PreviousNode(){
        pNode = null;
    }
}

public class InOrderSuccessor {

//    https://www.geeksforgeeks.org/inorder-succesor-node-binary-tree/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        tree.root.right.right = new Node(6);
        printInOrderSuccessor(tree, tree.root.right);
        printInOrderSuccessor(tree, tree.root.left.left);
        printInOrderSuccessor(tree, tree.root.right.right);
    }

    public static void printInOrderSuccessor(BinaryTree tree, Node x)
    {
//        Node successor = getInOrderSuccessor(tree, x);
//        Node successor = getInOrderSuccessorUsingStack(tree, x);
        Node successor = getInOrderSuccessorRecursiveUtil(tree, x);
        if (successor == null){
            System.out.println("No Inorder successor present for the given node");
            return;
        }
        System.out.println("Inorder Successor of node " + x.data + " is : " + successor.data);
    }

    public static Node getInOrderSuccessor(BinaryTree tree, Node x)
    {
        if (x.right != null){
            return BinaryTreeUtils.getLeftMostNode(x.right);
        }
        Node rightMostNode = BinaryTreeUtils.getRightMostNode(tree.root);
        if (rightMostNode == x)
            return null;
        return findParentForNode(tree.root, x);
    }

    //find parent p for node x such that p.left = x
    private static Node findParentForNode(Node node, Node x)
    {
        if (node == null)
            return null;
        if (node.left == x)
            return node;
        Node left = findParentForNode(node.left, x);
        return left != null ? left : findParentForNode(node.right, x);
    }

    public static Node getInOrderSuccessorUsingStack(BinaryTree tree, Node x)
    {
        Stack<Node> st = new Stack<>();
        st = BinaryTreeUtils.pushLeftNodesInStack(tree.root, st);

        while (!st.isEmpty()){
            Node node = st.pop();
            if (node.right != null){
                st = BinaryTreeUtils.pushLeftNodesInStack(node.right, st);
            }
            if (node == x && !st.isEmpty()){
                return st.peek();
            }
        }
        return null;
    }

    //reverse inorder traversal and keep track of the current visited node
    public static Node getInOrderSuccessorRecursive(Node node, Node x, PreviousNode prev)
    {
        if (node == null)
            return null;
        Node right = getInOrderSuccessorRecursive(node.right, x, prev);
        if (right != null)
            return right;
        if (node == x)
            return prev.pNode;
        prev.pNode = node;

        return getInOrderSuccessorRecursive(node.left, x, prev);
    }

    public static Node getInOrderSuccessorRecursiveUtil(BinaryTree tree, Node x)
    {
        return getInOrderSuccessorRecursive(tree.root, x, new PreviousNode());
    }
}
