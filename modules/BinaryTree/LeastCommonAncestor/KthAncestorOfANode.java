package BinaryTree.LeastCommonAncestor;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
//https://www.geeksforgeeks.org/kth-ancestor-node-binary-tree-set-2/
public class KthAncestorOfANode {
static int k = 2;

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
//        System.out.println(kthAncestorIterative(tree, 5,  5, 2 ));
        k = 1;
        kthAncestorRecursive(tree.root, 5);
    }
    public static boolean kthAncestorRecursive(Node node, int searchNode)
    {
        if (node == null)
            return false;
//        if (node.data == searchNode)
//            return true;
        if (node.data == searchNode || kthAncestorRecursive(node.left, searchNode)  || kthAncestorRecursive(node.right, searchNode) ){
            if (k > 0){
                k--;
            }
            else if(k == 0) {
                System.out.println(node.data);
                return false;
            }
            return true;
        }
        return false;
    }

    public static int kthAncestorIterative(BinaryTree tree, int searchNode, int n, int k )
    {
        int[] ancestors = new int[ n + 1];
        ancestors[tree.root.data] = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.left != null){
                ancestors[node.left.data] = node.data;
                queue.add(node.left);
            }
            if (node.right != null){
                ancestors[node.right.data] = node.data;
                queue.add(node.right);
            }
        }
        int ancestor = searchNode;
        int count = 0;
        while (ancestor != 0){
            ancestor = ancestors[ancestor];
            count++;

            if (count == k)
                break;
        }
        return ancestor;
    }
}
