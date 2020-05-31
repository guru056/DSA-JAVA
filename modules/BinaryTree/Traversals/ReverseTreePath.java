package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.HashMap;
//    https://www.geeksforgeeks.org/reverse-tree-path/
public class ReverseTreePath {
    static int nextPos = 0;
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root               = new Node(7);
        tree.root.left          = new Node(6);
        tree.root.right         = new Node(5);
        tree.root.left.left     = new Node(4);
        tree.root.left.right    = new Node(3);
        tree.root.right.left    = new Node(2);
        tree.root.right.right    = new Node(1);

//        reverseTreePath(tree, 4);
        reverseTreePath(tree, 2);
    }
    public static void reverseTreePath(BinaryTree tree, int searchNode)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        Node n = reverseTreePathRecursive(tree.root, searchNode, 0, map);
        if (n == null){
            System.out.println("Node not found!");
            return;
        }
        BinaryTreeTraversals.inOrderTraversal(tree);
    }

    public static Node reverseTreePathRecursive(Node node, int searchNode, int level, HashMap<Integer, Integer> map)
    {
        if (node == null)
            return null;
        if (node.data == searchNode){
            map.put(level, node.data);
            node.data = map.get(nextPos++);
            return node;
        }
        map.put(level, node.data);
        Node left,right = null;
        left = reverseTreePathRecursive(node.left, searchNode, level + 1, map);
        if (left == null){
            right = reverseTreePathRecursive(node.right, searchNode, level + 1, map);
        }
        if (left != null || right != null){
            node.data = map.get(nextPos++);
        }
        return left != null ? left : right;
    }
}
