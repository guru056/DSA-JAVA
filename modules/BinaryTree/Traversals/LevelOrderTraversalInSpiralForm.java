package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Misc.HeightOfBinaryTree;
import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
public class LevelOrderTraversalInSpiralForm {

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTreeV3();
//        printLevelOrderTraversal(tree);
        printLevelOrderTraversalInSpiralForm(tree);
        printLevelOrderTraversalInSpiralFormIterative(tree);
    }
    public static void printLevelOrderTraversalInSpiralForm(BinaryTree tree)
    {
        int height = HeightOfBinaryTree.heightOfBinaryTree(tree);
        boolean reverse = true;
        for (int i = 1; i <= height; i++){
            printGivenLevel(tree.root, i, reverse);
            reverse = !reverse;
        }
        System.out.println();
    }

    public static void printGivenLevel(Node node, int level, boolean reverse)
    {
        if (node == null)
            return;
        if (level == 1){
            System.out.print(node.data + " ");
            return;
        }
        if (reverse){
            printGivenLevel(node.right, level - 1, reverse);
            printGivenLevel(node.left, level - 1, reverse);
        } else {
            printGivenLevel(node.left, level - 1, reverse);
            printGivenLevel(node.right, level - 1, reverse);
        }
    }

    /*Using two stacks*/
    public static void printLevelOrderTraversalInSpiralFormIterative(BinaryTree tree)
    {
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();

        st1.add(tree.root);

        while (!st1.isEmpty() || !st2.isEmpty()){

            while (!st1.isEmpty()){
                Node node = st1.pop();
                System.out.print(node.data + " ");
                if (node.right != null){
                    st2.push(node.right);
                }
                if (node.left != null){
                    st2.push(node.left);
                }
            }

            while (!st2.isEmpty()){
                Node node = st2.pop();
                System.out.print(node.data + " ");
                if (node.left != null){
                    st1.push(node.left);
                }
                if (node.right != null){
                    st1.push(node.right);
                }
            }
        }
        System.out.println();
    }
}
