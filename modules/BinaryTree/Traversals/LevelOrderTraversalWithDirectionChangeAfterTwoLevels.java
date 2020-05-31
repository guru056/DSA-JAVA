package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalWithDirectionChangeAfterTwoLevels {

//    https://www.geeksforgeeks.org/level-order-traversal-direction-change-every-two-levels/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTreeV3();
        tree.root.left.left.right.left = new Node(16);
        tree.root.left.right.right.left = new Node(17);
        tree.root.right.right.left.right = new Node(18);
        printLevelOrderTraversal(tree);
    }
    public static void printLevelOrderTraversal(BinaryTree tree)
    {
        Stack<Node> st = new Stack<Node>();
        Queue<Node> queue = new LinkedList<Node>();

        int reverseCount = 0;
        int nodeCount ;
        boolean leftToRight = true;
        queue.add(tree.root);

        while (true){
            reverseCount++;
            nodeCount = queue.size();
            if (nodeCount == 0)
                break;
            while (nodeCount-- > 0){
                Node node = queue.poll();
                if (leftToRight){
                    System.out.print(node.data + " ");
                } else {
                    st.push(node);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (leftToRight){
                System.out.println();
            }
            if (!leftToRight){
                while (!st.isEmpty()){
                    Node node = st.pop();
                    System.out.print(node.data + " ");
                }
                System.out.println();
            }
            if (reverseCount == 2){
                leftToRight = !leftToRight;
                reverseCount = 0;
            }
        }
    }
}
