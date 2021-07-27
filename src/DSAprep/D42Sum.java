package DSAprep;

import java.util.HashMap;

public class D42Sum {

    /*
    *   method 1 - brute force method
    *   maintain two pointers i and j and calculate sum of elements at indices i and j and check if it is equal to target
    * */

    public static int[] method1(int[] arr, int target) {
        int[] res = new int[2];
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] + arr[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /*
    *   optimized - using hashMap
    *   initialize a new hashMap
    *   iterate over the array, for every element,
    *   check if target - element exists in hashMap
    *   if yes, add indices of target - element and element into res and return it.
    *   if no, add element and it's index into the hashMap
    *
    *   TC - O(N), hashtable TC - O(1) for insertion and searching
    * */

    public static int[] method2(int[] arr, int target) {
        int[] res = new int[2];
        int n = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(hashMap.containsKey((target - arr[i]))) {
                res[0] = hashMap.get(target - arr[i]);
                res[1] = i;
                return res;
            }
            hashMap.put(arr[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 6, 9};
        int target = 10;
        for (int i : method2(arr, target)) {
            System.out.print(i + "  ");
        }
    }
}
