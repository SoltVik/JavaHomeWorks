package lesson03;

public class Lesson3 {

    public static void main(String[] args) {
        IAnimal[] animals = {
            new Cat("Barsik", "White", 2),
            new Dog("Polkan", "Black", 5),
            new Cat("Murzik", "Red", 3)
        };

        for (IAnimal animal : animals) {
            System.out.println(animal + ": " + animal.voice());
        }

        System.out.println(Animal.getCounter());
        System.out.println(Cat.getCounter());
    }
}



