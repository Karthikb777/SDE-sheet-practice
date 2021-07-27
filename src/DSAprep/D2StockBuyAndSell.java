package DSAprep;
//  print max profit
public class D2StockBuyAndSell {
    /*
    *   Brute force solution:
    *   for every element, check if there's an element greater than it,
    *   if yes, store the difference between those elements.
    *   return the max difference.
    *
    *   TC O(n^2), SC O(1)
    * */
    public static int method1(int[] price) {
        int maximum = 0;

        for (int i = 0; i < price.length; i++) {
            for (int j = i; j < price.length; j++) {
                if(price[j] > price[i]) {
                    maximum = Math.max(maximum, price[j] - price[i]);
                }
            }
        }

        return maximum;
    }

    /*
    *       Optimized solution:
    *       take 2 variables, minPrice and maxProfit, set minPrice to maxval of int.
    *       iterate over the array, check if the element at current index is less than minPrice.
    *       if yes, set minPrice to the element
    *       then set maxProfit to max(maxProfit, difference between element and minPrice)
    *       return maxProfit
    *
    *       TC O(n), SC O(1)
    * */
    public static int method2(int[] price) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {
            if (price[i] < minPrice) minPrice = price[i];
            maxProfit = Math.max(maxProfit, price[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        System.out.println(method1(price));
        System.out.println(method2(price));
    }
}
