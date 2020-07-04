package LinkedLists;

//https://www.geeksforgeeks.org/in-a-linked-list-given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/
public class DeleteWithoutHeadPointer {

    public static void delete(Node node)
    {
        if (node == null || node.next == null)
            return;
        Node temp   = node.next;
        node.data   = temp.data;
        node.next   = temp.next;
        temp        = null;
    }
}
