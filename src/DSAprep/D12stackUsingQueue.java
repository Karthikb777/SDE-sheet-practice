package DSAprep;

/*
*           implementation of stack using queue:
*
*               method 1: using 2 queues
*                   take 2 queues q1 and q2
*                   push operation:
*                       add the element to q2
*                       add all the elements one by one from q1 to q2
*                       swap q1 and q2
*
*                   pop operation:
*                       return q1.poll()
*
*                   top operation:
*                       return q1.peek()
*
*               method 2: using a single queue
*                   push operation:
*                       add the element to the queue
*                       add all the elements in the front of the currently added element back to the queue and remove them
*                       i.e run a loop for q.size - 1 times and add the front of queue to the queue and remove it
*
*                   pop operation:
*                       remove and return q.front()
*
*                   peek operation:
*                       return q.front()
* */

import java.util.ArrayDeque;
import java.util.Queue;

public class D12stackUsingQueue {

//    method 1: stack using 2 queues
    static class StackFromQueue {
        private Queue<Integer> q1, q2;

        public StackFromQueue() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        public void push(int element) {
//            add the element to q2
            q2.offer(element);

//            add all elements of q1 to q2
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

//            swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            if (!q1.isEmpty())
            return q1.poll();
            else return -1;
        }

        public int peek() {
            if (!q1.isEmpty())
            return q1.peek();
            else return -1;
        }
    }

//    method 2: stack using a single queue
    static class StackOptimized {
        private Queue<Integer> q;

        public StackOptimized() {
            q = new ArrayDeque<>();
        }

        public void push(int element) {
            q.offer(element);
            for (int i = 0; i < q.size()-1; i++) {
                q.offer(q.poll());
            }
        }

        public int pop() {
            if (!q.isEmpty()) return q.poll();
            else return -1;
        }

        public int peek() {
            if (!q.isEmpty()) return q.peek();
            else return -1;
        }
    }

    public static void main(String[] args) {
        StackFromQueue stack = new StackFromQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
