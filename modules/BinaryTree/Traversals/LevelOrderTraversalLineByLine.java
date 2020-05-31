package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {

//    https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
//    https://www.geeksforgeeks.org/level-order-traversal-line-line-set-3-using-one-queue/
//    https://www.geeksforgeeks.org/level-order-traversal-line-line-set-2-using-two-queues/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTreeV2();
        printLevelOrderTraversalLineByLine(tree);
    }

    public static void printLevelOrderTraversalLineByLine(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int nodeCount ;

        while (true){
            nodeCount = queue.size();
            if (nodeCount == 0)
                break;
            while (nodeCount > 0){
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }
}
