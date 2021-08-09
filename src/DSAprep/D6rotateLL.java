package DSAprep;

/*
*       rotate the LL:
*           input:  1 -> 2 -> 3 -> 4 -> 5 -> null, k = 2
*           output: 4 -> 5 -> 1 -> 2 -> 3 -> null
*
*       brute force solution:
*           go to the end of the LL and take the last node and put it at the front of the LL and make it the head.
*           do this k times
*       TC - O(k x n), n for traversing to the last node, k x n for doing it k times
*       SC - O(1)
*
*       optimized solution:
*           compute the length of the LL
*           point the last node to the head [last.next = head]
*           do k = k % len
*           do k = len - k
*           traverse the LL k times using the curr pointer
*           take head and point it to curr.next
*           then do curr.next = null to break the link
*       TC - O(n) to compute the length of LL + O(n - (n % k)) to rotate the LL
*       So, TC is almost equal to O(n)
*       SC - O(1)
* */

public class D6rotateLL {

//    optimized solution
    public static LLNode rotateLL(LLNode head, int k) {
//        take care of edge cases
        if (head == null || head.next == null || k == 0) return head;

//        compute the length of the LL
        LLNode curr = head;
        int len = 1;
        while (curr.next != null) {
            len += 1;
            curr = curr.next;
        }

//        link curr.next to head
        curr.next = head;

//        do rotation
//        we are doing k % len because k might be greater than len and if we rotate the LL k = len times, we get back the
//        original LL, so we do k % len to eliminate the duplicate rotations
        k = k % len;
        k = len - k;

//        traverse the LL k times
        while (k-- > 0) {
            curr = curr.next;
        }

//        make curr.next as the new head and break the link between curr and curr.next
        head = curr.next;
        curr.next = null;

        return head;
    }

//    brute force solution
    public static LLNode rotateBruteForce(LLNode head, int k) {
//        take care of edge cases
        if (head == null || head.next == null || k == 0) return head;

//        loop k times
        for (int i = 0; i < k; i++) {
            LLNode prev, curr;
            prev = curr = head;

//            go to the end of the LL
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

//            link curr and head and set curr as head, then cut the link between prev and curr
//            this makes curr the head node and prev as the last node
            curr.next = head;
            head = curr;
            prev.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        LLNode head = LLNode.generateLL(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        System.out.println("before rotation");
        LLNode.displayLL(head);
        head = rotateBruteForce(head, k);
        System.out.println("after rotation");
        LLNode.displayLL(head);

    }
}
