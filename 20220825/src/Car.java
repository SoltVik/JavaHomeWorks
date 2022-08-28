import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static final CountDownLatch PREPARING =  new CountDownLatch(Race.CARS_COUNT);
    private static int CARS_COUNT;
    private static int WINNER_NUMBER = 1;
    private final Track race;
    private final int speed;
    private final String name;

    private int passedStages;

    public Car(Track race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.passedStages = 0;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPassedStages() {
        return passedStages;
    }

    public void increasePassedStages() {
        passedStages++;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            PREPARING.countDown();

            if (PREPARING.getCount() == 0) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
            PREPARING.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }

    public void checkWinner () {
        increasePassedStages();
        if (getPassedStages() == Race.stageCount) {
            if (WINNER_NUMBER == 1) {
                System.out.println(name + " - WIN");
            } else if (WINNER_NUMBER == CARS_COUNT) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            }
            WINNER_NUMBER++;
        }
    }
}