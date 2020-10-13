package BinaryTree.Misc;

import Utils.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/connect-nodes-at-same-level/
//https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
//https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

public class ConnectNodesAtSameLevel {

    static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        public Node(int data)
        {
            this.data = data;
            this.left = this.right = this.nextRight = null;
        }
    }

    public static void connectNodesAtSameLevel(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nodeCount;
        Node node;
        while (!queue.isEmpty())
        {
            nodeCount = queue.size();
            Node prev = null;
            while (nodeCount-- > 0)
            {
                node = queue.poll();
                if (prev != null)
                    prev.nextRight = node;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                prev = node;
            }
        }
    }

    /**
     * works for complete binary trees
     * For a node N
     *  -> N.left.nextRight = N.right
     *  -> N.right.nextRight = left child of N.nextRight
     *
     * Use pre-order traversal to implement above logic
     * @param node
     */
    public static void connectNodesRecursiveForCompleteBT(Node node)
    {
        if (node == null)
            return;

        if (node.left != null)
            node.left.nextRight = node.right;
        if (node.right != null && node.nextRight != null )
            node.right.nextRight = node.nextRight.left;

        connectNodesRecursiveForCompleteBT(node.left);
        connectNodesRecursiveForCompleteBT(node.right);
    }

    /**
     * Goal: To fill nextRight of each node at a given level before proceeding to the next level
     * Lets say we need to find the nextRight of node p . If n is the parent of p, we can right a
     * helper function that takes n as a parameter and returns the node that should be the
     * nextRight of p.
     * @param node
     */
    public static void connectNodesRecursiveV2(Node node){
        if (node == null )
            return;

        if (node.nextRight != null){
            connectNodesRecursiveV2(node.nextRight);
        }
        linkChildNodes(node);
        connectNodesRecursiveV2(node.left);
        connectNodesRecursiveV2(node.right);
    }

    private static void linkChildNodes(Node node)
    {
        if (node == null) return;
        if (node.left != null){
            node.left.nextRight = node.right != null ? node.right : getNextRight(node);
        }
        if (node.right != null){
            node.right.nextRight = getNextRight(node);
        }
    }

    public static Node getNextRight(Node node)
    {
        Node n = node.nextRight;
        while (n != null){
            if (n.left != null)
                return n.left;
            if (n.right != null)
                return n.right;
            n = n.nextRight;
        }
        return null;
    }

    /**
     * BFS Approach [BEST]
     */
    public static void connectNodesIterative(Node root)
    {
        Node current = root;
        while (current != null)
        {
            Node dummy = new Node(0);
            Node tail = dummy;
            Node node = current;
            while (node != null){
                if (node.left != null){
                    tail.nextRight = node.left;
                    tail = tail.nextRight;
                }
                if (node.right != null){
                    tail.nextRight = node.right;
                    tail = tail.nextRight;
                }
                node = node.nextRight;
            }
            current = dummy.nextRight;
        }
    }
}
