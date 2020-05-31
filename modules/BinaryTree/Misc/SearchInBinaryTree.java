package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/iterative-search-for-a-key-x-in-binary-tree/
public class SearchInBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        printSearchResults(tree , 1);
        printSearchResults(tree , 2);
        printSearchResults(tree , 3);
        printSearchResults(tree , 4);
        printSearchResults(tree , 5);
        printSearchResults(tree , 6);
    }
    public static void printSearchResults(BinaryTree tree, int key)
    {
        System.out.println("Node Found : " + searchForANode(tree, key));
        System.out.println("Node Found : " + searchForANodeIterative(tree, key));
        System.out.println();
    }

    public static boolean searchForANode(BinaryTree tree, int key)
    {
        return searchForANodeRecursive(tree.root, key);
    }

    public static boolean searchForANodeRecursive(Node node, int key)
    {
        if (node == null)
            return false;
        if (node.data == key )
            return true;
        return searchForANodeRecursive(node.left, key) || searchForANodeRecursive(node.right, key);
    }

    public static boolean searchForANodeIterative(BinaryTree tree, int key)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.data == key)
                return true;
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return false;
    }
}
