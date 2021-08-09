package DSAprep;

import java.util.HashSet;

/*
*       given a Y linked list, find the intersection point of the Y LL:
*           optimized method:
*               take 2 pointers a and b
*               assign l1 to a and l2 to b
*               loop while a is not null or b is not null
*                   check if a is null, if yes, assign l2 to a, if no, do a.next
*                   check if b is null, if yes, assign l1 to b, if no, do b.next
*                   if a == b return a
*               basically when we reach the end of LL from one head, we again start traversing the LL from the other head
*           TC - O(n + m)
*           SC - O(1)
*
*       brute force method: using hashing
*           take a hashset, use it to hash the actual nodes
*           iterate over l1 and add all the nodes into the hashset
*           iterate over l2 and for every node,
*               check if the node is in hashset,
*                   if yes, intersection is present, return the node
*
*           TC - O(n + m), SC - O(n + m) due to use of a hashset
*
**/
public class D6findIntersectionPointOfYLL {

//    brute force method
    public static LLNode bruteForceMethod(LLNode l1, LLNode l2) {
        if (l1 == null || l2 == null) return null;

        HashSet<LLNode> set = new HashSet<>();

        LLNode a = l1, b = l2;
        while (a != null) {
            set.add(a);
            a = a.next;
        }

        while (b != null) {
            if (set.contains(b)) return b;
            b = b.next;
        }

        return null;
    }

//    optimized method
    public static LLNode findIntersection(LLNode l1, LLNode l2) {
        if (l1 == null || l2 == null) return null;

        LLNode a = l1;
        LLNode b = l2;

        while (a != null || b != null) {
            a = a == null ? l2 : a.next;
            b = b == null ? l1 : b.next;
            if (a == b) return a;
        }

        return null;
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
        LLNode i = new LLNode(9);
        LLNode j = new LLNode(10);
        LLNode k = new LLNode(11);
        LLNode l = new LLNode(12);
        LLNode m = new LLNode(13);
        LLNode n = new LLNode(14);
        LLNode o = new LLNode(15);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = l;

        i.next = j;
        j.next = k;
        k.next = l;
        l.next = m;
        m.next = n;
        n.next = o;

        System.out.printf("the intersection point of the 2 LLs is: %d", findIntersection(a, i).data);
//        below code is just to test the generateLL method
//        LLNode head = LLNode.generateLL(new int[]{1, 2, 3, 4});
//        while (head != null) {
//            System.out.println(head.data);
//            head = head.next;
//        }
    }
}
