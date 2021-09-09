package DSAprep;

import java.util.ArrayList;
import java.util.List;

/*
*       combination sum 1:
*           recursive solution:
*               if target is gte arr[index]
*                   do the pick operation - pick the same index and subtract the arr[index] from the target to get the new target
*                   then do the not pick operation - move to the next index
*
*               base case:
*                   if index == arr.length
*                       if target == 0
*                           add the ds to the ans and return
* */

public class D9CombinationSum {

    private static void recur(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
//        base case
        if (index == arr.length) {
            if (target == 0) ans.add(new ArrayList<>(ds));
            return;
        }

//        do the pick and not pick operation if target is greater than or equal to arr[index]
            if (target >= arr[index]) {
                ds.add(arr[index]);
        //        pick the current index
                recur(index, arr, target - arr[index], ans, ds);
//                make sure to remove the added element to facilitate for the next recursive call
                ds.remove(ds.size() - 1);
            }
//        don't pick the current index
        recur(index + 1, arr, target, ans, ds);
    }

    public static List<List<Integer>> getCombinations(int target, int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
//        call the recursive method
        recur(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ans = getCombinations(target, arr);

        for (List<Integer> comb: ans) {
            for (int i: comb) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }

    }
}
