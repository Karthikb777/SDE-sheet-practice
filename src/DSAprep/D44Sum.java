package DSAprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D44Sum {

    /*
    *   method 1: sort + 3 pointer + binarySearch
    *   sort the array
    *   maintain 3 pointers i, j ,k
    *   do sum = i + j + k
    *   then binary search the array from k to n - 1 for target - sum
    *   if found, add elements at i, j, k and binarySearch index to a quad and add the quad to res
    *
    *   TC - O(N^3 logN) for 3 pointer and binarySearch + O(NlogN) for sorting
    *   SC - O(1)
    * */

    public static List<List<Integer>> method1(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;

//        3 pointers i, j, k
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

//                    doing binary search for target - sum
                    int index = Arrays.binarySearch(arr, k, n - 1, target - sum);
                    if(index >= 0) {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[k]);
                        quad.add(arr[index]);
                        res.add(quad);
                    }
//                    processing duplicates for index k
                    while (k < n - 1 && arr[k+1] == arr[k]) ++k;
                }
//                processing duplicates for index j
                while (j < n - 1 && arr[j+1] == arr[j]) ++j;
            }
//            processing duplicates for index i
            while (i < n - 1 && arr[i+1] == arr[i]) ++i;
        }

        return res;
    }

    /*
    *   method 2 - optimized
    *   sort the array
    *   maintain 2 pointers, i and j
    *   maintain another 2 pointers, left = j + 1 and right = n - 1
    *   calculate diff b/w target and elements at indices i and j = target2
    *   while left doesn't cross right,
    *       calculate sum of elements at indices left and right = twoSum
    *       if twoSum > target2, move right one position left i.e right--
    *       if twoSum < target2, move left one position to the right, i.e left++
    *       else it is confirmed that twoSum == target2, so we obtained our quad,
    *           add elements at indices i, j , left and right to a arrayList and add that arrayList to res
    *           also process duplicates of left and right indices
    *       process duplicates of i and j
    *
    * NOTE - we are processing duplicates because the quads must be unique
    *
    * TC - O(N^3)  &  SC - O(1)
    * */

    public static List<List<Integer>> method2(int [] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();

//        sort the array
        Arrays.sort(arr);
        int n = arr.length;

//        maintain two pointers i, j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

//                maintain two pointers left and right
                int left = j + 1;
                int right = n - 1;

//                target2 is the diff between target and elements at indices i and j
                int target2 = target - arr[i] - arr[j];

//                while left doesn't cross right
                while(left < right) {

                    int twoSum = arr[left] + arr[right];

                    if (target2 > twoSum) left++;
                    else if(target2 < twoSum) right--;
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[left]);
                        quad.add(arr[right]);

                        res.add(quad);

//                        processing duplicates
                        while (left < right && arr[left] == quad.get(2)) ++left;
                        while (left < right && arr[right] == quad.get(3)) --right;
                    }
                }
//                processing duplicates
                while (j < n - 1 && arr[j+1] == arr[j]) ++j;
            }
//            processing duplicates
            while (i < n - 1 && arr[i+1] == arr[i]) ++i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 3, 4 ,4 ,2, 1, 2, 1, 1};
        List<List<Integer>> res = method2(arr, 9);
        for (List<Integer> quad : res) {
            for (int x : quad) {
                System.out.print(x + "   ");
            }
            System.out.println();
        }
    }
}
