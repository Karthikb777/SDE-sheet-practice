package DSAprep;

/*
*       Sort an array of 0's, 1's and 2's in place and without using a sorting algo
*           This is a variant of the dutch national flag problem
*           Steps:
*               Get 3 pointers, low, mid, and high
*               set low to 0, mid to 0 and high to n-1 (n = length of array)
*
*               if arr[mid] == 0, swap arr[mid] and arr[low], move low and mid pointers to the right (mid++ and low++)
*               if arr[mid] == 1, move mid pointer to the right, (mid++)
*               if arr[mid] == 2, swap arr[mid] and arr[high], move high pointer to the left (high--)
*
*               do the above steps while mid <= high i.e mid pointer doesn't cross the high pointer
*
            Explanation:
                In this algorithm, we assume that everything left to the low pointer is 0,
                and everything right to the high pointer is 2
*
                Time complexity of this algo is O(N)
*               Space complexity of this algo is O(1)
* */

public class D1DutchNationalFlag {
    public static void solve(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        int temp;

        while (mid <= high) {
            switch(arr[mid]) {
                case 0: {
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    break;
                }
                default: break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 1, 1, 0, 0, 0, 1, 2, 2, 0};
        solve(arr);
        for (int x: arr) {
            System.out.print(x + "  ");
        }
    }
}
