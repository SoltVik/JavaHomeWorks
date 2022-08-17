package lesson03;

public abstract class Animal implements IAnimal{
    protected String name;
    protected String color;
    protected int age;
    protected int runLimit;
    protected int swimLimit;
    private static int counter;

    Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        counter++;
    }

    static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return (name + ", " + color + ", " + age);
    }
}