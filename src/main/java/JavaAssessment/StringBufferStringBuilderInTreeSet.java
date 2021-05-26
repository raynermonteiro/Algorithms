package JavaAssessment;

import java.util.*;

public class StringBufferStringBuilderInTreeSet {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        float a= (float) 1.6;
        float b = (float) 2.2;

        int sum1 = (int) Math.floor(a+b);
        int sum2 = (int) ((int)(a+b));
        System.out.println(sum1);
        System.out.println(sum2);

        Map<String, String> map = new HashMap();

        // adding the elements to hashmap using put() method
        map.put("1", "Adithya");
        map.put("2", "Jai");
        map.put("3", "Chaitanya");
        map.put("4", "Krishna");
        map.put("5", "Ramesh");
        System.out.println(map.size());
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("Key:"+entry.getKey());
            System.out.println("Value:"+entry.getValue());
        }


        //will throw run time exception since java.lang.StringBuffer cannot be cast to java.lang.Comparable
        /*TreeSet<StringBuffer> treeSet = new TreeSet<>();
        treeSet.add(new StringBuffer("h"));
        treeSet.add(new StringBuffer("a"));
        treeSet.add(new StringBuffer("c"));
        treeSet.add(new StringBuffer("k"));*/

        //will throw run time exception since java.lang.StringBuilder cannot be cast to java.lang.Comparable
        /*TreeSet<StringBuilder> builderSet = new TreeSet<>();
        builderSet.add(new StringBuilder("a"));
        builderSet.add(new StringBuilder("b"));
        */

        //To Avoid the above error implement the comparator in TreeSet<>()
        TreeSet<StringBuilder> builderSet = new TreeSet<>(new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder o1, StringBuilder o2) {
                 return o1.toString().compareTo(o2.toString());
            }
        });
        builderSet.add(new StringBuilder("b"));
        builderSet.add(new StringBuilder("a"));
        System.out.println(builderSet);
    }
}
