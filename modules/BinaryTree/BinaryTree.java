package BinaryTree;

public class BinaryTree {
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int data){
        Node root = new Node(data);
        this.root = root;
    }

    public static BinaryTree getMockBinaryTree()
    {
        BinaryTree tree = new BinaryTree();
        tree.root               = new Node(1);
        tree.root.left          = new Node(2);
        tree.root.right         = new Node(3);
        tree.root.left.left     = new Node(4);
        tree.root.left.right    = new Node(5);
        return tree;
    }

    public static BinaryTree getMockBinaryTreeV2()
    {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        return tree;
    }

    public static BinaryTree getMockBinaryTreeV3()
    {
        BinaryTree tree = getMockBinaryTreeV2();
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);
        return tree;
    }
}
