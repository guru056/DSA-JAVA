package BinaryTree.LeastCommonAncestor;

import BinaryTree.BinaryTree;
import BinaryTree.Misc.LevelOfANode;
import BinaryTree.Node;

//https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
public class DistanceBetweenTwoNodes {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        BinaryTree tree = new BinaryTree();
        tree.root = root;
        printDistanceBetweenTwoNodes(tree, 4, 5);
        printDistanceBetweenTwoNodes(tree, 4, 6);
        printDistanceBetweenTwoNodes(tree, 3, 4);
        printDistanceBetweenTwoNodes(tree, 2, 4);
        printDistanceBetweenTwoNodes(tree, 8, 5);


    }

    public static void printDistanceBetweenTwoNodes(BinaryTree tree, int n1, int n2)
    {
        int dist = distanceBetweenTwoNodes(tree, n1, n2);
        if (dist == -1){
            System.out.println("One or both nodes not present in the tree");
            return;
        }
        System.out.println("Distance between " + n1 + " and " + n2 + " = " + dist);
    }

    //dist(n1,n2) = dist(lca,n1) + dist(lca,n2)
    public static int distanceBetweenTwoNodes(BinaryTree tree, int n1, int n2)
    {
        Node lca = LeastCommonAncestorInBinaryTree.findLCA(tree, n1, n2);
        if (lca == null)
            return -1;
        int levelN1 = LevelOfANode.getLevelOfNodeRecursive(lca, n1 , 1) - 1;
        int levelN2 = LevelOfANode.getLevelOfNodeRecursive(lca, n2, 1) - 1;

        return levelN1 + levelN2;
    }


}
