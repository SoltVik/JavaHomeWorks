package lesson02;

public class Cat extends Animal{

    Cat(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    String voice() {
        return "Meow!";
    }
}
