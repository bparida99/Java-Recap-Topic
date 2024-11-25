package practice.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Testing {
   public  static  void main(String r[]){
       List<Employee> employees = new ArrayList<>();
       employees.stream().filter(employee ->
               employee.getProducts().stream().filter(p->p.getPrice()>40).
                       collect(Collectors.counting())>0).collect(Collectors.toList());

       Stream.iterate(0,i->i<employees.size(),i->i+1).forEach(i->{
           System.out.println();
               });
   }
}
class Product{
    private Integer price;
    Product(){}
    Integer getPrice(){
        return price;
    }
    void setPrice(Integer price){
        this.price=price;
    }
}
 class Employee{
     private Integer id;
     private List<Product> products;
     Employee(){}
     Integer getId(){
         return id;
     }
     List<Product> getProducts(){
         return products;
     }
}
