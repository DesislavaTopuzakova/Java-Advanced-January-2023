public class Employee {
    //name, salary, position, department, email, age

    //mandatory
    private String name;
    private double salary;
    private String position;
    private String department;
    //optional
    private String email;
    private int age;


    //начин 1: name, salary, position, department
    public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = -1;
    }

    //начин 2: name, salary, position, department, email, age
    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    //начин 3: name, salary, position, department, email
    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
    }
    //начин 4: name, salary, position, department, age
    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        //"Peter 120.00  peter@abv.bg 28"
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }

}
