package BinaryTree.Misc;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getMockBinaryTree();
        printTopView(tree);
    }
    public static void printTopView(BinaryTree tree)
    {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();
        queue.add(new Pair(0, tree.root));

        while (!queue.isEmpty())
        {
            Pair p = queue.poll();
            if (!map.containsKey(p.hd))
                map.put(p.hd, p.node);

            if (p.node.left != null){
                queue.add(new Pair(p.hd - 1, p.node.left));
            }
            if (p.node.right != null){
                queue.add(new Pair(p.hd + 1, p.node.right));
            }
        }

        for (Map.Entry<Integer, Node> entry: map.entrySet()){
            System.out.print(entry.getValue().data + " ");
        }
        System.out.println();
    }
}
