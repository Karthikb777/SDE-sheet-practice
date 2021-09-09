package DSAprep;

/*
*       subset sum 2:
*           Given an integer array nums that may contain duplicates,
*           return all possible subsets (the power set). The solution set must not contain duplicate subsets.
*
*           recursive solution:
*               first sort the array
*               then call the recursive function
*               return the answer obtained from the recursive function
*
*               recursive function steps:
*                   firstly, add the subset passed in the argument list to the answers list
*                   run a for loop starting from the index passed to the end of the list
*                       process duplicates
*                       add the element at the current for loop i value to the subset
*                       call the recursive function for i+1 and also pass the required arguments
*                       finally, remove the element added just before the recursive call
*                       to not add duplicates for the next recursive call
*
*                   NOTE: in this implementation, there's no need to explicitly declare a base case because,
*                       the base case will be automatically taken care of by the for loop condition
*
*               TC - O(2^n) for recursive calls x O(n) for adding the subsets to ans list = O(2^n * n)
*               SC - O(2^n) x O(k) [2^n for ans and assuming every subset in ans will have an avg length of k] = O(2^n * k)
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D9subsetSum2 {

    public static void recursion(int[] arr, int n, int index, List<Integer> ds, List<List<Integer>> ans) {
//        add the ds i.e subset to the list of subsets
        ans.add(new ArrayList<>(ds));

//        base case : no need for a base case because it will be taken care in the for loop condition itself

//        run the loop for every index starting from the index specified in the recursive calling
        for (int i = index; i < n; i++) {
//            processing the duplicates
            if (i > index && arr[i] == arr[i-1]) continue;

//            add the element at index i in arr
            ds.add(arr[i]);

//            call the recursive function
            recursion(arr, n, i+1, ds, ans);

//            remove the added element before recursion
            ds.remove(ds.size() - 1);
        }

    }

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

//        first sort the array
        Arrays.sort(arr);

        int n = arr.length;

//        call the recursive function
        recursion(arr, n, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> subsets = subsets(arr);
        for (List<Integer> subset: subsets) {
            System.out.print("[ ");
            for (int i: subset) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
