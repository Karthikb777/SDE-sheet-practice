package DSAprep;

/*
*       reverse a linked list:
*           steps:
*               take a temp node and set it to null
*               do iterations while head is not null
*                   take a node called next and set it to head.next
*                   set head.next to temp -> break the link b/w head and next and make the new link
*                   set temp = head -> move temp forward
*                   set head = next -> move head forward
*               return temp -> since head will be null after the iteration, temp will be the new head
*
*           do a dry run of the algorithm to understand the algorithm
*
*           TC = O(N), SC = O(1)
* */

public class D5ReverseLinkedList {

    static class LinkedList {
        int data;
        LinkedList next;

        public LinkedList(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void display(LinkedList head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }

    public static LinkedList reverse(LinkedList head) {
        LinkedList temp = null;
        while(head != null) {
            LinkedList next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1);
        LinkedList l2 = new LinkedList(2);
        LinkedList l3 = new LinkedList(3);
        LinkedList l4 = new LinkedList(4);
        LinkedList l5 = new LinkedList(5);
        LinkedList l6 = new LinkedList(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println("before reversing");
        display(l1);
        System.out.println("null");
        LinkedList newHead = reverse(l1);
        System.out.println();
        System.out.println("after reversing");
        display(newHead);
        System.out.println("null");
    }
}
