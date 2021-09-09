package DSAprep;

/*
*       binary search in a rotated sorted array:
*           steps:
*               take low = 0, high = n - 1
*               while low doesn't cross high,
*                   compute mid
*                   check if arr[mid] is equal to target, if yes, return mid
*                   now, start shrinking the search space
*                   first check if the left part of mid is sorted or not
*                       if it is sorted, check if the target is in the left part
*                           if yes, shrink the search space to low to mid - 1 by setting high to mid - 1
*                           if no, shrink the search space to mid + 1 to high by setting low to mid + 1
*                   if the left part is not sorted, we need to check if the right part
*                       check if the target exists in the right part,
*                           if yes, shrink the search space to mid + 1 to high by setting low to mid + 1
*                           if no, shrink the search space tp low to mid - 1 by setting high to mid - 1
*
*                   if the target is not found, return -1
*
*           TC - O(logn)
*           SC - O(1)
*
* */

public class D11searchRotatedSortedArray {

    public static int search(int[] arr, int target) {
        int low, high, mid, n;
        n = arr.length;
        low = mid = 0;
        high = n - 1;

        while(low <= high) {
            mid = (low + high) / 2;

//            check if the element at index mid is the target element
            if (arr[mid] == target) return mid;

//            check if low to mid i.e left part of mid is sorted
            if(arr[low] <= arr[mid]) {
//                check if the target element exists between mid and low
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
//                check if target exists between mid and high
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ind = search(arr, 3);
        System.out.println(ind + ":" + arr[ind]);
    }
}
