package DSAprep;

/*
*   merge two sorted linked lists:
*       method 1: generating a new LL
*           TC O(n + m), SC O(n + m), if length of LL1 = n and LL2 = m
*
*       method 2: sorting in place
*           step 1: compare the data of the 2 heads, and assign the head with the
*               lowest value to l1 and the other head to r1.
*           step 2: take a new variable res and assign l1 to it. (this is used to return the head later)
*           step 3: do iterations while both l1 and r1 are not null
*               take a new variable temp and assign null to it.
*               do iterations while l1 is not null and l1.data <= r1.data
*                   assign l1 to temp
*                   do l1 = l1.next
*               at this point l1.data will be greater than l2.data,
*               so, we point prev of l1 to r1,
*               therefore, do temp.next = r1
*               then swap l1 and r1, this ensures that l1 will always be the lower value node
*          finally, return res
*
*          TC O(n + m), SC O(1)
**/

public class D5MergeTwoSortedLists {
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

//        in place sorting
    public static ListNode mergeSortedLists(ListNode l1, ListNode r1) {
//        take care of the edge cases
        if (l1 == null) return r1;
        if (r1 == null) return l1;

//        swap l1 and r1 if l1 is greater than r1 (ensuring that l1 is always the smaller value)
        if (l1.data > r1.data) {
            ListNode temp = l1;
            l1 = r1;
            r1 = temp;
        }

//       to return head at the end of the method
        ListNode res = l1;

        while (l1 != null && r1 != null) {
            ListNode temp = null;

//            every time l1 moves one node ahead, temp will be the previous node of l1
            while (l1 != null && l1.data <= r1.data) {
                temp = l1;
                l1 = l1.next;
            }

//            setting prev of l1 i.e temp's next to r1
            temp.next = r1;

//            swapping l1 and r1
            ListNode temp2 = l1;
            l1 = r1;
            r1 = temp2;

        }

        return res;
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
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(10);
        ListNode l6 = new ListNode(12);

        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(8);
        ListNode r4 = new ListNode(9);
        ListNode r5 = new ListNode(11);
        ListNode r6 = new ListNode(13);
        ListNode r7 = new ListNode(14);
        ListNode r8 = new ListNode(15);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r5.next = r6;
        r6.next = r7;
        r7.next = r8;

        display(l1);
        System.out.println("null");
        display(r1);
        System.out.println("null");

        ListNode head = mergeSortedLists(l1, r1);
        display(head);
        System.out.println("null");
    }
}
