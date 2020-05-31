package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Misc.HeightOfBinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

//    https://www.geeksforgeeks.org/level-order-tree-traversal/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        printLevelOrderTraversal(tree);
        printLevelOrderTraversalV2(tree);
    }

    public static void printLevelOrderTraversal(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public static void printLevelOrderTraversalV2(BinaryTree tree)
    {
        int height = HeightOfBinaryTree.heightOfBinaryTree(tree);
        for (int i = 1; i <= height; i++){
            printGivenLevel(tree.root, i);
        }
        System.out.println();
    }

    public static void printGivenLevel(Node node, int level)
    {
        if (node == null)
            return;
        if (level == 1){
            System.out.print(node.data + " ");
            return;
        }
        printGivenLevel(node.left, level - 1);
        printGivenLevel(node.right, level - 1);
    }


}
