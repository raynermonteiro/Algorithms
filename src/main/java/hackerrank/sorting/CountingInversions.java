/**
 * URL: https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 */

package hackerrank.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingInversions {

    static long cntInv;
    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        cntInv = 0L;
        partition(arr, 0, arr.length-1);
        return cntInv;
    }

    static void partition(int []arr, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            partition(arr, low, mid);
            partition(arr, mid+1, high);
            mergeSort(arr, low, mid, high);
        }
    }

    static void mergeSort(int[] arr, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0;i<n1;i++){
            L[i] = arr[low+i];
        }
        for(int i=0;i<n2;i++){
            R[i] = arr[mid+i+1];
        }
        int i = 0, j= 0;
        int k = low;
        while(i<n1 && j<n2){
            if(L[i]<= R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
                cntInv += (mid + 1) - (low + i);
            }
            k++;
        }
        while (i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k] = R[j];
            k++;
            j++;
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            System.out.println("Result:"+result);
        }

        scanner.close();
    }
}
