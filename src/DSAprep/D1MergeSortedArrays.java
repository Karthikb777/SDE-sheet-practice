package DSAprep;


import java.util.Arrays;

/*
*       given two sorted arrays, merge them and return them
* */
public class D1MergeSortedArrays {

//    method 1: use a seperate array to merge
//    time complexity: close to O(5n) because of multiple for loops
//    space complexity: O(N) due to use of seperate array for merging
    public static void merge(int[] a1, int[] a2) {
        int[] arr = new int[a1.length + a2.length];
        for(int i = 0; i < a1.length;i++) {
            arr[i] = a1[i];
        }
        for(int i = a1.length; i < a1.length + a2.length; i++) {
            arr[i] = a2[i - a1.length];
        }

        Arrays.sort(arr);

        for(int i = 0; i < a1.length;i++) {
            a1[i] = arr[i];
        }
        for(int i = a1.length; i < a1.length + a2.length; i++) {
            a2[i - a1.length] = arr[i];
        }
    }

//    method 2: using insertion sort like algorithm
    /*
    *   iterate over the first array, then compare each element with the first element of second array
    *   if the second array element at index 0 is less than the first array element, swap them
    *   then sort the second array.
    *
    *   time complexity: O(n) for iteration + O(nlogn) for sorting the second array
    *   space complexity: O(1) because we are merging in-place
    * */

    public static void mergeMethod2(int[] a1, int[] a2) {
        int temp;
        for (int i = 0; i < a1.length; i++) {
            if(a1[i] > a2[0]) {
                temp = a1[i];
                a1[i] = a2[0];
                a2[0] = temp;
                Arrays.sort(a2);
            }
        }
    }

//    method 3: using GAP method
    public void mergeMethod3(int[] a1, int[] a2) {

    }

    public static void main(String[] args) {
        int[] arr1 = {2, 5, 6, 7, 10, 11};
        int[] arr2 = {1, 3, 4, 8};
        System.out.println("before merge");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        mergeMethod2(arr1, arr2);
        System.out.println("\nafter merge");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
