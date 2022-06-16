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
                new Cat(200),
                new Dog(500, 10),
        };

        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.run(150));
            System.out.println(animal.run(500));
            System.out.println(animal.run(550));
            System.out.println(animal.swim(5));
            System.out.println(animal.swim(15) + "\n");
        }

        System.out.printf("We have %d animals: %d cats and %d dogs", Animal.getCounter(), Cat.getCounter(), Dog.getCounter());
    }

}
