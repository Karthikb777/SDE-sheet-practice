package DSAprep;

import java.util.HashMap;

/*
*       clone a LL with random and next pointers:
*           brute force method: using hashmap
*               take a hashmap
*               traverse the LL, for every node, create a new LL, copy the data of the node to the copy
*               and hash the node and it's copy in the hashmap
*               traverse the LL again, for every node, take it's copy from the hashmap
*               and connect the random and next pointers to the copy of the nodes of the random and next pointers
*               of the current node
*               return the head of the copy of the cloned LL
*       TC - O(n) to traverse the LL and hash the node and it's copy
*          + O(n) to traverse the LL and connect the next and random pointers
*       SC - O(n) due to use of hashmap
*
*           optimal solution:
*               consists of 3 steps:
*                   step 1: for every node, create a copy of the node and insert it next to the current node
*                   step 2: connect the random pointers of the copies of the nodes
*                   step 3: separate the LL into the original LL and the new clone LL
*
*
*
* */

public class D7cloneLL {

    static class RandomLL {
        int data;
        RandomLL next;
        RandomLL random;

        public RandomLL(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static RandomLL cloneBruteForce(RandomLL head) {
//        take a hashmap
        HashMap<RandomLL, RandomLL> map = new HashMap<>();

//        for every node, create a copy and hash both the node and it's copy in the map
        RandomLL curr = head;
        while (curr != null) {
            RandomLL copy = new RandomLL(curr.data);
            map.put(curr, copy);
            curr = curr.next;
        }

//        iterate over the LL again, for every node, connect random and next pointers
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
//        return the head of the cloned LL
        return map.get(head);
    }

//    optimized solution
    public static RandomLL cloneLLoptimized(RandomLL head) {
        RandomLL curr = head;

//        for every node, create a copy and insert it next to the current node
        while (curr != null) {
            RandomLL copy = new RandomLL(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }

//        connect the random pointers of the copies
        curr = head;
        while (curr != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }

//        seperate the LL into the original and copies LLs
        curr = head;
        RandomLL front;
        RandomLL res = new RandomLL(0);
        RandomLL copy = res;

        while (curr != null) {
            front = curr.next.next;
            copy.next = curr.next;
            curr.next = front;
            copy = copy.next;
            curr = curr.next;
        }

//        TODO: return the head of the copied LL
        return res.next;
    }

    public static void main(String[] args) {
        RandomLL a = new RandomLL(1);
        RandomLL b = new RandomLL(2);
        RandomLL c = new RandomLL(3);
        RandomLL d = new RandomLL(4);
        RandomLL e = new RandomLL(5);

//        linking LLs
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

//        linking random pointers
        a.random = c;
        b.random = null;
        c.random = b;
        d.random = a;
        e.random = d;

        RandomLL copyHead = cloneLLoptimized(a);
        while (copyHead != null) {
            int randomData = copyHead.random != null ? copyHead.random.data : -1;
            System.out.println("data: " + copyHead.data + " random: " + randomData);
            copyHead = copyHead.next;
        }
    }
}
