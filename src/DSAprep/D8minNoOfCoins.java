package DSAprep;

import java.util.LinkedList;
import java.util.List;

/*
*       minimum no. of coins for a denomination:
*           greedy algorithm solution:
*               take a denominations array containing all the available denominations
*               start from the end of the array, and iterate over the array
*                   for every denomination, loop while denomination is less than or equal to the amt
*                       add the denomination to the result array
*                       subtract the denomination from the amt
*               print the result array
*
*               TC - O(amt)
* */

public class D8minNoOfCoins {

    public static void noOfCoins(int amt) {
//        denominations array
        int[] deno = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
//        list containing the result
        List<Integer> coins = new LinkedList<>();

//        iterate over the array of denominations from the end
        for (int i = deno.length - 1; i >= 0 ; i--) {
//            for every denomination, check if the denomination is greater than equal to amt
            while(deno[i] <= amt) {
//                add the denomination to the result list
                coins.add(deno[i]);
//                subtract the denomination from the amt
                amt -= deno[i];
            }
        }
//        print the result
        for (int coin: coins) {
            System.out.println(coin);
        }
    }

    public static void main(String[] args) {
        noOfCoins(49);
    }
}
