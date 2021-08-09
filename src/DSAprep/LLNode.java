package DSAprep;

public class LLNode {
    int data;
    LLNode next;

//    constructor
    public LLNode(int data) {
        this.data = data;
        this.next = null;
    }

//    generates a new LL from the given array and returns the head of that LL
    public static LLNode generateLL(int[] data) {
        LLNode curr = new LLNode(0);
        LLNode res = curr;
        LLNode temp = null;
        for (int i : data) {
            temp = new LLNode(i);
            curr.next = temp;
            curr = temp;
        }
        return res.next;
    }

//    displays the LL
    public static void displayLL(LLNode head) {
        LLNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
