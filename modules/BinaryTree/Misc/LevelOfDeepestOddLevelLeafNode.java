package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/depth-deepest-odd-level-node-binary-tree/
//https://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/

public class LevelOfDeepestOddLevelLeafNode {

    public static void main(String[] args) {
        printLevelOfDeepestOddLevelLeafNode(BinaryTree.getMockBinaryTree());
        printLevelOfDeepestOddLevelLeafNode(BinaryTree.getMockBinaryTreeV2());
        printLevelOfDeepestOddLevelLeafNode(BinaryTree.getMockBinaryTreeV3());

        BinaryTree tree  = BinaryTree.getMockBinaryTreeV3();
        tree.root.left.left.left.left = new Node(16);
        printLevelOfDeepestOddLevelLeafNode(tree);

        Node root   = new Node(10);
        root.left   = new Node(28);
        root.right  = new Node(13);
        root.right.left = new Node(14);
        root.right.right = new Node(15);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        tree.root =  root;

        printLevelOfDeepestOddLevelLeafNode(tree);
    }

    public static void printLevelOfDeepestOddLevelLeafNode(BinaryTree tree)
    {
        int deepestLevel = getLevelOfDeepestOddLevelLeafNodeRecursiveUtil(tree);
        System.out.println(deepestLevel);
        deepestLevel = getLevelOfDeepestOddLevelLeafNodeIterative(tree);
        System.out.println(deepestLevel);
    }

    public static int getLevelOfDeepestOddLevelLeafNodeRecursiveUtil(BinaryTree tree)
    {
        return getLevelOfDeepestOddLevelLeafNodeRecursive(tree.root, 1);
    }

    public static int getLevelOfDeepestOddLevelLeafNodeRecursive(Node node, int level)
    {
        if (node == null)
            return 0;
        if (level % 2 != 0 && BinaryTreeUtils.isLeafNode(node) ){
            return level;
        }
        return Math.max(
                getLevelOfDeepestOddLevelLeafNodeRecursive(node.left, level + 1),
                getLevelOfDeepestOddLevelLeafNodeRecursive(node.right, level + 1)
        );
    }

    public static int getLevelOfDeepestOddLevelLeafNodeIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int level = 0 ;
        int nodeCount ;
        int deepestLevel = 0;

        while (true){
            nodeCount = queue.size();
            if (nodeCount == 0)
                break;
            level++;
            while (nodeCount-- > 0){
                Node node = queue.poll();
                if (level % 2 != 0 && BinaryTreeUtils.isLeafNode(node)){
                    deepestLevel = level;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return deepestLevel;
    }
}
