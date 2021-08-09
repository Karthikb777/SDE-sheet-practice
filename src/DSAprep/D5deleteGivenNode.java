package DSAprep;

/*
*       delete a node when a node is given
*           copy the node's next's value to node's value
*           delete node.next
*       it is not possible to delete the entire node without access to the head
*       this only works if the node isn't a tail node
*
*       TC O(1), SC O(1)
* */

public class D5deleteGivenNode {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void removeNode(Node node) {
        if (node.next == null) {
            node = null;
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);
        Node l5 = new Node(5);
        Node l6 = new Node(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println("before removal:");
        display(l1);

        removeNode(l1);

        System.out.println("after removal:");
        display(l1);
    }
}
