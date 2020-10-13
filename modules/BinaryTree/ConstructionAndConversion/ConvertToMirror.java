package BinaryTree.ConstructionAndConversion;

import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
//https://leetcode.com/problems/invert-binary-tree
public class ConvertToMirror {

    public static Node convertToMirrorRecursive(Node node) { // 0ms
        if (node == null || BinaryTreeUtils.isLeafNode(node))
            return node;

        Node left = convertToMirrorRecursive(node.left);
        Node right = convertToMirrorRecursive(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    public static Node convertToMirrorIterative(Node root) { // 0ms
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null && node.right != null) {
                Node left = node.left;
                Node right = node.right;
                node.left = right;
                node.right = left;
            } else if (node.left != null) {
                node.right = node.left;
                node.left = null;
            } else {
                node.left = node.right;
                node.right = null;
            }

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return root;
    }
}
