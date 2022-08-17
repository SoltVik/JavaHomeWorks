package lesson04;

public class Lesson4 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 10);
        System.out.println(cat);
        Plate plate = new Plate(20);
        System.out.println(plate);

        cat.eat(plate);

        System.out.println(plate);
    }
}
