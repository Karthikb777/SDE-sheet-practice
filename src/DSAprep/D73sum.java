package DSAprep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
*       3 sum:
*           brute force solution:
*               check for all possible triplets
*               TC - O(n^3)
*               SC - O(1) [assuming that the space taken to store the answers is not considered]
*
*           optimal solution:
*               using 2 pointer approach
*               first sort the array
*               then iterate over the array
*                   take 2 pointers, lo = i + 1 and high = n - 1
*                   take a var called sum, assign -arr[i] to it
*                   loop while lo doesn't cross high
*                       if arr[lo] + arr[high] == sum, then that's a triplet
*                       else if arr[lo] + arr[high] > sum, do high--
*                       else it will be arr[lo] + arr[high] < sum, so do low++
*           TC - O(n)
*           SC - O(1) [assuming the space taken to store the answers is not considered]
*
*           intuition:
*               if a + b + c = 0
*               then a + b = -c
* */
public class D73sum {
//    brute force solution
    public static List<int[]> brute(int[] arr) {
        List<int[]> res = new LinkedList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == 0) {
                        res.add(new int[] {arr[i], arr[j], arr[k]});
                    }
                }
            }
        }

        return res;
    }

//    optimal solution
    public static List<int[]> optimal(int[] arr) {
//        first sort the array
        Arrays.sort(arr);
        int n = arr.length;
        List<int[]> res = new LinkedList<>();

//        iterate over the array
        for (int i = 0; i < n - 2; i++) {
//            check if arr[i] is not a duplicate element
            if (i == 0 || (i > 0 && arr[i] != arr[i-1])) {
//                initialize lo = i+1, high = n-1
//                initialize sum = -arr[i]
            int lo = i + 1, high = n - 1, sum = -arr[i];

//            loop while lo doesn't cross high
                while (lo < high){
//                    if sum of lo and high index elements == sum, then that's a triplet
                    if ((arr[lo] + arr[high]) == sum) {
                        res.add(new int[]{arr[lo], arr[high], arr[i]});

//                        process duplicates for lo and high pointers
                        if (lo < high && arr[lo] == arr[lo + 1]) lo++;
                        if (lo < high && arr[high] == arr[high - 1]) high--;

//                        then move lo pointer one step forward and high pointer one step backward
                        lo++;
                        high--;
//                        if sum of lo and high index elements are greater than the sum, then do high--
                    } else if ((arr[lo] + arr[high]) > sum) high--;
//                    else do lo++
                    else lo++;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] arr = {-1, -1, 0, 1, 2, 0, 4, -2};
        List<int[]> res = optimal(arr);
        for (int[] tri : res) {
            for (int i: tri) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
