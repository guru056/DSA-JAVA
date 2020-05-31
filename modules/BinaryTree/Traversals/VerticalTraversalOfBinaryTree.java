package BinaryTree.Traversals;

import BinaryTree.BinaryTree;
import BinaryTree.Misc.MaxMinHorizontalDistanceFromRoot;
import BinaryTree.Node;

import java.util.*;

class Pair {
    int hd;
    Node node;
    public Pair(int hd, Node node){
        this.hd = hd;
        this.node = node;
    }
}

//https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
//https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
//https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
public class VerticalTraversalOfBinaryTree {
    static TreeMap<Integer, ArrayList<Node>> map = new TreeMap<>();
    public static void main(String[] args) {
        printVerticalOrderTraversal(BinaryTree.getMockBinaryTree());
        printVerticalOrderTraversalV2(BinaryTree.getMockBinaryTree());
        verticalOrderTraversalIterative(BinaryTree.getMockBinaryTree());
    }

    public static void printVerticalOrderTraversalPractice(BinaryTree tree)
    {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        queue.add(new Pair(0, tree.root));
        Pair node ;
        while (!queue.isEmpty()){
            node = queue.poll();
            List<Node> temp;
            if (map.containsKey(node.hd)){
                temp = map.get(node.hd);
            } else{
                temp = new ArrayList<Node>();
            }
            temp.add(node.node);
            map.put(node.hd, temp);
            if (node.node.left != null){
                queue.add(new Pair(node.hd - 1, node.node.left));
            }
            if (node.node.right != null){
                queue.add(new Pair(node.hd + 1, node.node.right));
            }
        }
        for (Map.Entry<Integer, List<Node>> entry: map.entrySet()){
            List<Node> temp = entry.getValue();
            for (int i = 0; i < temp.size(); i++){
                System.out.print(temp.get(i).data + " ");
            }
            System.out.println();
        }
    }

    public static void printVerticalOrderTraversal(BinaryTree tree)
    {
        int[] maxMinHd = MaxMinHorizontalDistanceFromRoot.setMaxMinHorizontalDistance(tree);
        int minHd = maxMinHd[0];
        int maxHd = maxMinHd[1];
        for (int i = minHd; i <= maxHd; i++){
            verticalOrderTraversalRecursive(tree.root, i, 0);
            System.out.println();
        }
        System.out.println();
    }

    public static void verticalOrderTraversalRecursive(Node node, int lineNo, int hd)
    {
        if (node == null)
            return;
        if (lineNo == hd)
            System.out.print(node.data + " ");
        verticalOrderTraversalRecursive(node.left, lineNo, hd - 1);
        verticalOrderTraversalRecursive(node.right, lineNo, hd + 1);
    }

    public static void printVerticalOrderTraversalV2(BinaryTree tree)
    {
        verticalOrderTraversalRecursiveV2(tree.root, 0);
        for (Map.Entry<Integer, ArrayList<Node>> entry: map.entrySet()) {
            ArrayList<Node> arr = entry.getValue();
            for (int i = 0 ; i < arr.size(); i++){
                System.out.print(arr.get(i).data + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void verticalOrderTraversalRecursiveV2(Node node, int hd)
    {
        if (node == null)
            return;

        ArrayList<Node> arr;
        if (map.containsKey(hd)){
            arr = map.get(hd);
        } else {
            arr = new ArrayList<Node>();
        }
        arr.add(node);
        map.put(hd, arr);

        verticalOrderTraversalRecursiveV2(node.left, hd - 1);
        verticalOrderTraversalRecursiveV2(node.right, hd + 1);
    }

    public static void verticalOrderTraversalIterative(BinaryTree tree)
    {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, ArrayList<Node>> map = new TreeMap<>();
        queue.add(new Pair(0, tree.root));

        while (!queue.isEmpty())
        {
            Pair p = queue.poll();
            if (map.containsKey(p.hd)){
                ArrayList<Node> arr = map.get(p.hd);
                arr.add(p.node);
                map.put(p.hd, arr);
            } else{
                ArrayList<Node> arr = new ArrayList<Node>();
                arr.add(p.node);
                map.put(p.hd, arr);
            }

            if (p.node.left != null){
                queue.add(new Pair(p.hd - 1, p.node.left));
            }
            if (p.node.right != null){
                queue.add(new Pair(p.hd + 1, p.node.right));
            }
        }

        for (Map.Entry<Integer, ArrayList<Node>> entry: map.entrySet()){
            ArrayList<Node> arr = entry.getValue();
            for (int i = 0 ; i < arr.size(); i++){
                System.out.print(arr.get(i).data + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
