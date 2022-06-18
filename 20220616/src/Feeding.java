/**
 * Java. Homework #3
 * @author Viktors Soltums
 * @version 18 Jun 2022
 *
 */
/*
Расширить задачу про котов и тарелки с едой, выполнив следующие пункты:
Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20). Этот контроль должен быть внутри класса.
Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true. Сытый кот не кушает.
Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
public class Feeding {
    public static void main(String[] args) {
        Cat cats[] = {
            new Cat("Barsik", 10),
            new Cat("Murzik", 8),
            new Cat("Murka", 5),
            new Cat("Zhurka", 7),
            new Cat("Vasya", 6)
        };

        Plate plate = new Plate(15);
        int counter = 0;
        do {
            for (Cat cat : cats) {
                if (cat.eat(plate)) {
                    System.out.println(cat.getName() + " ate successfully.");
                    counter++;
                } else {
                    if (cat.isHungry()) {
                        System.out.printf("%s have %d appetit, but plate have only %d food.\n", cat.getName(), cat.getAppetit(), plate.getFood());
                    } else {
                        System.out.println(cat.getName() + " is not hungry.");
                    }
                }
            }
            plate.addFood(10);
            System.out.println("Added food in plate.\n");
        } while (counter != cats.length);
    }
}