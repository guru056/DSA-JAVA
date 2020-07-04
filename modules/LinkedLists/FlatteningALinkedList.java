package LinkedLists;

class LNode{
    int data;
    LNode right;
    LNode down;
}
public class FlatteningALinkedList {

    /**
 *            5 -> 10 -> 19 -> 28
     *        |    |     |     |
     *        V    V     V     V
     *        7    20    22    35
     *        |          |     |
     *        V          V     V
     *        8          50    40
     *        |                |
     *        V                V
     *        30               45
     * @param node
     * @return
     */

    public static LNode flatten(LNode node)
    {
        if (node == null || node.right == null)
            return node;

        node.right = flatten(node.right);
        return merge(node, node.right);
    }

    public static LNode merge(LNode nodeA, LNode nodeB)
    {
        if (nodeA == null)
            return nodeB;
        if (nodeB == null)
            return nodeA;
        if (nodeA.data < nodeB.data){
            nodeA.down = merge(nodeA.down, nodeB);
            nodeA.right = null;
            return nodeA;
        } else{
            nodeB.down = merge(nodeA, nodeB.down);
            nodeB.right = null;
            return nodeB;
        }
    }
}
