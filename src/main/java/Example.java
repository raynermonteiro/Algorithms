import java.util.*;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        System.out.println(arrayList);
        arrayList.ensureCapacity(20);
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println(arrayList);

        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        System.out.println(list);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Emp, Integer> hashMap = new HashMap<Emp, Integer>();
        TreeMap<Emp, Integer> treeMap = new TreeMap<Emp, Integer>();

        Emp emp1 = new Emp(1);
        Emp emp2 = new Emp(2);
        hashMap.put(emp1, 1);
        hashMap.put(emp2, 1);
        System.out.println(hashMap.size());




        Integer int1 = new Integer(1);
        Integer int2 = new Integer(1);
        map.put(int1,1);
        map.put(int2,1);
        System.out.println(map.size());

        SortedSet<Integer> st = new TreeSet<>();
    }
}
class Emp{
    int id;
    public Emp(int id){
        this.id = id ;
    }
}
