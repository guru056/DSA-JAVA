package BinaryTree.Traversals;

class TreeNode {
    int data;
    TreeNode left, right, next;
    public TreeNode(int data){
        this.data = data;
        this.left = this.right = this.next = null;
    }
}

class NextNode {
    TreeNode next = null;
    public NextNode(){
        next = null;
    }
}

public class PopulateInOrderSuccessorForAllNodes {

//    https://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
    static TreeNode next = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(3);
        populateNextRecursive(root);
        printSuccessorForAllNodes(root);
        populateNextRecursiveV2(root, new NextNode());
        printSuccessorForAllNodes(root);
    }

    public static void populateNextRecursive(TreeNode treeNode)
    {
        if (treeNode == null)
            return;
        populateNextRecursive(treeNode.right);
        treeNode.next = next;
        next = treeNode;
        populateNextRecursive(treeNode.left);
    }

    public static void populateNextRecursiveV2(TreeNode treeNode, NextNode nextNode)
    {
        if (treeNode == null)
            return;
        populateNextRecursiveV2(treeNode.right, nextNode);
        treeNode.next = nextNode.next;
        nextNode.next = treeNode;
        populateNextRecursiveV2(treeNode.left, nextNode);
    }

    public static void printSuccessorForAllNodes(TreeNode root)
    {
        TreeNode current = getLeftMostNode(root);
        while (current != null){
            TreeNode next = current.next;
            String succ = next == null ? "null" : Integer.toString(next.data);
            System.out.println("Inorder successor of node " + current.data + " is " + succ);
            current = current.next;
        }
    }

    public static TreeNode getLeftMostNode(TreeNode treeNode)
    {
        while (treeNode != null && treeNode.left != null){
            treeNode = treeNode.left;
        }
        return treeNode;
    }

}
