import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
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
    }
}
