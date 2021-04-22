/*
https://www.hackerrank.com/challenges/common-child/editorial

https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */
package hackerrank.medium;

import java.util.HashMap;
import java.util.Map;

public class CommonChild {
    static int commonChild(String a, String b) {
        int[][] C = new int[a.length()+1][b.length()+1];

        for (int row = 0; row < a.length(); row++) {
            for (int col = 0; col < b.length(); col++) {
                if (a.charAt(row) == b.charAt(col)) {
                    C[row+1][col+1] = C[row][col] + 1;
                } else {
                    C[row+1][col+1] = Math.max(C[row+1][col], C[row][col+1]);
                }
            }
            System.out.println("After Pass--------:--------: "+row);
            printArray(C, a, b);
        }
        return C[a.length()][b.length()];
    }

    static void printArray(int[][] a, String s1, String s2) {
        for(int row=0;row<a.length;row++){
            for(int col=0;col<a.length;col++) {
                if(row==0 && col>0){
                    System.out.print(s2.charAt(col-1)+ " ");
                } else if(col==0 && row>0){
                    System.out.print(s1.charAt(row-1)+ " ");
                }else {
                    System.out.print(a[row][col]+ " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        String s1="CRATERED";
        String s2 = "TERRACED";

        System.out.println("Max length:"+commonChild(s1, s2));

        s1= "NOHARAAA";
        s2 = "SHINCHAN";

        System.out.println("Max length:"+commonChild(s1, s2));
    }

}
