/**
 * URL:https://www.hackerrank.com/challenges/count-triplets-1/
 */
package hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> potentialMap = new HashMap<>();
        Map<Long, Long> counterMap = new HashMap<>();
        long count =0L;
        for(int i=0;i<arr.size();i++){
            long currEle = arr.get(i);
            long key = currEle/r;
            //if counterMap contains the key, means this the last of the progression. So increment count
            if(counterMap.containsKey(key) && currEle%r == 0){
                count = count+counterMap.get(key);
            }
            //If the key is already present in potential then is is part of triplet
            //so add the currentElement into counterMap
            if(potentialMap.containsKey(key) && currEle%r == 0) {
                long cnt = potentialMap.get(key);
                counterMap.put(currEle,counterMap.getOrDefault(currEle, 0L)+cnt);
            }
            //Every Element can be the start of a triplet. So add it to potentialMap.
            potentialMap.put(currEle, potentialMap.getOrDefault(currEle, 0L)+1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans);

        bufferedReader.close();
    }
}
