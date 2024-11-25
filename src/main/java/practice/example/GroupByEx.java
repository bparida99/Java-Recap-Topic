package practice.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByEx {
    static Map<Character,Long> map = new HashMap<>();

    private static void addToMap(Character key){
        map.put(key,map.get(key)==null?1:map.get(key)+1);
    }

    public static void main(String arg[]){
        List<String> list = List.of("Abc","Abd","Bcd","Bfg");
        list.stream().collect(Collectors.groupingBy(s->s.charAt(0),Collectors.counting()));

        String s = "aabbccdd";
        var res= s.chars().mapToObj(c->Character.toString(c)).collect(Collectors
                .groupingBy(st->st,Collectors.counting()));
        System.out.println(res);

        for(int i=0;i<s.length();i++){
            addToMap(s.charAt(i));
        }
        System.out.println(map);

    }
}
