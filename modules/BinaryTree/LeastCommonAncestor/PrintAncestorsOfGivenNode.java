package BinaryTree.LeastCommonAncestor;

import BinaryTree.BinaryTree;
import BinaryTree.CheckingAndPrinting.PrintPathFromRootToGivenNode;
import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
//https://www.geeksforgeeks.org/print-path-common-two-paths-root-two-given-nodes/
public class PrintAncestorsOfGivenNode {

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        for (int i = 1; i <= 5; i++){
            printAncestors(tree, i);
        }
    }

    //this is same as printing path from root to node.
    public static void printAncestors(BinaryTree tree, int searchNode)
    {
        System.out.println("Ancestors of " + searchNode + " : ");
        boolean x = printAncestorsRecursive(tree.root, searchNode);
        ArrayList<Node> list = new ArrayList<Node>();
        List<Integer> resultList = new ArrayList<>();
        PrintPathFromRootToGivenNode.printPathFromRootToNodeRecursiveV2(tree.root, searchNode,list);
        for (Node n: list) {
            resultList.add(n.data);
        }
        System.out.println(resultList);
        System.out.println();
        System.out.println();

    }

    public static boolean printAncestorsRecursive(Node node, int searchNode)
    {
        if (node == null)
            return false;
        if(node.data == searchNode)
            return true;

        if (printAncestorsRecursive(node.left, searchNode) || printAncestorsRecursive(node.right, searchNode)){
            System.out.print(node.data + " ");
            return true;
        }
        return false;
    }

}
