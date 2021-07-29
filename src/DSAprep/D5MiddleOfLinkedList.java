package DSAprep;

/*
*       find the middle of the linked list given the head
*
*       brute force method:
*           iterate over the linked list and find it's length
*           then iterate over the linked list again length / 2 times and return the current node
*
*       TC = O(n) for computing length + O(n/2) for finding the middle
*       SC = O(1)
*
*       optimized method: tortoise method
*           take 2 pointers: slow and fast
*           traverse the linked list, for every traversal, move the fast pointer 2 steps, and move the slow pointer 1 step
*           do this until the fast pointer is null
*           return slow pointer
*
*       TC = O(N/2), since fast pointer moves 2 steps
*       SC = O(1)
* */

public class D5MiddleOfLinkedList {

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

//  brute force method
    public static ListNode method1(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while(curr != null) {
            n++;
            curr = curr.next;
        }
        n = n/2;
        curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        return curr;
    }

//  optimized method
    public static ListNode method2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        display(l1);
        System.out.println("null");

        ListNode middle1 = method1(l1);
        System.out.printf("middle (brute force method) = %d%n", middle1.data);
        ListNode middle2 = method2(l1);
        System.out.printf("middle (optimized method) = %d", middle2.data);
    }
}
