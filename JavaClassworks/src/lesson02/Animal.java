package lesson02;

public class Animal {
    protected String name;
    protected String color;
    protected int age;

    Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    String voice() {
        return "unknown";
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return (name + ", " + color + ", " + age);
    }
}