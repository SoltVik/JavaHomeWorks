package lesson10;

import java.util.Scanner;

public class Employee implements Comparable<Employee> {
    private String name;
    private String position;
    private int salary;
    private int age;


    public Employee(String name, String position, int salary, int age) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    public static Employee createEmployee() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String position = scanner.next();
        int salary = scanner.nextInt();
        int age = scanner.nextInt();
        return new Employee(name, position, salary, age);
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        //return this.getName().compareTo(o.getName());
        return this.getAge() - o.getAge();
    }
}
