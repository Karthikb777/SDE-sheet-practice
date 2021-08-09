package DSAprep;

import java.util.HashSet;

/*
*       detect cycle in a linked list
*           given a linked list, detect if a cycle in a linked list
*
*       brute force method: using hashing
*           use a hashset
*           while traversing the linked list, check if the node is in the hashset
*               if yes, return true because it indicates that a cycle exists in the LL
*               if no, add the node to the hashset and move on to the next node
*
*       TC - O(N), SC -O(N) because of the use of hashset
*
*       optimized method: using slow and fast pointers
*           take 2 pointers - slow and fast and point them to the head
*           while fast is not null, iterate
*               move slow pointer one step
*               move fast pointer two steps
*               check if slow == fast, if yes, return true, this indicates that a cycle exists
*                   because the fast pointer will eventually catch up to the slow pointer
*
*       TC - O(N) SC - O(1)
*
* */

public class D6cycleInALL {

//    brute force - using hashing
    public static boolean detectCycleUsingHashing(LLNode head) {
        if (head == null || head.next == null) return false;

        HashSet<LLNode> set = new HashSet<>();

        LLNode curr = head;

        while (curr != null) {
            if (set.contains(curr)) return true;
            set.add(curr);
            curr = curr.next;
        }

        return false;
    }

//    optimized
    public static boolean detectCycle(LLNode head) {
        if (head == null || head.next == null) return false;

        LLNode slow, fast;
        slow = fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LLNode a = new LLNode(1);
        LLNode b = new LLNode(1);
        LLNode c = new LLNode(1);
        LLNode d = new LLNode(1);
        LLNode e = new LLNode(1);
        LLNode f = new LLNode(1);
        LLNode g = new LLNode(1);
        LLNode h = new LLNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
//        g.next = d;

        System.out.println(detectCycleUsingHashing(a));
    }
}
