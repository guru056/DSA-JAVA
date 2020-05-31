package BinaryTree.Summation;

import BinaryTree.Node;

//https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
public class MaximumPathSum {
    static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(Node node)
    {
        if (node == null)
            return 0;
        int leftSum = maxPathSum(node.left);
        int rightSum = maxPathSum(node.right);

        int currentSum = Math.max(node.data , Math.max(leftSum, rightSum) + node.data);
        int currentMaxSum = Math.max(currentSum, node.data + leftSum + rightSum);

        maxSum = Math.max(maxSum, currentMaxSum);

        return currentSum;
    }
}
