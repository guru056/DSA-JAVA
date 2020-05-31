package BinaryTree.CheckingAndPrinting;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/iterative-function-check-two-trees-identical/
//https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
public class IdenticalTrees {


    public static boolean checkIdenticalTreesRecursiveUtil(BinaryTree tree1, BinaryTree tree2)
    {
        return checkIdenticalTreesRecursive(tree1.root, tree2.root);
    }

    public static boolean checkIdenticalTreesRecursive(Node nodeA, Node nodeB)
    {
        if (nodeA == null && nodeB == null)
            return true;
        if (nodeA != null && nodeB != null){
            return nodeA.data == nodeB.data &&
                    checkIdenticalTreesRecursive(nodeA.left, nodeB.left) &&
                    checkIdenticalTreesRecursive(nodeA.right, nodeB.right);
        }
        return false;
    }

    public static boolean checkIdenticalTreesIterative(BinaryTree tree1, BinaryTree tree2)
    {
        if (tree1 == null && tree2 == null)
            return true;

        Queue<Node> queueA = new LinkedList<>();
        Queue<Node> queueB = new LinkedList<>();
        queueA.add(tree1.root);
        queueB.add(tree2.root);

        while (!queueA.isEmpty() && !queueB.isEmpty()){
            Node nodeA = queueA.poll();
            Node nodeB = queueB.poll();

            if (
                    (nodeA.left == null && nodeB.left != null) ||
                    (nodeA.left != null && nodeB.left == null) ||
                    (nodeA.right == null && nodeB.right != null) ||
                    (nodeA.right != null && nodeB.right == null)
                )
                return false;
            if (nodeA.data != nodeB.data)
                return false;

            if (nodeA.left != null){
                queueA.add(nodeA.left);
            }
            if (nodeA.right != null){
                queueA.add(nodeA.right);
            }
            if (nodeB.left != null){
                queueB.add(nodeB.left);
            }
            if (nodeB.right != null){
                queueB.add(nodeB.right);
            }
        }
        return queueA.isEmpty() && queueB.isEmpty();
    }

    public static boolean checkIdenticalTreesIterativeV2(BinaryTree tree1, BinaryTree tree2)
    {
        if (tree1 == null && tree2 == null)
            return true;
        if( (tree1 == null && tree2!=null) || (tree1 != null && tree2 == null))
            return false;

        Queue<Node> queueA = new LinkedList<>();
        Queue<Node> queueB = new LinkedList<>();
        queueA.add(tree1.root);
        queueB.add(tree2.root);

        while (!queueA.isEmpty() && !queueB.isEmpty()){
            Node nodeA = queueA.poll();
            Node nodeB = queueB.poll();

            if (nodeA.data != nodeB.data)
                return false;
            if (nodeA.left != null && nodeB.left != null)
            {
                queueA.add(nodeA.left);
                queueB.add(nodeB.left);
            } else if (nodeA.left != null || nodeB.left != null){
                return false;
            }

            if (nodeA.right != null && nodeB.right != null)
            {
                queueA.add(nodeA.right);
                queueB.add(nodeB.right);
            } else if (nodeA.right != null || nodeB.right != null){
                return false;
            }
        }
        return true;
    }
}
