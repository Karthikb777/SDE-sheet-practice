package DSAprep;

/*
*       largest rectangle in histogram:
*           given an array representing a histogram, find the area of the largest rectangle
*
*           two pass method:
*               find the left smallest element for all indices of the array
*               find the right smallest element for all the indices of the array
*               find the largest rectangle area by doing the calculation as follows:
*                   area = [ rightSmallest - leftSmallest + 1 ] * arr[i]
*               return the max area
*
*               use the next greater element approach to find the left and right smaller element for each array element
*               in the stack, store the indices of the elements instead of the elements themselves
*               insert the index into the leftSmaller and rightSmaller arrays
*
*               TC - O(n) + O(n) for computing the left smaller elements
*                  + O(n) + O(n) for computing the right smaller elements
*                  + O(n) for computing the area for every element in the array
*                   = O(5n) = O(n)
*
*               O(n) + O(n) for computing each smaller element is because, O(n) for iteration and another O(n)
*               for pushing and popping elements from the stack [worst case, we have to do n poppings from the stack]
*
*               an optimization can be made that is to calculate the area in the right smaller element loop only, which
*               reduces the complexity to O(4n)
*
*               SC - O(n) + O(n) to store the left and right smaller elements
*
*               another method that can compute the max area in one pass exists and is done in a separate problem to avoid confusions
*
* */

import java.util.Stack;

public class D13largestRectInHistogram_twopass {
    public static int largestRectangle(int[] histogram) {
        int maxArea = 0;
        int n = histogram.length;

        int[] leftSmallest = new int[n];
        int[] rightSmallest = new int[n];

        Stack<Integer> stack = new Stack<>();

//        find the left smallest element for all indices in the histogram
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) leftSmallest[i] = 0;
            else leftSmallest[i] = stack.peek() + 1;

            stack.push(i);
        }

//        empty the stack to use it for the right smallest element
        while (!stack.isEmpty()) stack.pop();

//        find the right smallest element for all indices in the histogram
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) rightSmallest[i] = n - 1;
            else rightSmallest[i] = stack.peek() - 1;

            stack.push(i);
        }

//        finally compute the max area of the rectangle in the histogram
        for (int i = 0; i < n; i++) {
            int area = (rightSmallest[i] - leftSmallest[i] + 1) * histogram[i];
            maxArea = Math.max(maxArea, area);
        }

//        an optimization can be made to compute the area in the right smaller element loop only, thereby eliminating one for loop entirely
//        that optimization is not done here.

        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = {1, 3, 2, 5, 6, 3, 1, 2};
        int max = largestRectangle(histogram);
        System.out.println(max);
    }
}
