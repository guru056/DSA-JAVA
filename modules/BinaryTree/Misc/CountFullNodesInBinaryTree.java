package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/count-full-nodes-binary-tree-iterative-recursive/
public class CountFullNodesInBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        tree.root.left.left.left = new Node(6);
        printCountOfFullNodes(tree);

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(2);
        tree1.root.left = new Node(7);
        tree1.root.right = new Node(5);
        tree1.root.left.right = new Node(6);
        tree1.root.left.right.left = new Node(1);
        tree1.root.left.right.right = new Node(11);
        tree1.root.right.right = new Node(9);
        tree1.root.right.right.left = new Node(4);
        printCountOfFullNodes(tree1);

    }
    public static void printCountOfFullNodes(BinaryTree tree)
    {
        System.out.println("Count Of Half Nodes : " + countFullNodes(tree));
        System.out.println("Count Of Half Nodes : " + countFullNodesIterative(tree));
        System.out.println();
    }

    public static int countFullNodes(BinaryTree tree)
    {
        return countFullNodesRecursive(tree.root);
    }

    //use One of the traversals
    public static int countFullNodesRecursive(Node node)
    {
        if (node == null)
            return 0;
        int left    = countFullNodesRecursive(node.left);
        int right   = countFullNodesRecursive(node.right);
        int res     = BinaryTreeUtils.isFullNode(node) ? 1 : 0;
        return res + left + right;
    }

    public static int countFullNodesIterative(BinaryTree tree)
    {
        if (tree.root == null)
            return 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int count = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (BinaryTreeUtils.isFullNode(node))
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
