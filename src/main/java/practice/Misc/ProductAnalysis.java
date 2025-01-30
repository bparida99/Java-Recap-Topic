package practice.Misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductAnalysis {

   public static void main(String args[]){
      List<Product> products = Arrays.asList(
              new Product(1, "Laptop", "Electronics", 999.99, Arrays.asList(
                      new Review(5, "Excellent product!"),
                      new Review(4, "Very good, but a bit pricey.")
              )),
              new Product(2, "Coffee Maker", "Home Appliances", 79.99, Arrays.asList(
                      new Review(4, "Makes great coffee!"),
                      new Review(3, "It's okay, nothing special.")
              )),
              new Product(3, "Smartphone", "Electronics", 499.99, Arrays.asList(
                      new Review(5, "Fantastic phone!"),
                      new Review(2, "Battery life could be better.")
              ))
      );

      var res =products.stream().filter(p->p.getReviews()
              .stream().map(r->r.getRating()).collect(Collectors.averagingInt(Integer::intValue))>=4.5)
              .collect(Collectors.toList());

   var highestRatedProd=   products.stream().collect(Collectors.groupingBy(Product::getCategory,
              Collectors.collectingAndThen(
                      Collectors.toList(),
                      list->{
                         list.stream().collect(Collectors.maxBy(
                                 Comparator.comparingDouble(p->
                                 {
                                   return p.getReviews().stream().map(r->r.getRating()).
                                           collect(Collectors.averagingInt(Integer::intValue));
                                 })
                                 ));
                         return list;
                      }
              )));

   System.out.println(highestRatedProd);
   }

}


class Product {
   private int id;
   private String name;
   private String category;
   private double price;
   private List<Review> reviews;

   // Constructor, getters, and setters
   public Product(int id, String name, String category, double price, List<Review> reviews) {
      this.id = id;
      this.name = name;
      this.category = category;
      this.price = price;
      this.reviews = reviews;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getCategory() {
      return category;
   }

   public double getPrice() {
      return price;
   }

   public List<Review> getReviews() {
      return reviews;
   }
}

class Review {
   private int rating;
   private String comment;

   // Constructor, getters, and setters
   public Review(int rating, String comment) {
      this.rating = rating;
      this.comment = comment;
   }

   public int getRating() {
      return rating;
   }

   public String getComment() {
      return comment;
   }
}


