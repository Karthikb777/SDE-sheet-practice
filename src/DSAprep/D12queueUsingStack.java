package DSAprep;

import java.util.Stack;

/*
*       implementation of queue using stacks:
*           method 1:
*               enqueue operation:
*                   add all elements of stack1 to stack2
*                   add the element to stack1
*                   add all elements of stack2 to stack1
*
*               dequeue operation:
*                   return s1.pop
*
*               front operation:
*                   return s1.peek
*
*           method 2:
*               enqueue operation:
*                   add the element to input stack
*
*               dequeue operation:
*                   if output stack is not empty then pop from output stack
*                   else add all the elements from input stack to output stack and then pop from output stack
*
*               front operation:
*                   if output stack is not empty then return top of output stack
*                   else add all the elements of input stack into output stack and then return the top of the output stack
*
*               TC - O(1) amortized i.e O(n) but most of the times it will be O(1) and very few times it's O(n)
*               SC - O(2n)
* */

public class D12queueUsingStack {

//    method 1:
    static class queue1 {
        private Stack<Integer> s1, s2;

        public queue1() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void enQueue(int element) {

//            add all elements of s1 to s2
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

//            add the element to s1
            s1.push(element);

//            add all elements of s2 to s1
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int deQueue() {
            if (!s1.isEmpty()) return s1.pop();
            else return -1;
        }

        public int front() {
            if (!s1.isEmpty()) return s1.peek();
            else return -1;
        }
}

    static class queue2 {
        private Stack<Integer> input, output;

        public queue2() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void enQueue(int element) {
            input.push(element);
        }

        public int deQueue() {
            if (!output.isEmpty()) return output.pop();
            else {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
                return output.pop();
            }
        }

        public int front() {
            if (!output.isEmpty()) return output.peek();
            else {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
                return output.peek();
            }
        }
    }
    public static void main(String[] args) {
        queue2 q = new queue2();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.front());
        System.out.println("dequeueing");
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
