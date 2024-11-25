package practice.topics.designpattern;

class Employee{
    private int id;
    private String name;

    Employee(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class Builder{
        private int id;
        private String name;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

       public Employee build(){
            return new Employee(this);
       }

    }
}

public class BuilderPatternEx {

    public static void main(String arg[]){
        Employee e = new Employee.Builder().
                                   setId(1).
                                   setName("Biswo").
                                   build();

        System.out.println(e);
    }
}
