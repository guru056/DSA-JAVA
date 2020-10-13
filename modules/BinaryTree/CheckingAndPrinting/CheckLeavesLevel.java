package BinaryTree.CheckingAndPrinting;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/check-leaves-level/
public class CheckLeavesLevel {
    static int firstLeafLevel = 0;

    public static void main(String[] args) {
        printIfLeavesLevelAreSame(BinaryTree.getMockBinaryTree());
        printIfLeavesLevelAreSame(BinaryTree.getMockBinaryTreeV2());
        printIfLeavesLevelAreSame(BinaryTree.getMockBinaryTreeV3());
    }

    /**
     *           12
     *         /    \
     *       5       7
     *     /          \
     *    3            1
     *   Leaves are at same level
     * @param tree
     */
    public static void printIfLeavesLevelAreSame(BinaryTree tree)
    {
        if (checkLeavesLevelRecursiveUtil(tree)){
            System.out.println("ALl leafs are at same level");
        } else {
            System.out.println("ALl leafs are NOT at same level");
        }
        firstLeafLevel = 0;
        if (checkLeavesLevelIterative(tree)){
            System.out.println("ALl leafs are at same level");
        } else {
            System.out.println("ALl leafs are NOT at same level");
        }
        firstLeafLevel = 0;
        System.out.println();
    }


    public static boolean checkLeavesLevelRecursiveUtil(BinaryTree tree)
    {
        return checkLeavesLevelRecursive(tree.root, 1);
    }
    public static boolean checkLeavesLevelRecursive(Node node, int level)
    {
        if (node == null)
            return true;
        if (BinaryTreeUtils.isLeafNode(node)){
            if (firstLeafLevel == 0){
                firstLeafLevel = level;
                return true;
            }
            return level == firstLeafLevel;
        }
        return checkLeavesLevelRecursive(node.left , level + 1) && checkLeavesLevelRecursive(node.right, level + 1);
    }

    public static boolean checkLeavesLevelIterative(BinaryTree tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        int level = 0 ;
        int nodeCount ;

        while (!queue.isEmpty()){
            nodeCount = queue.size();
            level++;
            while (nodeCount-- > 0){
                Node node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                    if (BinaryTreeUtils.isLeafNode(node.left)){
                        if (firstLeafLevel == 0){
                            firstLeafLevel = level;
                        } else if (level != firstLeafLevel){
                            return false;
                        }
                    }
                }
                if (node.right != null){
                    queue.add(node.right);
                    if (BinaryTreeUtils.isLeafNode(node.right)){
                        if (firstLeafLevel == 0){
                            firstLeafLevel = level;
                        } else if (level != firstLeafLevel){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
