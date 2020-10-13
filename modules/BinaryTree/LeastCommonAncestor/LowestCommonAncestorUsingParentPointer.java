package BinaryTree.LeastCommonAncestor;

import java.util.HashSet;

//https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
public class LowestCommonAncestorUsingParentPointer {

    static class Node {
        int data;
        Node left, right, parent;
        public Node(int data){
            this.data = data;
            this.left = this.right = this.parent = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.parent = root;

        root.right.parent = root;

        root.left.left.parent  = root.left;
        root.left.right.parent = root.left;

        printLca(root.left.left, root.right);
    }
    public static void printLca(Node n1, Node n2)
    {
        Node lca = findLca(n1, n2);
        if (lca == null){
            System.out.println("LCA NOT FOUND");
        } else {
            System.out.println("LCA (" + n1.data + " , " + n2.data + " ) = " + lca.data);
        }
        lca = findLcaV2(n1, n2);
        if (lca == null){
            System.out.println("LCA NOT FOUND");
        } else {
            System.out.println("LCA (" + n1.data + " , " + n2.data + " ) = " + lca.data);
        }
    }

    public static Node findLca( Node n1, Node n2)
    {
        HashSet<Node> ancestors = new HashSet<>();

        while (n1 != null){
            ancestors.add(n1);
            n1 = n1.parent;
        }

        while (n2 != null){
            if (ancestors.contains(n2))
                return n2;
            n2 = n2.parent;
        }

        return null;
    }

    public static Node findLcaV2(Node n1, Node n2)
    {
        int depthN1 = depthOfNodeFromRoot(n1);
        int depthN2 = depthOfNodeFromRoot(n2);

        int diffDepth = depthN1 - depthN2;
        if (diffDepth < 0){
            Node temp = n1;
            n1 = n2;
            n2 = temp;
            diffDepth = -diffDepth;
        }

        while (diffDepth-- > 0){
            n1 = n1.parent;
        }

        while (n1 != null && n2 != null){
            if (n1 == n2)
                return n1;
            n1 = n1.parent ;
            n2 = n2.parent ;
        }

        return null;
    }

    private static int depthOfNodeFromRoot(Node node)
    {
        int depth = -1;
        while (node != null){
            depth++;
            node = node.parent;
        }
        return depth;
    }

}
