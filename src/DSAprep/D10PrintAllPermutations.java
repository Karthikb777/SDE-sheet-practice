package DSAprep;

import java.util.ArrayList;
import java.util.List;

public class D10PrintAllPermutations {

//    recursive method
    private static void recur(int index, int[] arr, List<List<Integer>> ans) {
//        base case
        if (index == arr.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int i : arr) {
                permutation.add(i);
            }
            ans.add(permutation);
            return;
        }

//        swap every index with the current index
        int t = 0;
        for (int i = index; i < arr.length; i++) {
//            swap the values
            swap(index, i, arr);
//            call the recursive method for the next index
            recur(index + 1, arr, ans);
//            swap the values back
            swap(index, i, arr);

        }
    }

//    swap method
    private static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static List<List<Integer>> allPermutations(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        recur(0, arr, ans);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<List<Integer>> ans = allPermutations(arr);
        for (List<Integer> perm : ans) {
            for (int i : perm) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
