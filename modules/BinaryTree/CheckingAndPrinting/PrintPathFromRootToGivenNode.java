package BinaryTree.CheckingAndPrinting;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Stack;

//https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
public class PrintPathFromRootToGivenNode {
    static Stack<Node> st = new Stack<Node>();

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.left.right.left = new Node(9);
        for (int i = 1; i <=10;i++){
            printPathFromRootToNode(tree, i);
        }
    }
    public static void printPathFromRootToNode(BinaryTree tree, int searchNode)
    {
        Node x = printPathFromRootToNodeRecursive(tree.root, searchNode);
        if (x == null){
            System.out.println("No path ");
        } else{
            st.add(tree.root);
            while (!st.isEmpty()){
                Node node = st.pop();
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
        ArrayList<Node> path = new ArrayList<Node>();
        Node res = printPathFromRootToNodeRecursiveV2(tree.root, searchNode, path);
        if (res == null){
            System.out.println("No path ");
        } else {
            for (int i = 0 ; i < path.size(); i++){
                Node node = path.get(i);
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Node printPathFromRootToNodeRecursive(Node node, int searchNode)
    {
        if (node == null)
            return null;
        if (node.data == searchNode){
            return node;
        }
        Node left = printPathFromRootToNodeRecursive(node.left, searchNode);
        if (left != null){
            st.add(node.left);
            return left;
        } else{
            Node right = printPathFromRootToNodeRecursive(node.right, searchNode);
            if (right != null)
                st.add(node.right);
            return right;
        }
    }

    public static Node printPathFromRootToNodeRecursiveV2(Node node, int searchNode, ArrayList<Node> list)
    {
        if (node == null)
            return null;
        list.add(node);
        if (node.data == searchNode){
            return node;
        }
        Node left = printPathFromRootToNodeRecursiveV2(node.left, searchNode, list);
        if (left != null){
            return left;
        } else{
            Node right = printPathFromRootToNodeRecursiveV2(node.right, searchNode, list);
            if (right != null)
                return right;
        }
        list.remove(list.size() - 1);
        return null;
    }

    public static ArrayList<Node> getPathFromRootToNode(BinaryTree tree, int searchNode)
    {
        ArrayList<Node> path = new ArrayList<Node>();
        Node res = printPathFromRootToNodeRecursiveV2(tree.root, searchNode, path);
        return path;
    }

}
