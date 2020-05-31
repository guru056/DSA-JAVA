package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
//https://www.geeksforgeeks.org/get-level-node-binary-tree-iterative-approach/
public class LevelOfANode {

    public static void main(String[] args) {
        printLevelOfNode(BinaryTree.getMockBinaryTree(), 1);
        printLevelOfNode(BinaryTree.getMockBinaryTree(), 2);
        printLevelOfNode(BinaryTree.getMockBinaryTree(), 3);
        printLevelOfNode(BinaryTree.getMockBinaryTree(), 4);
        printLevelOfNode(BinaryTree.getMockBinaryTree(), 5);
        printLevelOfNode(BinaryTree.getMockBinaryTree(), 6);
    }

    public static void printLevelOfNode(BinaryTree tree, int key)
    {
        System.out.println(getLevelOfNode(tree, key));
        System.out.println(getLevelOfNodeIterative(tree, key));
        System.out.println();
    }

    public static int getLevelOfNode(BinaryTree tree, int key)
    {
        return getLevelOfNodeRecursive(tree.root, key, 1);
    }

    public static int getLevelOfNodeRecursive(Node node, int key, int level)
    {
        if (node == null)
            return 0;
        if (node.data == key )
            return level;
        int leftLevel = getLevelOfNodeRecursive(node.left, key, level + 1);
        if (leftLevel != 0 )
            return leftLevel;
        return getLevelOfNodeRecursive(node.right, key, level + 1);
    }

    public static int getLevelOfNodeIterative(BinaryTree tree, int key)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int height = 0 ;
        int nodeCount ;

        while (!queue.isEmpty()){
            nodeCount = queue.size();
            height++;
            while (nodeCount-- > 0){
                Node node = queue.poll();
                if (node.data == key)
                    return height;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return 0;
    }
}
