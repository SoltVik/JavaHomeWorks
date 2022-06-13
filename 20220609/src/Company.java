/**
 * Java. Homework #1
 * @author Viktors Soltums
 * @version 13 Jun 2022
 *
 */
/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет
 */

public class Company {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Ivan Ivanov", "security", "iivanov@company.com", "+00 123456", 5000, 56),
            new Employee("Vasya Pupkin", "accountant", "vpupkin@company.com", "+00 132456", 15000, 38),
            new Employee("Pyotr Petrov", "director", "ppetrov@company.com", "+00 193566", 50000, 42),
            new Employee("Evgeniy Sidorov", "manager", "esidorov@company.com", "+00 163956", 10000, 34),
            new Employee("Nikolay Nikolaev", "programmer", "nnikolaev@company.com", "+00 153656", 20000, 36)
        };

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                System.out.println(employee);
            }
        }
    }
}
