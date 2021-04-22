/*
https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-getrandom-in-o1-with-duplicates/
 */
package hackerrank.medium;

import java.util.*;

public class DataStructure {
    Map<Integer, List<Integer>> eleMap;
    List<Integer> eleList;

    public DataStructure() {
        eleMap = new HashMap<>();
        eleList = new ArrayList();
    }

    public boolean add(int in) {
        List<Integer> eleSet;
        int idx = eleList.size();
        if(eleMap.containsKey(in)) {
            eleSet = eleMap.get(in);
            eleSet.add(idx);
            eleList.add(in);
        } else {
            eleSet = new ArrayList<>(idx);
            eleMap.put(in, eleSet);
            eleList.add(in);
        }
        return true;
    }

    public boolean delete(int in) {
        if(!eleMap.containsKey(in))
            return false;
        List<Integer> eleSet = eleMap.get(in);
        int idx = eleSet.get(eleSet.size()-1);
        eleSet.remove(idx);
        if(eleSet.isEmpty()){
            eleMap.remove(in);
        }
        Collections.swap(eleList, idx, eleList.size());
        return true;
    }

}
