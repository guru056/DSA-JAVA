package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-deepest-node-binary-tree/
public class DeepestNodeInBinaryTree {
    static int maxLevel = 0;
    static Node deepestNode = null;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        BinaryTree tree = new BinaryTree();
        tree.root = root;
        printDeepestNode(tree);
        printDeepestNode(BinaryTree.getMockBinaryTree());
        printDeepestNode(BinaryTree.getMockBinaryTreeV2());
        printDeepestNode(BinaryTree.getMockBinaryTreeV3());
    }

    public static void printDeepestNode(BinaryTree tree)
    {
        Node resultNode = getDeepestNodeRecursive(tree);
        if (resultNode == null){
            System.out.println("Invalid input");
        } else {
            System.out.println(resultNode.data);
        }
        deepestNode = null;
        maxLevel = 0;
        resultNode = getDeepestNodeIterative(tree);
        if (resultNode == null){
            System.out.println("Invalid input");
        } else {
            System.out.println(resultNode.data);
        }
        int height = HeightOfBinaryTree.heightOfBinaryTree(tree);
        PrintNodesAtAGivenLevel.printNodesAtGivenLevel(tree, height);
    }

    public static Node getDeepestNodeRecursive(BinaryTree tree)
    {
        setDeepestNodeRecursive(tree.root, 0);
        return deepestNode;
    }

    public static void setDeepestNodeRecursive(Node node, int level)
    {
        if (node == null)
            return ;
        if (level > maxLevel){
            maxLevel = level;
            deepestNode = node;
        }
        setDeepestNodeRecursive(node.left, level + 1);
        setDeepestNodeRecursive(node.right, level + 1);
    }

    public static Node getDeepestNodeIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return node;
    }
}
