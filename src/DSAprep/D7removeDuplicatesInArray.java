package DSAprep;

/*
*       remove duplicates in an array:
*           given an array, remove the duplicates in the array and return it's new length
*           steps:
*               take 2 pointers, i = 0 and j = 1
*               iterate over the array,
*                   if arr[i] == arr[j], do j++
*                   else if arr[i] != arr[j], do i++ and set arr[i] = arr[j]
*               return i + 1 (this will be the length of the array with unique elements)
*
*           after we return the length, we iterate over the array to check for the unique elements
*
*           TC - O(N)
*           SC - O(1)
* */

public class D7removeDuplicatesInArray {

    public static int removeDuplicates(int[] arr) {
        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 4, 4, 5, 5};
        int len = removeDuplicates(arr);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
