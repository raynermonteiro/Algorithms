/**
 * URL: https://www.hackerrank.com/challenges/anagram/problem
 */
package hackerrank.easy;

import java.io.*;
import java.util.*;

public class Anagram {

    // Complete the anagram function below.
    static int anagram(String s) {
        if(s.length()%2 != 0){
            return -1;
        }
        int a[] = new int[26];
        int cnt =0;
        for(int i=0;i<s.length();i++){
            if(i<(s.length()/2)) {
                a[s.charAt(i)-'a']++;
            } else if(a[s.charAt(i)-'a']>0){
                a[s.charAt(i)-'a']--;
            } else
                cnt++;
        }
        return cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);
            System.out.println(result);
        }
        scanner.close();
    }
}
