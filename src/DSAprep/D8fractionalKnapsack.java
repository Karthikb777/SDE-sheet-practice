package DSAprep;

/*
*       fractional knapsack:
*           greedy algorithm solution:
*               sort the items in the decreasing order of their value per weight
*               for every item, check if it's weight is less than or equal to the current capacity of the knapsack
*                   if yes, then add the item's value to the result
*                   also subtract the item's weight from the current capacity of the knapsack
*                   else, calculate the fractional value by using the formula in the program
*                   newVal = (item.value / item.weight) * current capacity of the knapsack
*                   add the fractional value to the result
*                   also subtract the item's weight from the current capacity of the knapsack
*                   break because since the knapsack is full, there's no point in looping over the remaining items
*               return the result
*
*           TC - O(NlogN) for sorting + O(n) for iteration
*
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class item implements Comparable<item> {
    int value;
    int weight;

    public item(int val, int wt) {
        this.value = val;
        this.weight = wt;
    }

    @Override
    public String toString() {
        return String.format("value: %d, weight: %d", this.value, this .weight);
    }

//    return value per weight
    @Override
    public int compareTo(item that) {
        if ((this.value / this.weight) < (that.value / that.weight)) return 1;
        else return -1;
    }
}

public class D8fractionalKnapsack {

    public static int fillKnapsack(List<item> items, int capacity) {
        int valWhenKnapsackFull = 0;

//        sort the list in decreasing order of value per weight
        Collections.sort(items);

//       for every item, check if it's weight is less than or equal to the current capacity of the knapsack
        for (item i : items) {
//            add the item's value to the val and subtract the weight from the capacity
            if (i.weight <= capacity) {
                valWhenKnapsackFull += i.value;
                capacity -= i.weight;
            }
            else {
//                calculate newVal from the below formula
                int newVal = (i.value / i.weight) * capacity;
//                then add the newVal to val and subtract weight from the capacity
                valWhenKnapsackFull += newVal;
                capacity -= i.weight;
//                break because the knapsack is full and there's no point in looping the further values anymore
                break;
            }
        }

//        return the result
        return valWhenKnapsackFull;
    }

    public static void main(String[] args) {
        List<item> items = new ArrayList<>();

        items.add(new item(60, 10));
        items.add(new item(100, 20));
        items.add(new item(120, 30));
        items.add(new item(200, 50));

        int knapsackCapacity = 100;
        System.out.println(fillKnapsack(items, knapsackCapacity));
    }
}
