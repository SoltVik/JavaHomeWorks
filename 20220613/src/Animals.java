/**
 * Java. Homework #2
 * @author Viktors Soltums
 * @version 15 Jun 2022
 *
 */
/*
Создать классы Собака и Кот с наследованием от класса Животное.
Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dog.run(150); -> 'Собака пробежала 150 м.');
У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
Добавить подсчет созданных котов, собак и животных.
 */

public class Animals {
    public static void main(String[] args) {
        IAnimal[] animals = {
                new Cat("Barsik", "White", 2),
                new Dog("Polkan", "Black", 5),
                new Cat("Murzik", "Red", 3),
                new Cat("Sonik", "Brown", 3),
                new Cat("Rizik", "Orange", 1),
                new Dog("Muhtar", "Grey", 2),
                new Dog("Zuza", "Red", 4)
        };

        for (IAnimal animal : animals) {
            int randomSwim = (int) ((Math.random() * (10 - 1)) + 1);
            int randomRun = (int) ((Math.random() * (550 - 150)) + 150);
            System.out.println(animal.run(animal.getName(), randomRun) + " & " + animal.swim(animal.getName(), randomSwim) + " ");
        }

        System.out.printf("\nWe have %d animals: %d cats and %d dogs", Animal.getCounter(), Cat.getCounter(), Dog.getCounter());
    }

}
