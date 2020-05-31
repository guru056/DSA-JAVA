package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/count-half-nodes-in-a-binary-tree-iterative-and-recursive/
public class CountHalfNodesInBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        tree.root.left.left.left = new Node(6);
        printCountOfHalfNodes(tree);

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(2);
        tree1.root.left = new Node(7);
        tree1.root.right = new Node(5);
        tree1.root.left.right = new Node(6);
        tree1.root.left.right.left = new Node(1);
        tree1.root.left.right.right = new Node(11);
        tree1.root.right.right = new Node(9);
        tree1.root.right.right.left = new Node(4);
        printCountOfHalfNodes(tree1);

    }
    public static void printCountOfHalfNodes(BinaryTree tree)
    {
        System.out.println("Count Of Half Nodes : " + countHalfNodes(tree));
        System.out.println("Count Of Half Nodes : " + countHalfNodesIterative(tree));
        System.out.println();
    }

    public static int countHalfNodes(BinaryTree tree)
    {
        return countHalfNodesRecursive(tree.root);
    }

    //use PostOrder traversal
    public static int countHalfNodesRecursive(Node node)
    {
        if (node == null)
            return 0;
        int left    = countHalfNodesRecursive(node.left);
        int right   = countHalfNodesRecursive(node.right);
        int res     = BinaryTreeUtils.isHalfNode(node) ? 1 : 0;
        return res + left + right;
    }

    public static int countHalfNodesIterative(BinaryTree tree)
    {
        if (tree.root == null)
            return 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int count = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (BinaryTreeUtils.isHalfNode(node))
                count++;
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return count;
    }
}
