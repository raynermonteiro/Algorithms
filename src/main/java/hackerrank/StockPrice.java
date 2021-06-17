package hackerrank;

import java.util.*;

public class StockPrice {
    public static int stock(int arr[]){

        int n = arr.length;
        int maxPriceSofar=arr[n-1];
        int totalPrice = 0;
        for(int i=n-2;i>=0;i--) {
            if(arr[i]> maxPriceSofar) {
                maxPriceSofar = arr[i];
            }
            totalPrice = totalPrice + maxPriceSofar - arr[i];
        }
        return totalPrice;
    }
    public static void main(String args[]) {

        Map<Character, Integer> freqMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int arr[] = {3,4,5,3,5,2};
        System.out.println(stock(arr));
        int arr2[] = {5,3,2};
        System.out.println("arr2");
        System.out.println(stock(arr2));

        int arr3[] = {1,2,100};
        System.out.println("arr3");
        System.out.println(stock(arr3));

        int arr4[] = {3,2,5,7,2,5};
        System.out.println("arr4");
        System.out.println(stock(arr4));

        int arr5[] = {1,2,4,2,3,2,3};
        System.out.println("arr5");
        System.out.println(stock(arr5));
    }
}
