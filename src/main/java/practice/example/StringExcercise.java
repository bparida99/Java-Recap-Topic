package practice.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface Test{
    void testing() throws Exception;
}

public class StringExcercise  {



    public static void main(String args[]){
        List<String> list = Arrays.asList("Abcd","Bcde","Amno","Bghha");
        String.valueOf(1);
    var res=
            list.stream().collect(Collectors.groupingBy(s->s.charAt(0),Collectors.counting()));
    System.out.println(res);

    String s = "aaBBccdd";
    var out= s.chars().mapToObj(c->Character.toString(c)).
             collect(Collectors.groupingBy(m->m));
        System.out.println(out);
    }


}
