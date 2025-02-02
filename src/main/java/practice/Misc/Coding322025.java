package practice.Misc;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Employee1 {
    int id;
    String name;
    String department;
    double salary;
    LocalDate joiningDate;
    List<String> projects;

    public double getSalary(){
        return salary;
    }

    public String getName(){
        return name;
    }
}

class Product1 {
    int id;
    String name;
    String category;
    double price;
    int quantityInStock;
}

class Student {
    int id;
    String name;
    List<Integer> marks;
}

class Order {
    int orderId;
    String customerName;
    List<Item> items;
    LocalDate orderDate;
    String status; // "Pending", "Shipped", "Delivered"
}

class Item {
    String name;
    double price;
    int quantity;
}

public class Coding322025{


    public static void main(String arg[])  {

        List<Employee1> list = new ArrayList<>();
        list.stream().sorted(Comparator.comparingDouble(Employee1::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());

        list.stream().collect(Collectors.groupingBy(e->e.department,Collectors.counting()));

        list.stream().filter(e->{
            int startYear = LocalDate.now().getYear() - 5;
            return e.joiningDate.getYear()>=startYear;
        }).collect(Collectors.toList());

        list.stream().collect(Collectors.groupingBy(e->e.department,
                Collectors.mapping(Employee1::getName,Collectors.toList())));

        list.stream().collect(Collectors.groupingBy(e->e.department,
                Collectors.collectingAndThen(Collectors.maxBy(
                       Comparator.comparingDouble(e->e.getSalary())
                ),Optional::get)));


        List<Product1> plist = new ArrayList<>();
        plist.stream().collect(Collectors.groupingBy(p->p.category,
                Collectors.maxBy(Comparator.comparingDouble(p->p.price))));

        plist.stream().filter(p->p.quantityInStock==0).collect(Collectors.toList());

        plist.stream().mapToDouble(p->p.quantityInStock*p.price).sum();

        plist.stream().collect(Collectors.groupingBy(p->p.category,
                Collectors.minBy(Comparator.comparingDouble(p->p.price))));

        plist.stream().collect(Collectors.groupingBy(p->p.category,Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));


        List<Student> slist = new ArrayList<>();

        slist.stream().collect(Collectors.toMap(s->s.name,
                s->s.marks.stream().collect(Collectors.averagingInt(Integer::intValue))));

        slist.stream().collect(Collectors.partitioningBy(
                s->s.marks.stream().collect(
                        Collectors.averagingInt(Integer::intValue))>90))
                .get(true);


        slist.stream().collect(Collectors.toMap(s->s.name,
                s->s.marks.stream().collect(Collectors.averagingInt(Integer::intValue))))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));


        slist.stream().collect(Collectors.partitioningBy(
                s->s.marks.stream().anyMatch(m->m<40)
        )).get(true);

        slist.stream().flatMap(s->s.marks.stream())
                .collect(Collectors.averagingInt(Integer::intValue));



        List<Order> orderList = new ArrayList<>();

        orderList.stream().filter(o->o.status.equals("Delivered"))
                .flatMap(o->o.items.stream())
                .mapToDouble(item->item.price* item.price).sum();

        orderList.stream().flatMap(order -> order.items.stream())
                .collect(Collectors.groupingBy(item ->
                        item,Collectors.summingInt(i->i.quantity)))
                .entrySet().stream().max(Map.Entry.comparingByValue());


        orderList.stream().filter(o->{
            var lastMonth = LocalDate.now().getMonth().minus(1).getValue();
            return o.orderDate.getMonth().getValue()==lastMonth;
        }).collect(Collectors.toList());

        orderList.stream().collect(Collectors.groupingBy(o->o.customerName,
                Collectors.collectingAndThen(Collectors.toList(),ol->{
                   return ol.stream().flatMap(o->o.items.stream())
                            .mapToDouble(o->o.price*o.quantity).sum();
                }))).entrySet().stream().max(Map.Entry.comparingByValue());


    }
}
