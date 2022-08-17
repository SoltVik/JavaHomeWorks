package lesson02;

public class Lesson2 {

    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", "White", 2);
        cat.setName(null);
        System.out.println(cat.getName() + ": " + cat.voice());
        System.out.println(cat);
    }
}



