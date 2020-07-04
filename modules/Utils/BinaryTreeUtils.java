package Utils;

import BinaryTree.Node;

import java.util.Stack;

public class BinaryTreeUtils {

    public static Stack<Node> pushLeftNodesInStack(Node current, Stack<Node> st)
    {
        while (current != null){
            st.push(current);
            current = current.left;
        }
        return st;
    }

    public static Node getLeftMostNode(Node node)
    {
        while (node != null && node.left != null){
            node = node.left;
        }
        return node;
    }

    public static Node getRightMostNode(Node node)
    {
        while (node != null && node.right != null){
            node = node.right;
        }
        return node;
    }

    public static boolean isLeafNode(Node node)
    {
        return (node != null && node.left == null && node.right == null);
    }

    public static boolean isFullNode(Node node)
    {
        return (node != null && node.left != null && node.right != null);
    }

    public static boolean isHalfNode(Node node)
    {
        return (
                node != null &&
                        (
                            (node.left == null && node.right != null) ||
                            (node.left != null && node.right == null)
                        )
                );
    }

}
