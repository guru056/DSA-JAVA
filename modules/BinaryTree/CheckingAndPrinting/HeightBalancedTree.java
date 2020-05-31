package BinaryTree.CheckingAndPrinting;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
import Utils.BinaryTreeUtils;

class Height{
    int height = 0;
}

public class HeightBalancedTree {

    static int leftLevel;
    static int rightLevel;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(15);
//
//        System.out.println(checkBalancedTreeUtil(tree));

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(1);
        tree1.root.right = new Node(3);
        tree1.root.right.left = new Node(2);

        System.out.println(checkBalancedTreeUtil(tree1));
        System.out.println(checkBalancedTreeUtil(tree));

    }

    public static boolean checkBalancedTreeUtil(BinaryTree tree)
    {
        int result = checkHeightBalanced(tree.root);
        return result != -1;
//        Height height = new Height();
//        boolean result = checkHeightBalancedV2(tree.root, height);
//        System.out.println(height.height);
//        return result;
//        System.out.println(checkHeightBalancedV2(tree.root,height));
//        boolean left = checkHeightBalanced(tree.root.left, true);
//        boolean right = checkHeightBalanced(tree.root.right, false);
//
//        boolean result =  left && right && Math.abs(leftLevel - rightLevel) <= 1;
//        System.out.println(leftLevel);
//        System.out.println(rightLevel);
//        resetLevels();
//        return result;
    }
    /**
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param node
     * @param isLeft
     * @return
     */
    public static boolean checkHeightBalanced(Node node, boolean isLeft)
    {
        if (node == null){
            if (isLeft)
                leftLevel = 0;
            else
                rightLevel = 0;
            return true;
        }
//        if(BinaryTreeUtils.isLeafNode(node)){
//            if (isLeft)
//                leftLevel = 1;
//            else
//                rightLevel = 1;
//            return true;
//        }
        leftLevel = 0;
        rightLevel = 0;
        boolean isLeftSubtreeBalanced = checkHeightBalanced(node.left, true);
        boolean isRightSubtreeBalanced = checkHeightBalanced(node.right, false );

        if (isLeft){
            leftLevel = Math.max(leftLevel, rightLevel) + 1;
        } else{
            rightLevel = Math.max(leftLevel, rightLevel) + 1;
        }

        return Math.abs(leftLevel - rightLevel) <= 1 &&
                isLeftSubtreeBalanced &&
                isRightSubtreeBalanced ;
    }

    private static void resetLevels()
    {
        leftLevel = 0;
        rightLevel = 0;
    }

    public static boolean checkHeightBalancedV2(Node node, Height height)
    {
        if (node == null){
            height.height = 0;
            return true;
        }

        Height lh = new Height();
        Height rh = new Height();
        boolean isLeftSubtreeBalanced = checkHeightBalancedV2(node.left, lh);
        boolean isRightSubtreeBalanced = checkHeightBalancedV2(node.right, rh );

        height.height = Math.max(lh.height, rh.height) + 1;

        return Math.abs(lh.height - rh.height) <= 1 &&
                isLeftSubtreeBalanced &&
                isRightSubtreeBalanced ;

    }

    public static int checkHeightBalanced(Node node)
    {
        if (node == null)
            return 0;
        int leftHeight = checkHeightBalanced(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeightBalanced(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1 )
            return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }


}
