package DSAprep;

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

        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = {1, 3, 2, 5, 6, 3, 1, 2};
        int max = largestRectangle(histogram);
        System.out.println(max);
    }
}
