/*
https://leetcode.com/discuss/interview-question/536834/Groupon-or-SDE1-or-Code-Pair-round
 */
package hackerrank.medium;

import java.util.*;

public class ProductPair {

    public static void main(String[] args) {
        int[] inventory1 = {3,5};
        int order1 = 6;
        int[] inventory2 = {2,5};
        int order2 = 4;
        int[] inventory3 = {2, 8, 4, 10, 6};
        int order3 = 20;
        System.out.println(solve(inventory1, order1));
        System.out.println(solve(inventory2, order2));
        System.out.println(solve(inventory3, order3));
    }

    static int solve(int[] inventory, int order) {
        int price = 0;
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<inventory.length;i++) {
            maxQueue.add(inventory[i]);
        }
        while(!maxQueue.isEmpty() && order>0) {
            int currItem = maxQueue.poll();
            price+= currItem;
            maxQueue.add(currItem-1);
            order--;
        }
        return price;
    }
}
