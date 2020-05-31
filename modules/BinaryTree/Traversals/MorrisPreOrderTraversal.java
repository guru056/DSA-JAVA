package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class MorrisPreOrderTraversal {

//    https://www.geeksforgeeks.org/morris-traversal-for-preorder/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        morrisPreOrderTraversal(tree);
    }

    public static void morrisPreOrderTraversal(BinaryTree tree)
    {
        Node current = tree.root;
        Node pre;
        while (current != null){
            if (current.left == null){
                System.out.print(current.data + " ");
                current = current.right;
            } else{
                pre = current.left;
                while (pre.right != null && pre.right != current){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                } else{
                    pre.right = null;
                    current = current.right;
                }
            }
        }
    }
}
