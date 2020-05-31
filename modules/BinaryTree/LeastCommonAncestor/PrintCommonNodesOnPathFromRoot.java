package BinaryTree.LeastCommonAncestor;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

//https://www.geeksforgeeks.org/print-common-nodes-path-root-common-ancestors/
public class PrintCommonNodesOnPathFromRoot {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.right.left.left = new Node(9);
        tree.root.right.left.right = new Node(10);
        printCommonNodes(tree, 9, 7);

    }
    public static void printCommonNodes(BinaryTree tree, int n1, int n2)
    {
        Node lca = LeastCommonAncestorInBinaryTree.findLCA(tree, n1, n2);
        if (lca == null){
            System.out.println("One or both nodes not present in the tree");
            return;
        }
        System.out.print(lca.data + " ");
        PrintAncestorsOfGivenNode.printAncestorsRecursive(tree.root, lca.data);
        System.out.println();
    }
}
