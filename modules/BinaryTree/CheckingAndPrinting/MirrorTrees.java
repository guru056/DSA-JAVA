package BinaryTree.CheckingAndPrinting;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
//https://www.geeksforgeeks.org/iterative-method-check-two-trees-mirror/
public class MirrorTrees {

    public static boolean checkMirrorTrees(Node nodeA, Node nodeB)
    {
        if (nodeA == null && nodeB == null)
            return true;
        if (nodeA != null && nodeB != null){
            return nodeA.data == nodeB.data &&
                    checkMirrorTrees(nodeA.left, nodeB.right) &&
                    checkMirrorTrees(nodeA.right, nodeB.left);
        }
        return false;
    }

    public static boolean checkMirrorTreesIterative(BinaryTree tree1, BinaryTree tree2)
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
            if (nodeA.left != null && nodeB.right != null)
            {
                queueA.add(nodeA.left);
                queueB.add(nodeB.right);
            } else if (nodeA.left != null || nodeB.right != null){
                return false;
            }

            if (nodeA.right != null && nodeB.left != null)
            {
                queueA.add(nodeA.right);
                queueB.add(nodeB.left);
            } else if (nodeA.right != null || nodeB.left != null){
                return false;
            }
        }
        return true;
    }


}
