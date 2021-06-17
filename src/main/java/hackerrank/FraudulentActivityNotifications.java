/**
 * URL: https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */
package hackerrank;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;


public class FraudulentActivityNotifications {
    /**
     * Insert into Queue
     *
     * @param smaller     queue
     * @param greater     queue
     * @param numToInsert number to insert
     * @param d           the min days
     */
    private static void insertIntoQueue(PriorityQueue<Integer> smaller, PriorityQueue<Integer> greater,
                                        int numToInsert, double d) {
        if (numToInsert < d) {
            smaller.add(numToInsert);
        } else {
            greater.add(numToInsert);
        }
    }

    private static void removeElement(PriorityQueue<Integer> smaller, PriorityQueue<Integer> greater,
                                      int numToRemove) {
        if (smaller.contains(numToRemove)) {
            smaller.remove(numToRemove);
        } else {
            greater.remove(numToRemove);
        }
    }

    private static double getMedian(PriorityQueue<Integer> sm, PriorityQueue<Integer> gr, int d) {
        if (d % 2 == 0) {
            double a1 = sm.peek();
            double a2 = gr.peek();
            return ((a1 + a2) / 2.0);
        } else {
            return gr.peek();
        }
    }

    private static void rebalanceQueue(PriorityQueue<Integer> sm, PriorityQueue<Integer> gr, int d) {
        if (d % 2 == 0 && sm.size() != gr.size()) {
            if (sm.size() > gr.size()) {
                gr.add(sm.poll());
            } else {
                sm.add(gr.poll());
            }
        } else {
            if (gr.size() - sm.size() > 1) {
                sm.add(gr.poll());
            } else if (sm.size() == gr.size()) {
                gr.add(sm.poll());
            }
        }
    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        PriorityQueue<Integer> first = new PriorityQueue<>(d);
        PriorityQueue<Integer> smaller = new PriorityQueue<>(d, Collections.<Integer>reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>(d);
        int size = expenditure.length;
        for (int i = 0; i < d; i++) {
            greater.add(expenditure[i]);
        }
        for (int i = 0; i < d / 2; i++) {
            smaller.add(greater.poll());
        }
        int notifyNum = 0;
        int low = 0;
        while (low + d < size) {
            int addVal = expenditure[low + d];
            System.out.println("Smaller Queue");
            for (int i : smaller) {
                System.out.print(" " + i);
            }

            System.out.println("Greater Queue");
            for (int i : greater) {
                System.out.print(" " + i);
            }
            double median = getMedian(smaller, greater, d);
            System.out.println(" median:" + median);
            if (addVal >= 2 * median) {
                notifyNum++;
            }
            removeElement(smaller, greater, expenditure[low]);
            insertIntoQueue(smaller, greater, addVal, median);
            rebalanceQueue(smaller, greater, d);
            low++;
        }
        return notifyNum;
    }

    static double getMedian(int[] cntSrt, int d, int medianPos) {
        int counter = 0;
        int left = 0;
        while (counter < medianPos) {
            counter += cntSrt[left];
            left++;
        }

        int right = left;
        left = left - 1;

        if (counter > medianPos || d % 2 != 0)
            return (double) left;
        else
            while (cntSrt[right] == 0) {
                right++;
            }
        return (left + right) / 2.0;
    }

    // Complete the activityNotifications function below.
    static int activityNotifications2(int[] expenditure, int d) {
        int[] cntSrt = new int[201];
        int size = expenditure.length;
        for (int i = 0; i < d; i++) {
            cntSrt[expenditure[i]]++;
        }
        int medianPos;
        if (d % 2 == 0) {
            medianPos = d / 2;
        } else
            medianPos = d / 2 + 1;

        int low = 0;
        int notify = 0;
        while (low + d < size) {
            double median = getMedian(cntSrt, d, medianPos);
            if (expenditure[low + d] >= 2 * median) {
                notify++;
            }
            cntSrt[expenditure[low]]--;
            cntSrt[expenditure[low + d]]++;
            low++;
        }

        return notify;
    }

    public static void main(String[] args) throws IOException {

        int[] expenditure = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
        int d = 5;

        int result = activityNotifications(expenditure, d);
        System.out.println("Result:" + result);
        result = activityNotifications2(expenditure, d);
        System.out.println("Result:" + result);


    }
}
