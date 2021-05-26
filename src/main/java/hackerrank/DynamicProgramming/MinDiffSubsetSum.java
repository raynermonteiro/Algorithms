/**
 * https://thecodingsimplified.com/partition-with-min-difference-of-subset-sum/
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 */
package hackerrank.DynamicProgramming;

import java.util.Arrays;

public class MinDiffSubsetSum {
    static int[] classArr;
    static int[] sumArr;
    public static void printArray(boolean arr[][]) {
        System.out.println("-------------------------------------------------------------------");
        int cnt = 1;
        for(int row=0;row<arr.length;row++) {
            for(int col=0;col<arr[row].length;col++) {
                if(row==0 && col==0)
                    System.out.print("\t");
                if(row == 0 && col==0) {
                    for(int j=0;j<arr[row].length;j++)
                        System.out.print(j + "\t");
                    System.out.println();
                }
                if(col == 0) {
                    System.out.print(classArr[row] + "\t");
                }

                System.out.print((arr[row][col] ? "t" : "f") + "\t");
            }
            System.out.println();
        }
    }

    public static int getMinDifferenceSubsetSumArrayPartition(int inputArr[], int n) {
        int arraySum = Arrays.stream(inputArr).sum();
        int sum = arraySum/2;
        boolean dpArray[][] = new boolean[n][sum+1];
        //Value for sum 0 will always be true
        for(int row = 0;row<n;row++) {
            dpArray[row][0] = true;
        }
        printArray(dpArray);

        //Set intial value as true for first element at the right sum position.
        for(int col = 0;col<=sum;col++){
            if(col == inputArr[0]) {
                dpArray[0][col] = true;
            }
        }
        printArray(dpArray);

        for(int row=1;row<n;row++) {
            for(int col=1;col<=sum;col++){
                if(dpArray[row-1][col]) {
                    dpArray[row][col] = true;
                } else if(col >= inputArr[row]) {
                    dpArray[row][col] = dpArray[row-1][col-inputArr[row]];
                }
            }
            printArray(dpArray);
        }

        int lastRowIdx = n-1;
        int minDiff = -1;
        for(int col = sum; col>=0;col--) {
            if(dpArray[lastRowIdx][col]) {
                minDiff = arraySum - (2*col);
                break;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 5, 13};
        classArr = Arrays.copyOf(arr, arr.length);
        System.out.println("Minimum Difference is:"+getMinDifferenceSubsetSumArrayPartition(arr, arr.length));

    }
}
