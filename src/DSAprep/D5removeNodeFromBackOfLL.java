package DSAprep;

/*
*       remove node from the back of the linked list:
*
*       brute force method:
*           find the length of the LL
*           then do n = len - pos
*           iterate again n times and delete the node at position n
*       TC O(n) for computing length + O(n) for deletion, SC O(1)
*
*       optimized:
*           take 2 pointers, fast and slow and assign head to them
*           move fast pointers n times, where n is the pos given
*           after that move fast and slow pointers one step in each iteration until fast is the last node
*           delete slow.next
*       TC O(n), SC O(1)
* */

public class D5removeNodeFromBackOfLL {
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

//    brute force method
    public static ListNode method1(ListNode head, int pos) {
        if (head == null || head.next == null) return head;
        int len = 0;

//        compute the length of the linked list
        ListNode curr = head;
        while (curr != null) {
            len += 1;
            curr = curr.next;
        }

        int n = len - pos;
        curr = head;

//        placing the curr at one node before the node to be deleted
        for (int i = 0; i < n - 1; i++) {
            curr = curr.next;
        }

//        deleting the node at the specified position from the back
        curr.next = curr.next.next;

        return head;
    }

//    optimized method
    public static ListNode method2(ListNode head, int pos) {
//        take care of edge cases
        if (head == null || head.next == null) return head;

//        set temp, slow and fast as head
        ListNode temp = head;
        ListNode slow, fast;
        slow = fast = head;

//        move fast pointer n times
        for (int i = 0; i < pos && fast.next != null; i++) {
            fast = fast.next;
        }

//        move both slow and fast pointers 1 step in each iteration
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

//        delete slow.next
        slow.next = slow.next.next;

        return temp;
    }

    public static void display(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
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

        System.out.println("before deleting:");
        display(l1);
        System.out.println("null");
        method2(l1, 5);
        System.out.println("after deleting:");
        display(l1);
        System.out.println("null");
    }
}
