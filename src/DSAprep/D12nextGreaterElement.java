package DSAprep;

/*
*       next greater element:
*           given an array of numbers, return an array of the next greater element of that number. if there's no
*           greater element to the right of that number, then loop back to the start and check for a greater element.
*
*           brute force method:
*               run 2 for loops
*
*           optimized method:
*               using stack
*               take a stack
*               iterate from the end of the array
*               check if stack is not empty and the stack top is lte element
*                   if yes, then pop from stack
*                   loop until above condition is met
*               check if i < n
*                   check if stack is not empty, if yes, then set nge[i] = stack top
*                   else set nge[i] = -1
*               push the element into the stack
*               return nge array
*
*           TC - O(2n + 2n)
*           SC - O(1)
* */

import java.util.Arrays;
import java.util.Stack;

public class D12nextGreaterElement {

    public static int[] brute(int[] arr) {
        int n = arr.length;

        int[] nge = new int[n];
        Arrays.fill(nge, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    nge[i] = arr[j];
                    break;
                }
            }
        }

        return nge;
    }

    public static int[] optimal(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 2*n - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() <= arr[i%n]) stack.pop();
            if (i < n) {
                if (!stack.isEmpty()) {
                    nge[i] = stack.peek();
                } else nge[i] = -1;
            }
            stack.push(arr[i%n]);
        }

        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 6, 2, 10, 9};
        for (int i : optimal(arr)) {
            System.out.print(i + "  ");
        }
    }
}
