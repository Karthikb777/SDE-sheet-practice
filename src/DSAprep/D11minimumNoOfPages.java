package DSAprep;

/*
*       minimum number of pages:
*           given an array containing the pages of books and no. of students, allocate pages of books to students such that -
*               1. each student must get at least one book
*               2. a book will be allotted to only one student
*               3. allotment should be in contiguous order
*
*           optimized method using binary search:
*               sort the array
*               take a var called res and initialize to INT_MIN
*               specify the search space
*                   low will be the first element
*                   high will be sum of all array elements [both discussed later]
*
*               while low doesn't cross high
*                   calculate barrier, i.e mid
*                   if it's possible to allocate successfully, then set res = barrier
*                   then shrink the search space towards the left of mid coz we are finding the min no. of pages
*                   if it's not possible to allocate successfully
*                   then shrink search space towards the right of mid
*
*               return res
*
*           isPossibleToAllocate method:
*               initially take allocatedStudents as 1 and allocatedPages as 0
*
*               loop through the array
*                   if arr[i] > barrier, then we can't allocate, return false
*                   if allocatedPages + arr[i] > barrier, increase allocatedStudents and set allocatedPages = arr[i]
*                   else add arr[i] to allocatedPages
*
*                   if allocatedStudents > noOfStudents, then we couldn't allocate successfully, so return false
*                   return true coz we were able to allocate successfully coz no other return was ran
*
*           TC - O(nlogn) - n for isPossibleToAllocate method and logn for binary search
*           SC - O(1)
*
*           discussion - if we have 4 books and 4 students, each student will get one book,
*                       so, low will be noOfPages in the first book i.e arr[0]
*                       if we have 4 books and only 1 student, then that one student will get all 4 books
*                       so, high will be sum of pages of all 4 books
* */

import java.util.Arrays;

public class D11minimumNoOfPages {

    public static boolean isPossibleToAllocate(int[] arr, int students, int barrier) {
//        take the number of allocated students as 1 and noOfPagesAllocated as 0
        int allocatedStudents = 1, noOfPages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > barrier) {
                return false;
            }
//            if no. of pages allocated + arr[i] is gt barrier, then increase noOfStudents and allocate the pages
            if (noOfPages + arr[i] > barrier) {
                allocatedStudents++;
                noOfPages = arr[i];
            }
//            else allocate the pages
            else noOfPages += arr[i];
        }

//        if allocated students is gt the students specified, we weren't able to allocate successfully, so return false
        if (allocatedStudents > students) return false;

//        return true coz we were able to allocate pages successfully
        return true;
    }

    public static int minPages(int[] arr, int noOfStudents) {
//        sort the array first
        Arrays.sort(arr);

//        result var
        int res = Integer.MIN_VALUE;

//        define the search space
        int low, high = 0;
        low = arr[0];
        for (int i: arr) {
            high += i;
        }

        while (low <= high) {
            int barrier = (low + high) / 2;

//            if it's possible to allocate successfully, then set res = barrier
//            then shrink the search space to the left coz we need to find the minimum no. of pages that can be allocated
            if (isPossibleToAllocate(arr, noOfStudents, barrier)) {
                res = barrier;
                high = barrier - 1;
            }
//            if it's not possible, then move rightwards
            else low = barrier + 1;
        }

//        return the minimum no. of pages to be allocated
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        System.out.println(minPages(arr, 2));
    }
}
