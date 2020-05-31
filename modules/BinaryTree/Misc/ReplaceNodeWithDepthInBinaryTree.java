package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import BinaryTree.Traversals.BinaryTreeTraversals;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/replace-node-with-depth-in-a-binary-tree/
public class ReplaceNodeWithDepthInBinaryTree {

    public static void main(String[] args) {

        BinaryTree tree = BinaryTree.getMockBinaryTree();
        replaceNodesWithDepthRecursiveUtil(tree);
        BinaryTreeTraversals.inOrderTraversal(tree);

        tree = BinaryTree.getMockBinaryTree();
        replaceNodesWithDepthIterative(tree);
        BinaryTreeTraversals.inOrderTraversal(tree);

        tree = BinaryTree.getMockBinaryTreeV3();
        replaceNodesWithDepthRecursiveUtil(tree);
        BinaryTreeTraversals.inOrderTraversal(tree);

        tree = BinaryTree.getMockBinaryTreeV3();
        replaceNodesWithDepthIterative(tree);
        BinaryTreeTraversals.inOrderTraversal(tree);

    }

    public static void replaceNodesWithDepthRecursiveUtil(BinaryTree tree)
    {
        replaceNodesWithDepthRecursive(tree.root, 0);
    }
    public static void replaceNodesWithDepthRecursive(Node node, int level)
    {
        if (node == null)
            return;
        node.data = level;
        replaceNodesWithDepthRecursive(node.left, level + 1);
        replaceNodesWithDepthRecursive(node.right, level + 1);
    }

    public static void replaceNodesWithDepthIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int height = -1 ;
        int nodeCount ;

        while (!queue.isEmpty()){
            nodeCount = queue.size();
            height++;
            while (nodeCount-- > 0){
                Node node = queue.poll();
                node.data = height;
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
