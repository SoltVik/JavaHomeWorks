package lesson03;

public class Cat extends Animal{
    private static int counter;

    Cat(String name, String color, int age) {
        super(name, color, age);
        runLimit = 200;
        swimLimit = 0;
        counter++;
    }

    @Override
    public String voice() {
        return "Meow!";
    }

    @Override
    public String run(int meters) {
        return null;
    }

    @Override
    public String swim(int meters) {
        return null;
    }

    static int getCounter() {
        return counter;
    }
}
