package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class MorrisInOrderTraversal {

//    https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        morrisTraversal(tree);
    }

    public static void morrisTraversal(BinaryTree tree)
    {
        Node current = tree.root;
        Node pre = null;
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
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
}
