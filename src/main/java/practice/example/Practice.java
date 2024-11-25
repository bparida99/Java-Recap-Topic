package practice.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Practice {

    public static void main(String args[]){
        Set<Integer> set = new LinkedHashSet<>();
        Hashtable<String, Integer> map = new Hashtable<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            map.put("Biswo",10);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}

interface Dummy{
    private void test(){
      Math.subtractExact(1,2);
    }
}