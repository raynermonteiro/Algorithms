/*
https://www.geeksforgeeks.org/the-stock-span-problem/
 */
package hackerrank.medium;

import java.util.Arrays;
import java.util.Stack;

public class StockPlan {
    static int[] calculateStockPlan(int[] price) {
        int size = price.length;
        int[] s = new int[size];
        Stack<Integer> indexStack = new Stack<>();
        //push first index
        indexStack.push(0);
        //First element will always have 1
        s[0] = 1;
        for(int i=1;i<size;i++) {
            while(!indexStack.empty() && price[indexStack.peek()] < price[i] ) {
                indexStack.pop();
            }
            if(!indexStack.empty()) {
                s[i] = i- indexStack.peek();
            } else {
                s[i] = i+1;
            }
            indexStack.push(i);
        }

        return s;
    }

    public static void main(String args[]) {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        System.out.println(Arrays.toString(calculateStockPlan(price)));

        int price2[] = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(calculateStockPlan(price2)));

        int price3[] = {3, 4, 5, 3, 5, 3};
        System.out.println(Arrays.toString(calculateStockPlan(price3)));

        int price4[] = {1,2,100};
        System.out.println(Arrays.toString(calculateStockPlan(price4)));

        int price5[] = {5,3,2};
        System.out.println(Arrays.toString(calculateStockPlan(price5)));
    }
}
