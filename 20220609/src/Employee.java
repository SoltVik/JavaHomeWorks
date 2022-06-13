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

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return(fullName + ", " + position + ", " + email + ", " + phoneNumber + ", " + salary + ", " + age);
    }
}