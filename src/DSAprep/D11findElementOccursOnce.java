package DSAprep;

/*
*       find the element that occurs only once in the array, every element occurs twice:
*           brute force solution:
*               do the xor of elements and find the one that occurs once
*
*           optimal solution:
*               using binary search
*                   take low = 0, high = n - 2 [discussed later]
*                   while low doesn't cross high
*                       compute mid
*                       check if arr[mid] == arr[mid^1] [discussed later]
*                           if yes, do low = mid + 1
*                           else do high = mid - 1
*                   return arr[low]
*
*           TC - logN due to classic binary search
*           SC - O(1)
*
*           discussion:
*               taking n - 2 as high is to handle the case where the element occurring once will be at the last position
*               so taking n - 2 will ultimately place low at n - 1 and low crosses high, so we get the result
*
*               doing arr[mid^1]
*                   we need to make an observation that to the left part of the element occurring once,
*                   the 1st occurrence of a number is at even index and 2nd occurrence is at odd index
*                   whereas, to the right part of the element,
*                   the 1st occurrence is at odd index and the second occurrence is at even index
*
*                   so we need to check if we are in the left or right side of the element occurring once
*                   if we do index ^ 1, and if the index is an odd number, the xor operation gives the previous even index
*                   if we do index ^ 1, and if the index is an even number, the xor operation gives the next odd index
*                   so we can cover both the cases of checking for left and right part
* */

public class D11findElementOccursOnce {
    public static int bruteForce(int[] arr) {
        int i = 0;
        int j = 1;
        int n = arr.length;

//        this will not handle the edge case, so this is not the optimal solution and also it takes too long
        while(i < n && j < n) {
            if ((arr[i]^arr[j]) != 0) return arr[i];
            i+=2;
            j+=2;
        }

        return -1;
    }

//    most optimal solution using binary search
    public static int optimal(int[] arr) {
        int n = arr.length;

        int low = 0, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == arr[mid^1]) low = mid + 1;
            else high = mid - 1;
        }

        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        System.out.println(optimal(arr));
    }
}
