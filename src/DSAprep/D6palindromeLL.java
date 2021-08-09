package DSAprep;

/*
*       check if a LL is a palindrome or not:
*           steps:
*               find the middle of the linked list
*               reverse the LL from the middle to the end
*               compare the left and right halves
*
*       TC - O(n/2) to find the middle of LL
*          + O(n/2) to reverse the LL from the middle
*          + O(n/2) to check if the LL is a palindrome
*       SC - O(1)
* */

public class D6palindromeLL {

    public static boolean isPalindrome(LLNode head) {
//        take care of edge cases
        if (head == null || head.next == null) return false;

//        find the middle of the linked list
        LLNode slow, fast;
        slow = fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

//        reverse the right half of the LL
        slow.next = reverseLL(slow.next);

//        move slow to slow.next i.e head of the reversed part
        slow = slow.next;

//        compare the left and right halves
        while (slow != null) {
            if (head.data != slow.data) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

//    method to reverse a LL
    public static LLNode reverseLL(LLNode head) {
        LLNode temp = null;
        while (head != null) {
            LLNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }

    public static void main(String[] args) {
        LLNode a = new LLNode(1);
        LLNode b = new LLNode(2);
        LLNode c = new LLNode(3);
        LLNode d = new LLNode(4);
        LLNode e = new LLNode(3);
        LLNode f = new LLNode(2);
        LLNode g = new LLNode(1);
//        LLNode h = new LLNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
//        g.next = h;

        System.out.println(isPalindrome(a));
    }
}
