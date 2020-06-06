package hackerrank.dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyQueries {
    //Approach 2 using two maps. which is much faster
    static List<Integer> freqQuery2(List<int []> queries) {
        Map<Integer, Integer> dataMap = new HashMap();
        Map<Integer, Integer> freqMap = new HashMap();
        List<Integer> output = new ArrayList();
        int freq;
        for(int[] a: queries){
            switch (a[0]){
                case 1:
                    //insert current element in map and increase its frequency
                    dataMap.put(a[1], dataMap.getOrDefault(a[1],0)+1);
                    //Get Frequency of current element in map
                    freq = dataMap.get(a[1]);
                    //Increment the freqMap for Frequency
                    freqMap.put(freq, freqMap.getOrDefault(freq, 0)+1);
                    //Decrement the old frequency
                    if(freq-1>0){
                        freqMap.put(freq-1, freqMap.getOrDefault(freq-1, 0)-1);
                    }
                    break;
                case 2:
                    if(dataMap.containsKey(a[1]) && dataMap.get(a[1])>1){
                        //Get Frequency of current element in map
                        freq = dataMap.get(a[1]);
                        //Decrement frenqMap frequency count for that frequency
                        freqMap.put(freq, freqMap.get(freq)-1);
                        dataMap.put(a[1], dataMap.get(a[1])-1);
                        //increase frequency Cnt for new Frequency
                        freq = dataMap.get(a[1]);
                        if(freq>0){
                            freqMap.put(freq, freqMap.getOrDefault(freq, 0)+1);
                        }

                    } else
                        dataMap.remove(a[1]);
                    break;
                case 3:
                    if(freqMap.get(a[1]) != null && freqMap.get(a[1])>0){
                        output.add(1);
                    } else
                        output.add(0);
                    break;
            }
        }
        for(Map.Entry mk: freqMap.entrySet()){
            System.out.println("key:"+mk.getKey()+" val:"+mk.getValue());
        }
        return output;
    }

    // Slower because getValue(n) runs in O(n) times
    static List<Integer> freqQuery(List<int []> queries) {
        Map<Integer,Integer> dataMap = new HashMap();
        List<Integer> output = new ArrayList();
        for(int[] a: queries){
            switch (a[0]){
                case 1:
                    dataMap.put(a[1], dataMap.getOrDefault(a[1],0)+1);
                    break;
                case 2:
                    if(dataMap.containsKey(a[1]) && dataMap.get(a[1])>1){
                        dataMap.put(a[1], dataMap.get(a[1]) -1);
                    } else
                        dataMap.remove(a[1]);
                    break;
                case 3:
                    if(dataMap.containsValue(a[1])){
                        output.add(1);
                    } else
                        output.add(0);
                    break;
            }
        }
        for(Map.Entry mk: dataMap.entrySet()){
            System.out.println("key:"+mk.getKey()+" val:"+mk.getValue());
        }
        return output;
    }
    public static void main(String[] args) throws IOException {
        String s;
        s.length()
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery2(queries);
            /*for(int i: ans){
                System.out.println(i);
            }*/
        }
    }
}
