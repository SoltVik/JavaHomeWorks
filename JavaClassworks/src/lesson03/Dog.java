package lesson03;

public class Dog extends Animal {
    private static int counter;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        runLimit = 500;
        swimLimit = 10;
        counter++;
    }

    @Override
    public String run(int meters) {
        return null;
    }

    @Override
    public String swim(int meters) {
        return null;
    }

    @Override
    public String voice() {
        return "Gaf-Gaf!";
    }
}
