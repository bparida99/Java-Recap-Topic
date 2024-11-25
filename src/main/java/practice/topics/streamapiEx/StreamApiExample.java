package practice.topics.streamapiEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExample {

    public static void main(String arg[]){
      Integer[] intArr = {1,9,3,7,5,2};
      Stream.of(intArr).sorted(Comparator.reverseOrder()).skip(1).
              findFirst();
             // collect(Collectors.maxBy(Integer::compare));
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
      //Odd Even with filter
      numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
      //Filter data findFirst()
      List<String> names = Arrays.asList("John", "Alice", "Bob", "Anna", "Mike");
      names.stream().filter(n->n.charAt(0)=='A').findFirst();

      //Length grater than 3
      names.stream().filter(n->n.length()>3).collect(Collectors.counting());
      //Convert to upper case map()
      names.stream().map(String::toUpperCase).collect(Collectors.toList());
     // GroupBy()
     names.stream().collect(Collectors.groupingBy(
             n->n.length(),Collectors.counting()));

     //Sum of all integers using reduce
     numbers.stream().collect(Collectors.reducing((i1,i2)->i1+i2));
        //flatmap()
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        listOfLists.stream().flatMap(list-> list.stream()).
                collect(Collectors.summingInt(Integer::intValue));

        //String join
        List<String> words = Arrays.asList("Java", "Stream", "API", "Example");
        words.stream().collect(Collectors.joining(","));
        //average
        numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
        //partitioning
        numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
        //
        class Employee {
            String name;
            double salary;
            Employee(String name,double salary){
                this.name=name;
                this.salary=salary;
            }
            public String getName(){
                return name;
            }
            public double getSalary(){
                return salary;
            }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Jane", 60000),
                new Employee("Bob", 45000)
        );

       employees.stream().max((e1,e2)->
                  Double.compare(e1.getSalary(),e2.getSalary()));

       //Join lists
        List<String> list1 = Arrays.asList("apple", "banana", "cherry");
        List<String> list2 = Arrays.asList("banana", "cherry", "date");
        Stream.concat(list1.stream(),list2.stream()).
               distinct().collect(Collectors.toList());

        //System.out.println(res);
    }
}
