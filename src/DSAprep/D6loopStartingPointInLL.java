package DSAprep;

/*
*       find the starting point of a loop in a linked list:
*
*           brute force method: using hashing
*               take a hashset
*               traverse the LL and while traversing, check if node is in set
*                   if yes, that's the starting point of the LL
*                   if no, add the node to the set and move on
*
*           TC - O(n)
*           SC - O(n) due to use of hashset
*
*           optimal solution:
*               check if there is a loop in the given LL using slow-fast pointer method
*               when slow and fast meet, move slow to head and keep fast at it's current position
*               move slow and fast pointer both one step at a time until slow == fast
*               the node that they meet is the starting point of the LL, so return the node
*
*       TC - near about O(n)
*       SC - O(1)
*
*       intuition behind the algorithm:
*           refer to the notes for the explanation
* */

public class D6loopStartingPointInLL {

    public static LLNode startingPoint(LLNode head) {
//        take care of edge cases
        if (head == null || head.next == null) return null;

//        detect if there is a loop in the LL
        LLNode slow, fast;
        slow = fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

//        place the slow pointer at the head and move both slow and fast pointers one step at a time till they meet
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

//        the node where slow and fast meet is the starting point of the LL, so return the node
        return slow;
    }

    public static void main(String[] args) {
        LLNode a = new LLNode(1);
        LLNode b = new LLNode(2);
        LLNode c = new LLNode(3);
        LLNode d = new LLNode(4);
        LLNode e = new LLNode(5);
        LLNode f = new LLNode(6);
        LLNode g = new LLNode(7);
        LLNode h = new LLNode(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = d;

        System.out.println(startingPoint(a).data);
    }
}
