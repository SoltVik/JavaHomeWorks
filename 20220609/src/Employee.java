/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет
 */
public class Employee {
    protected String fullName;
    protected String position;
    protected String email;
    protected String phoneNumber;
    protected int salary;
    protected int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return(fullName + ", " + position + ", " + email + ", " + phoneNumber + ", " + salary + ", " + age);
    }

    public static void main(String[] args) {
        Employee[] employees =new Employee[5];
        employees[0] = new Employee("Ivan Ivanov", "security", "iivanov@company.com", "+00 123456", 5000, 56);
        employees[1] = new Employee("Vasya Pupkin", "accountant", "vpupkin@company.com", "+00 132456", 15000, 38);
        employees[2] = new Employee("Pyotr Petrov", "director", "ppetrov@company.com", "+00 193566", 50000, 42);
        employees[3] = new Employee("Evgeniy Sidorov", "manager", "esidorov@company.com", "+00 163956", 10000, 34);
        employees[4] = new Employee("Nikolay Nikolaev", "programmer", "nnikolaev@company.com", "+00 153656", 20000, 36);

        for (Employee employee : employees) {
            if (employee.age >= 40) {
                System.out.println(employee);
            }
        }
    }
}