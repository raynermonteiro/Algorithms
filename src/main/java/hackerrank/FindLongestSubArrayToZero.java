/**
 * Find the longest subarry in a given array that sums up to zero.
 * https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 * Extension.
 * https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 * Extension of this.
 * https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 *
 */
package hackerrank;

import java.util.*;

public class FindLongestSubArrayToZero {

    /**
     * @param input the input array
     * @return returns the longest subArray
     */
    static int getLongestSubArray(int input[]) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i=0;i<input.length;i++) {
            sum += input[i];
            if(sum == 0) {
                maxLen = i + 1;
            }
            if(sumMap.containsKey(sum)) {
                //Check if this sum has been found before, if it is then the maxlen will be
                // i minus the index previous sum was found
                maxLen = Math.max(maxLen, i - sumMap.get(sum));
            } else
                sumMap.put(sum, i);
        }
        return maxLen;
    }

    /**
     * @param input the input array
     *  Prints all the possible subArrays that sum to zero
     */
    static void printLongetSubArray(int input[]) {

        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        for(int i=0; i<input.length;i++) {
            sum += input[i];
            if(sumMap.containsKey(sum)) {
                for(int idx: sumMap.get(sum)) {
                    System.out.println("Found sub Array from Index "+(idx+1)+" to Index:"+i);
                    System.out.println(Arrays.toString(Arrays.stream(input, idx+1, i+1).toArray()));
                }
            }
            List<Integer> idxList = sumMap.getOrDefault(sum, new ArrayList<>());
            idxList.add(i);
            sumMap.put(sum, idxList);
        }
    }

    public static void main(String args[]) {
        System.out.println("----------------------------------------------------------------------------");
        int arr[] = {1, 4, -2, -2, 5, -4, 3};
        System.out.println("Max Sub array for:"+ Arrays.toString(arr) +" is :"+getLongestSubArray(arr));
        printLongetSubArray(arr);

        System.out.println("----------------------------------------------------------------------------");
        arr = new int[]{15, -2, 2, -8, 1, 7, 0, 10, 23};
        System.out.println("Max Sub array for:"+Arrays.toString(arr) +" is :"+getLongestSubArray(arr));
        printLongetSubArray(arr);


        System.out.println("----------------------------------------------------------------------------");
        arr = new int[]{1, 2, 3};
        System.out.println("Max Sub array for:"+Arrays.toString(arr) +" is :"+getLongestSubArray(arr));
        printLongetSubArray(arr);


        System.out.println("----------------------------------------------------------------------------");
        arr = new int[]{1, 0, 3};
        System.out.println("Max Sub array for:"+Arrays.toString(arr) +" is :"+getLongestSubArray(arr));
        printLongetSubArray(arr);
        System.out.println("----------------------------------------------------------------------------");
    }
}
