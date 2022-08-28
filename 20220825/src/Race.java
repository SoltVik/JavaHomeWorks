/**
 * Java. Homework #20
 *
 * @author Viktors Soltums
 * @version 28 Aug 2022
 */
/*
Все участники должны стартовать одновременно, несмотря на разное время  подготовки.
В тоннель не может одновременно заехать больше половины участников (условность).
Попробуйте все это синхронизировать.
Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты). Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).
Когда все завершат гонку, нужно выдать объявление об окончании.
 */

public class Race {
    public static final int CARS_COUNT = 4;
    public static int stageCount;


    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Track track = new Track(new Road(60), new Tunnel(), new Road(40));

        stageCount = track.getStages().size();

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(track, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread (cars[i]).start();

        }
    }
}