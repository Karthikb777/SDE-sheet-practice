package DSAprep;

/*
*       reverse LL in groups:
*
*           optimal solution:
*               take a dummy node and point dummy.next to head
*               take 3 pointers, pre, curr, nex and point them to dummy
*               calculate the length of the LL
*               loop while len(LL) >= k
*                   set curr = pre.next
*                   set nex = curr.next
*                   loop k - 1 times ( for(i = 1; i < k; i++) )
*                       set curr.next = nex.next
*                       set nex.next = pre.next
*                       set pre.next = next
*                       set next = curr.next
*                   then set pre = curr
*                   decrement count k times (count = count - k)
*               return dummy.next
*
*           TC - O((n/k) * k) = O(n)
*           SC - O(1)
* */

public class D6reverseLLinGroups {

    public static LLNode reverseInGroups(LLNode head, int k) {
        if (head == null || k == 0) return head;

        LLNode dummy = new LLNode(0);
        dummy.next = head;

        LLNode curr, nex, pre;
        curr = nex = pre = dummy;

        LLNode temp = head;
        int count = 0;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }

        while (count >= k) {
            curr = pre.next;
            nex = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }

            pre = curr;
            count -= k;
        }
        return dummy.next;
    }

    public static void displayLL(LLNode head) {
        LLNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] src = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LLNode head = LLNode.generateLL(src);
        displayLL(head);
        head = reverseInGroups(head, 4);
        displayLL(head);
    }
}
