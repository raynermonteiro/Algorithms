/*
Find all possible values where a^3+b^3 = c^3+d^3
where a,b,c and d are integers from 1 to 1000
 */
package Cracking.Coding.Interview.TechnicalQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equation {
    public static void main(String args[]) {
        Map<Double, List<Integer>> storage = new HashMap<>();
        int output[] = new int[4];
        for(int a=1; a<=1000; a++) {
            for(int b=1; b<=1000; b++) {
                Double sum = Math.pow(a,3) + Math.pow(b, 3);
                if(storage.containsKey(sum)) {
                    List<Integer> list = storage.get(sum);
                    list.add(a);
                    list.add(b);
                    System.out.println("a:"+a+" b:"+b+" c:"+a+" d:"+b);
                    System.out.println("sum:"+sum);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    storage.put(sum, list);
                }
            }
        }
    }
}
