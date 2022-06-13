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
