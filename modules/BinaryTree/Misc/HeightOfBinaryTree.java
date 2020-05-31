package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

//    https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
//    https://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        System.out.println("Height : " + heightOfBinaryTree(tree));
        System.out.println("Height : " + heightOfBinaryTreeIterative(tree));
    }

    public static int heightOfBinaryTree(BinaryTree tree){
        return heightOfBinaryTreeRecursiveUtil(tree);
    }

    public static int heightOfBinaryTreeRecursiveUtil( BinaryTree tree)
    {
        return heightOfBinaryTreeRecursive(tree.root);
    }

    public static int heightOfBinaryTreeRecursive(Node node)
    {
        if (node == null)
            return 0;
        return 1 + Math.max(
                    heightOfBinaryTreeRecursive(node.left),
                    heightOfBinaryTreeRecursive(node.right)
        );
    }

    public static int heightOfBinaryTreeIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int height = 0 ;
        int nodeCount ;

        while (true){
            nodeCount = queue.size();
            if (nodeCount == 0)
                return height;
            height++;
            while (nodeCount-- > 0){
                Node node = queue.poll();
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
