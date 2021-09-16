package DSAprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class hi {

    public static int cost(List<Integer> arr) {
        int min = Integer.MAX_VALUE, i = 0, j = 0;
        List<Integer> list = new ArrayList<>();

        while (!arr.isEmpty() && arr.size() > 2) {
            for (int k = 0; k < arr.size() - 2; k++) {
                int sum = arr.get(k) + arr.get(k + 1);
                System.out.println(sum);
                if (sum < min) {
                    min = sum;
                    i = k;
                    j = k+1;
                }
            }
//            modify the array to the new vals and add the sum to arraylist
            arr.remove(i);
//            arr.set(j, min);
//            list.add(min);
            min = Integer.MAX_VALUE;
        }

        for (int ii: list) {
//            System.out.println(ii + " ");
        }
        return 0;
    }
    public static void main(String[] args) {
        Integer[] a = {7, 6, 8, 6, 1, 1};
        System.out.println(cost(new ArrayList<Integer>(Arrays.asList(a))));
    }
}
