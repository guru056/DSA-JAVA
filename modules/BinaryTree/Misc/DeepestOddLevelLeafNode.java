package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//variation of following
//https://www.geeksforgeeks.org/depth-deepest-odd-level-node-binary-tree/
//https://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/

public class DeepestOddLevelLeafNode {

    static int maxLevel = 0;
    static Node deepestOddLevelLeafNode = null;

    public static void main(String[] args) {
        printDeepestOddLevelLeafNode(BinaryTree.getMockBinaryTree());
        printDeepestOddLevelLeafNode(BinaryTree.getMockBinaryTreeV2());
        printDeepestOddLevelLeafNode(BinaryTree.getMockBinaryTreeV3());

        BinaryTree tree = new BinaryTree();

        tree = BinaryTree.getMockBinaryTreeV3();
        tree.root.left.left.left.left = new Node(16);
        printDeepestOddLevelLeafNode(tree);

        Node root   = new Node(10);
        root.left   = new Node(28);
        root.right  = new Node(13);
        root.right.left = new Node(14);
        root.right.right = new Node(15);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        tree.root =  root;

        printDeepestOddLevelLeafNode(tree);

    }

    public static void printDeepestOddLevelLeafNode(BinaryTree tree)
    {
        Node resultNode = getDeepestOddLevelLeafNodeRecursive(tree);
        if (resultNode == null){
            System.out.println("Invalid input");
        } else {
            System.out.println(resultNode.data + " at level " + maxLevel);
        }
        deepestOddLevelLeafNode = null;
        maxLevel = 0;
        resultNode = getDeepestOddLevelLeafNodeIterative(tree);
        if (resultNode == null){
            System.out.println("Invalid input");
        } else {
            System.out.println(resultNode.data + " at level " + maxLevel);
        }
        deepestOddLevelLeafNode = null;
        maxLevel = 0;
    }

    public static Node getDeepestOddLevelLeafNodeRecursive(BinaryTree tree)
    {
        setDeepestOddLevelLeafNodeRecursive(tree.root, 1);
        return deepestOddLevelLeafNode;
    }

    public static Node getDeepestOddLevelLeafNodeIterative(BinaryTree tree)
    {
        setDeepestOddLevelLeafNodeIterative(tree);
        return deepestOddLevelLeafNode;
    }

    public static void setDeepestOddLevelLeafNodeRecursive(Node node, int level)
    {
        if (node == null)
            return ;
        if (level % 2 != 0 && BinaryTreeUtils.isLeafNode(node) && level > maxLevel ){
            maxLevel = level;
            deepestOddLevelLeafNode = node;
        }
        setDeepestOddLevelLeafNodeRecursive(node.left, level + 1);
        setDeepestOddLevelLeafNodeRecursive(node.right, level + 1);
    }

    public static void setDeepestOddLevelLeafNodeIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int height = 0 ;
        int nodeCount ;

        while (true){
            nodeCount = queue.size();
            if (nodeCount == 0)
                break;
            height++;
            while (nodeCount-- > 0){
                Node node = queue.poll();
                if (height % 2 != 0 && BinaryTreeUtils.isLeafNode(node)){
                    deepestOddLevelLeafNode = node;
                    maxLevel = height;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
    }
}
