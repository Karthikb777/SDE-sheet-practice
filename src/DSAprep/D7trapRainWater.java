package DSAprep;

/*
*       trapping rain water:
*           brute force solution:
*               for every index, calculate the unit of water it holds
*               for every index, find the max element on the left, and the max element on the right
*               and add the min(maxLeft and maxRight) - element at index to res
*               return res
*
*           TC - O(n^2) because for every element, we are iterating the entire array to find the maxLeft and maxRight
*           SC - O(1)
*
*           better solution:
*               using prefix and suffix arrays
*               first fill the prefix and suffix array by calculating the prefix max and suffix max for each index
*               then update res by adding the result of min(prefix[i] and suffix[i]) - arr[i] to res
*               return res
*
*           TC - O(n) for calculating prefix max for every index
*              + O(n) for calculating suffix max for every index
*              + O(n) for updating res
*
*           TC - O(3n) ~= O(n)
*
*           SC - O(n) for prefix max array
*              + O(n) for suffix max array
*
*           SC - O(2n) ~= O(n)
*
*           optimal solution:
*               using 2 pointer approach
*               take 2 pointers, left and right
*               set left pointer to start and right pointer to end
*               loop while left doesn't cross right
*                   check if left element is less than right element
*                       if yes, check if left element is gte than maxLeft,
*                           if yes, update maxLeft with left element
*                           if no, add maxLeft - left element to res
*                           do left++
*                   else
*                       check if right element is greater than maxRight
*                           if yes, update maxRight with right element
*                           if no, add maxRight - right element to res
*                           do right--
*               return res
*
*               TC - O(n)
*               SC - O(1)
* */
public class D7trapRainWater {
//    brute force solution
    public static int brute(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {

//            find max element on left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

//            find max element on right
            int right = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                right = Math.max(right, arr[j]);
            }

//            update res value
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }

//    better solution
    public static int better(int[] arr) {
        int n = arr.length;
        int res = 0;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

//        fill prefix max array
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
//        fill suffix max array
        suffix[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i+1], arr[i]);
        }

//        calculate the result
        for (int i = 0; i < n; i++) {
            res += Math.min(prefix[i], suffix[i]) - arr[i];
        }

        return res;
    }

//    optimal solution
    public static int optimal(int[] arr) {
        int res = 0;
        int n = arr.length;
//        take 2 pointers, left and right
//        place left at first index and right at last index
        int left = 0, right = n-1;
//        take 2 vars, maxLeft and maxRight, self explanatory
        int maxLeft = 0, maxRight = 0;

//        loop while left doesn't cross right pointer
        while (left <= right) {
//            check if left is less than or equal to right
            if (arr[left] <= arr[right]) {
//                if left element is greater than or equal to maxLeft, set maxLeft = left element
//                i.e updating the maximum left element
                if (arr[left] >= maxLeft) maxLeft = arr[left];
//                else add the diff of maxLeft and left element to res
                else res += maxLeft - arr[left];

//                move left pointer one step ahead
                left++;
            }
            else {
//                check if right element is greater than or equal to maxRight, set maxRight to right element
//                i.e updating the maximum right element
                if (arr[right] >= maxRight) maxRight = arr[right];
//                else add the difference of maxRight and right element to res
                else res += maxRight - arr[right];

//                move right pointer one step back
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(optimal(arr));
    }
}
