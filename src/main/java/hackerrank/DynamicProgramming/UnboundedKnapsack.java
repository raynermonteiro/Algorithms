/**
 * https://www.hackerrank.com/challenges/unbounded-knapsack/problem
 */
package hackerrank.DynamicProgramming;

import com.practice.common.ArrayUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class UnboundedKnapsack {

    static int knapsack(int k, List<Integer> arr) {
        int[][] dpArray = new int[arr.size()+1][k+1];
        for(int row=0;row<arr.size()+1;row++) dpArray[row][0] = 0;
        for(int col=0;col<k+1;col++) dpArray[0][col] = 0;

        for(int row=1;row<=arr.size();row++) {
            for(int col=1;col<=k;col++) {
                if(col >= arr.get(row-1)) {
                    dpArray[row][col] = Math.max(arr.get(row-1) + dpArray[row][col - arr.get(row-1)] , dpArray[row-1][col]);
                } else {
                    dpArray[row][col] = dpArray[row-1][col];
                }
                ArrayUtil.printArray(dpArray);
            }
        }
        return dpArray[arr.size()][k];
    }
    public static void main(String[] args) {
        File files = new File("src/main/resources/UnboundedKnapsack");
        if(files.exists()) {
            for(File file: files.listFiles()) {
                try {
                    System.out.println("---------File Name:"+file.getName());
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                    int t = Integer.parseInt(bufferedReader.readLine().trim());
                    while(t>0) {
                        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                        int n = Integer.parseInt(firstMultipleInput[0]);

                        int k = Integer.parseInt(firstMultipleInput[1]);

                        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList());

                        System.out.println("Size:"+n+"\t Sum:"+k);
                        System.out.println(Arrays.toString(arr.toArray()));

                        int result = knapsack(k, arr);
                        System.out.println("Output:" + result);
                        t--;
                    }
                    bufferedReader.close();
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
