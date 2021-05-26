package hackerrank;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StockPrice {
    public static int stock(int arr[]){

        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        int tempArr[] = new int[arr.length];
        int n = arr.length;
        int maxPrice = 0;
        int stockCnt=0;
        for (int i = 0; i < n-1; i++ ){
            if(arr[i]<arr[i+1]) {
                tempArr[i]--;
                stockCnt++;
            } else if(arr[i]==arr[i+1]) {
                tempArr[i]=0;
            } else {
                tempArr[i]=stockCnt;
                stockCnt=0;
            }
        }
        if(arr[n-1]>=arr[n-2]) {
            tempArr[n-1]=stockCnt;
        }
        for(int i=0;i<n;i++) {
            maxPrice += arr[i]*tempArr[i];
        }
        System.out.println(Arrays.toString(tempArr));
        return maxPrice;
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
