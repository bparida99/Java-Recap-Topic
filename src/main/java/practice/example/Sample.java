package practice.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

    public  static void main(String arg[]){
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,9,16);
        var res =
              integers.stream().filter(
                      i->Math.sqrt(i) % 1 == 0).collect(Collectors.toList());
        System.out.println(res);

        List<String> strings = Arrays.asList("","      ","Abcd","ehehhe","Abcd");
        var count =
                strings.stream().filter(s->!s.isBlank()).collect(Collectors.counting());
        System.out.println(count);

        var sum =
                integers.stream().filter(
                        i->Math.sqrt(i) % 2 == 0).collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum);
       var uniqueString = strings.stream().distinct().
               sorted().collect(Collectors.toList());
       System.out.println(uniqueString);

       var lengthMap =
               strings.stream().collect(Collectors.groupingBy(s->s.length()));
       System.out.println(lengthMap);

       var maxValue =
               integers.stream().collect(Collectors.maxBy(Integer::compareTo)).get();
       System.out.println(maxValue);
       //flatmap
       var listOfList = Arrays.asList(integers,integers);
       System.out.println(listOfList.stream().flatMap(i->i.stream()).collect(Collectors.toList()));
       //group by with condition
       System.out.println(integers.stream().collect(Collectors.groupingBy(i->i%2==0)));
       //string join
       System.out.println(strings.stream().collect(Collectors.joining(",")));
        //average
        integers.stream().collect(Collectors.averagingInt(Integer::intValue));

        //int array to Integer list
        int[] intArray = {1,2,5,3,9};
        Arrays.stream(intArray).mapToObj(i->Integer.valueOf(i)).collect(Collectors.toList());
        //fibseries using stream
        var fibseries =
                Stream.iterate(new int[]{0,1},fib->new int[]{fib[1],fib[0]+fib[1]}).
                limit(10).map(fib->fib[0]).collect(Collectors.toList());
        System.out.println(fibseries);

        System.out.println(integers.stream().
                collect(Collectors.reducing(1,(a,b)->a*b)));


        Stream.iterate(1, i -> i + 1)
                .limit(50)
                .reduce(1, (a, b) -> a *b);

                        System.out.println(Stream.iterate(1,i->i+1).
                                limit(5).reduce(1,(a,b)->a*b));
               // collect(Collectors.reducing(1,(a,b)->a*b)));



    }
}
