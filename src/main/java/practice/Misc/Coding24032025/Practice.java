package practice.Misc.Coding24032025;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

 class Transaction {
    private int id;
    private String transactionType;
    private double amount;

    // Constructor
    public Transaction(int id, String transactionType, double amount) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{id=" + id + ", transactionType='" + transactionType + "', amount=" + amount + "}";
    }
}
 class Student {
    private String name;
    private int grade;

    // Constructor
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
}
 class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}


public class Practice {

    public static List<Transaction> getTransactions() {
        return List.of(
                new Transaction(1, "Deposit", 500.0),
                new Transaction(2, "Withdrawal", 200.0),
                new Transaction(3, "Deposit", 300.0),
                new Transaction(4, "Transfer", 400.0),
                new Transaction(5, "Withdrawal", 150.0)
        );
    }
    public static List<Student> getStudentList() {
        return List.of(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 85),
                new Student("Dana", 95),
                new Student("Eve", 92)
        );
    }
     public static List<Employee> getEmployeeList(){
         return List.of(
                 new Employee(1, "Alice", "HR", 70000),
                 new Employee(2, "Bob", "IT", 80000),
                 new Employee(3, "Charlie", "IT", 75000),
                 new Employee(4, "Dana", "HR", 60000),
                 new Employee(5, "Eve", "Finance", 90000),
                 new Employee(6, "Frank", "Finance", 85000)
         );
    }
    public static List<String> getEmployeeNames(Double salary){
       return getEmployeeList().stream().filter(emp->emp.getSalary()>salary)
                .map(emp->emp.getName().toUpperCase()).collect(Collectors.toList());
    }

    public static List<Integer> filterEvenNumbers(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b?a:b);
        return numbers.stream().filter(num->num%2==0).collect(Collectors.toList());
    }

    public static Integer findMaxNumber(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       return numbers.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b?a:b);
    }

    public static List<Student> sortStudents(){
        return getStudentList().stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed()
                .thenComparing(Comparator.comparing(Student::getName)))
                .collect(Collectors.toList());
    }
    public static Map<String,List<Transaction>> groupTransactions(){
        return getTransactions().stream().
                collect(Collectors.groupingBy(Transaction::getTransactionType));
    }

    public static Map<String, Optional<Employee>> findHighestPaidEmpInEachDept(){
        return getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    public static Double calculateTotalSalary(){
        return getEmployeeList().stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
    }

    public static void main(String args[]){
        var result = findMaxNumber();
        System.out.println(result);
    }
}
