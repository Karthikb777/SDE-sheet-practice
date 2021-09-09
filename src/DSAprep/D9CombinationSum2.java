package DSAprep;

/*
*       Given a collection of candidate numbers (candidates) and a target number (target),
*        find all unique combinations in candidates where the candidate numbers sum to target.
*        Each number in candidates may only be used once in the combination.
*        Note: The solution set must not contain duplicate combinations.
*
*       recursive solution:
*           base case:
*               if target == 0:
*                   then that's a combination, add it to the ans and return
*
*           for every index starting from ind to the end of arr,
*               process duplicates
*               if arr[i] is gt target, break
*
*               add the arr[i] to ds
*               call the recursive method for the next index, while updating the target to target - arr[i]
*               remove the added element from the ds to facilitate for the next iteration
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D9CombinationSum2 {

    private static void recur(int index, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
//        base case
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

//        call recur for every index
            for (int i = index; i < arr.length; i++) {
//                processing the duplicates
                if (i > index && arr[i] == arr[i - 1]) continue;
//                if target becomes less than the array element
                if (target < arr[i]) break;

//                call the recur function
                ds.add(arr[i]);
                recur(i + 1, target - arr[i], arr, ans, ds);
                ds.remove(ds.size() - 1);
            }
    }

    public static List<List<Integer>> uniqueCombinations(int target, int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        recur(0, target, arr, ans, new ArrayList<>());

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = uniqueCombinations(target, arr);
        for (List<Integer> combs: ans) {
            for (int i : combs) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
