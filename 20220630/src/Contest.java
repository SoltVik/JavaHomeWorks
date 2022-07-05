/**
 * Java. Homework #7
 *
 * @author Viktors Soltums
 * @version 03 Jul 2022
 */
/*
Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

 */

public class Contest {
    public static void main(String[] args) {
        IActions[] members = {
                new Human(100, 2),
                new Human(50, 1),
                new Cat(200, 3),
                new Cat(300, 4),
                new Robot(600, 3),
                new Robot(1000, 5)

        };

        IObstacle[] obstacles = {
                new Wall(1),
                new Wall(3),
                new Wall(4),
                new Treadmill(100),
                new Treadmill(300),
                new Treadmill(800)

        };

        int totalObstacles = obstacles.length;

        for (IActions member : members) {
            int i = 0;
            System.out.println(member + "\n-----");
            for (IObstacle obstacle : obstacles) {
                if (!obstacle.exec(member)) {
                    break;
                }
                i++;
                if (i == totalObstacles) {
                    System.out.println(member.getName() + " successfully past all obstacles!");
                }
            }
            System.out.println();
        }
    }
}