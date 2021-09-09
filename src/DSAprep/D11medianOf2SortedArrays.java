package DSAprep;

/*
*       find the median of 2 sorted arrays:
*           brute force method:
*               merge both the arrays and find the median
*
*           optimized method: using binary search
*               cutting the 2 arrays such that a condition is met
*               take the search space as 0 to length of longest array
*
*               cut both the arrays as follows
*                   cut1 will be our mid
*                   cut2 will be (n1 + n2 + 1) / 2 - cut1
*
*                   place l1, r1, l2, r2 according to the cuts made
*                   l1 will be one index before the cut, l2 will be the index of the cut
*                   r1 will be one index before the cut, r2 will be the index of the cut
*
*                   if l1 <= r2 and l2 <= r1,
*                       then we made the cuts perfectly, so return max of left + min of right / 2
*                   else if l1 > r2, then, shrink the search space by moving leftwards i.e high = cut1 - 1
*                   else shrink the search space rightwards by doing low = cut2 + 1
*
*           TC - O(log min(n1, n2))
*           SC - O(1)
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D11medianOf2SortedArrays {
//    brute force method
    public static int brute(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();
        for (int i : arr1) {
            res.add(i);
        }
        for (int i : arr2) {
            res.add(i);
        }

        Collections.sort(res);

        return res.get(res.size() / 2);
    }

//    optimized method
    public static int optimized(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

//        we always take the longest array as n1 so we make sure n1 is the longest array
        if (n1 < n2) optimized(arr2, arr1);

//        defining the search space - [0 ..... n1]
        int high, low;
        low = 0;
        high = n1;

//        defining the pointers - left1, right1, left2, right2
        int l1, r1, l2, r2;

//        while low doesn't cross high
        while(low <= high) {
//            calculating our cuts
//            cut1 will be our mid
            int cut1 = (low + high) / 2;
//            we calculate cut2 as shown below
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

//            place all the pointers according to the cuts while handling the edge cases
            l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];

//            if the below condition is satisfied, then we have placed our cuts perfectly
//            we return the max of left of cuts + min of right of cuts / 2
            if (l1 <= r2 && l2 <= r1) {
//                if even length
                if ((n1 + n2) % 2 == 0) return (Math.max(l1, r1) + Math.min(l2, r2)) / 2;
//                if odd length
                else return Math.max(l1, l2);
            }
//            if l1 > r2, shrink the search space by moving leftwards
            else if (l1 > r2) high = cut1 - 1;
//            move rightwards
            else low = cut1 + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 7};
        int[] b = {3, 6, 9};
        System.out.println(optimized(a, b));
    }
}
