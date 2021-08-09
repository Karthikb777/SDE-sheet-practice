package DSAprep;

/*
*       add two numbers as a linked list
*           only optimal solution:
*               explained in the function itself
*               TC - O(max(l1, l2)), SC - O(n) to create a new LL for the result
* */

public class D5addTwoNumsAsLL {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static LLNode addLL(Node a, Node b) {
//      initialize a dummy node to point to the head of the result
        LLNode temp = new LLNode(0);
        LLNode curr = temp;

        int carry = 0;

        while (a != null || b != null || carry != 0) {
//          initialize sum
            int sum = 0;
//          if a is not null, add a.data to sum and move a one step ahead
            if (a != null) {
                sum += a.data;
                a = a.next;
            }
//          if b is not null, add b.data to sum and move b one step ahead
            if (b != null) {
                sum += b.data;
                b = b.next;
            }
//          finally add carry to sum (carry from the previous addition)
            sum += carry;
//          calculate carry
            carry = sum / 10;
//          initialize a new node and set sum % 10 as it's data
            LLNode newNode = new LLNode(sum % 10);
//          set the new node as the curr's next node
            curr.next = newNode;
//          move the curr node one step ahead
            curr = curr.next;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(0);
        Node l2 = new Node(0);
        Node l3 = new Node(0);
        Node l4 = new Node(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        Node r1 = new Node(0);
        Node r2 = new Node(0);
        Node r3 = new Node(1);

        r1.next = r2;
        r2.next = r3;

        LLNode res = addLL(l1, r1);
        while (res != null) {
            System.out.print(res.data);
            res = res.next;
        }

    }
}
