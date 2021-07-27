package DSAprep;

/*
*       given an unsorted array of size n, array elements are in the range 1...n.
*       one number from the set {1...n} is repeating more than once and another number is missing.
*       find these 2 numbers.
* */

import java.util.ArrayList;
import java.util.Stack;

public class D1RepeatAndMissingNumbers {

//    method 1: hashing
    public static int[] findByHashing(int[] arr) {
        int repeated = 0;
        int missing = 0;
        int[] freq = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        for (int i = 1; i < freq.length; i++) {
            if(freq[i] == 0) missing = i;
            if(freq[i] > 1) repeated = i;
        }
        return new int[] {repeated, missing};
    }

//    method 2:summation
    public static int[] findBySummation(int[] arr, int range) {
//        find the summation of 1 + 2 + ..... + range
        int s = (range * (range + 1) / 2);
//        find the summation of 1^2 + 2^2 + ..... + range^2
        int s2 = (range * (range + 1) * (2 * range + 1)) / 6;

//        find the summation of all elements in the array
//        find the summation of all the squares of the elements in the array
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += arr[i] * arr[i];
        }

/*          we obtain 2 equations, x - y = s and x^2 - y^2 = s2
*           below are the steps to solve those 2 equations programmatically
*  */
        int temp1 = s - sum1;
        int temp2 = s2 - sum2;

        int temp3 = temp2 / temp1;

        int missing = ( temp1 + temp3 ) / 2;
        int repeating  = missing - temp1;

//        return repeating and missing number
        return new int[] {repeating, missing};
    }

//    method 3: XOR method
    public static void findByXor(int[] arr, int range) {
        int xor = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
            res = res ^ i+1;
        }

        int res2 = xor ^ res;

        ArrayList<Integer> bucket1 = new ArrayList<>();
        ArrayList<Integer> bucket2 = new ArrayList<>();

//            System.out.println(res);
        for (int i = 0; i < arr.length; i++) {
//            System.out.println(toBin(arr[i]));
        }
        System.out.println(toBin(4));

//        TODO: continue
    }

    private static String toBin(int a) {
        int res = a;
        Stack<Integer> s = new Stack<>();
        while(res != 0) {
            s.push(res % 2);
            res = res / 2;
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        findByXor(arr, 6);
//        int[] res = findBySummation(arr, 7);
//        System.out.println("repeated number: " + res[0]);
//        System.out.println("missing number: " + res[1]);
    }
}
