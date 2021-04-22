/**
 * Calculate Fibonacci Series using Memoization and recursion
 * https://www.youtube.com/watch?v=P8Xa2BitN3I&ab_channel=HackerRank
 */
package hackerrank;

import java.util.Arrays;

public class FibonacciMemoization {



    public static int fib(int n) {
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        return fib(n-1) + fib(n-2);
    }
    public static long fibMemoization(long n, long[] fibArray){
        long fibValue=0;
        if(n==0 ){
            return 0;
        }else if(n==1){
            return 1;
        }else if(fibArray[(int)n]!=0){
            return fibArray[(int)n];
        }else{
            fibArray[(int) n]=fibMemoization(n-1, fibArray)+fibMemoization(n-2, fibArray);;
            return fibArray[(int) n];
        }
    }

    public static void main(String args[]) {
        int input = 10;
        long fibArray[]=new long[input+1];
        Arrays.fill(fibArray,0);
        System.out.println(fib(input));
        System.out.println(fibMemoization(input, fibArray));
    }
}
