package DSAprep;

/*
*       subset sums 1:
*           given a set, generate the subset sums and return them in a sorted list
*           recursive method:
*               base case:
*                   if the index is overflowing, add the current sum to the list and then return
*               there are 2 ways this recursive call will go: picking the index or not picking the index
*               while calling the picking the index call, add the value at the current index to the sum and call the func
*               while calling the not picking the index call, just pass the params, don't add anything to the sum
*
*       TC - O(2^n) for recursive calls + O(2^nlog2^n) for sorting
*       SC - O(2n)
*
*           power set method:
*               there also exists a power set method, that will be done after power set has been completed
*
* */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class D9subsetSum {
    public static void recursiveFunc(int index, int sum, int n, List<Integer> subsetSums, int[] set) {
//        base case: if the index is overflowing out of the list, add the current sum to the list and return
        if (index == n) {
            subsetSums.add(sum);
            return;
        }

//        picking an index
//        while picking an index, add the value at that index to the sum and call the function
        recursiveFunc(index+1, sum + set[index], n, subsetSums, set);

//        not picking an index
        recursiveFunc(index+1, sum, n, subsetSums, set);

//        in both cases: picking or not picking an index, we need to move the pointer to the next position
//        that's why we are doing index+1 in both the cases
    }

    public static List<Integer> sums(int[] set) {
        int n = set.length;
        List<Integer> subsetSum = new LinkedList<>();
        int sum = 0;

//        call the recursive function
        recursiveFunc(0, sum, n, subsetSum, set);

//        sort the list
        Collections.sort(subsetSum);

//        return the list of subset sums
        return subsetSum;
    }
    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        List<Integer> subsetSums = sums(set);
        for (int i :
                subsetSums) {
            System.out.print(i + " ");
        }
    }
}
