package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//https://www.geeksforgeeks.org/zigzag-tree-traversal/
public class ZigZagTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);

        printZigZagTraversal(tree);
    }

    public static void printZigZagTraversal(BinaryTree tree) {
        List<List<Integer>> resultList = zigzagLevelOrder(tree.root);
        System.out.println(resultList);
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) return resultList;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.add(root);
        while (!st1.isEmpty() || !st2.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            while (!st1.isEmpty()) {
                Node node = st1.pop();
                list1.add(node.data);
                if (node.left != null) {
                    st2.push(node.left);
                }
                if (node.right != null) {
                    st2.push(node.right);
                }
            }
            if (list1.size() > 0)
                resultList.add(list1);
            while (!st2.isEmpty()) {
                Node node = st2.pop();
                list2.add(node.data);
                if (node.right != null) {
                    st1.push(node.right);
                }
                if (node.left != null) {
                    st1.push(node.left);
                }
            }
            if (list2.size() > 0)
                resultList.add(list2);

        }
        return resultList;
    }
}
