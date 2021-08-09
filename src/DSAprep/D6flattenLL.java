package DSAprep;

import java.util.Arrays;

/*
*       flatten a LL:
*
*       input:
*       1 -> 2 -> 50  -> 111
*       3    4    100    222
*       5    7    150
*            10   200
*            11
*
*       result: 1 2 3 4 5 7 10 11 50 100 111 150 200 222 (not node.next but node.bottom)
*
*           steps:
*               basically, go to the end of the LL and start merging the last two LLs
*               do this until you reach the start of the LL
*
*           flatten method:
*               if head is null or the last node (head.next is null) return head
*               recursively call flatten for head.next and store it in head.next
*               then call merge method for head and head.next and store it in head
*               finally return head
*
*           merge method:
*               standard merge 2 LLs method
*
*       TC - O(x) where x is the total number of nodes
*       SC - O(1)
* */

public class D6flattenLL {

    static class LLbottom {
        int data;
        LLbottom next;
        LLbottom bottom;

        public LLbottom(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

//    helper method to create LL from the given data
    public static LLbottom createLL(int[] data) {
        LLbottom res = new LLbottom(0);
        LLbottom temp = res;
        for (int ele : data) {
            LLbottom newNode = new LLbottom(ele);
            temp.bottom = newNode;
            temp = temp.bottom;
        }
        return  res.bottom;
    }

//    method to merge 2 sorted LLs
    public static LLbottom mergeLL(LLbottom a, LLbottom b) {
        LLbottom temp = new LLbottom(0);
        LLbottom res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a != null) temp.bottom = a;
        else temp.bottom = b;

        return res.bottom;
    }

//    method to flatten LLs
    public static LLbottom flatten(LLbottom head) {
//        if head is null or the last node, return head
        if (head == null || head.next == null) return head;

//        recur for the list on the right
        head.next = flatten(head.next);

//        merge the current LL and the next LL
        head = mergeLL(head, head.next);

//        return the head of the current LL, which is merged with the next LL
        return head;
    }

    public static void main(String[] args) {
//        data for the LLs
        int[] ll1 = {1, 3, 40, 93, 22};
        int[] ll2 = {34, 845, 734, 93, 3, 11, 53, 100};
        int[] ll3 = {900, 800, 700, 600};
        int[] ll4 = {250, 255, 260, 265, 270};

//        sorting the data
        Arrays.sort(ll1);
        Arrays.sort(ll2);
        Arrays.sort(ll3);
        Arrays.sort(ll4);

//        creating the LLs from the data
        LLbottom head1 = createLL(ll1);
        LLbottom head2 = createLL(ll2);
        LLbottom head3 = createLL(ll3);
        LLbottom head4 = createLL(ll4);

//        making the links for the next
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

//        flattening operation
        LLbottom temp = flatten(head1);

        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.bottom;
        }
    }
}
