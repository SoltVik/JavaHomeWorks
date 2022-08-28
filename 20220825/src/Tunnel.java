import java.util.concurrent.Semaphore;

public class Tunnel implements Stage {
    protected int length;
    protected String description;
    Semaphore smp = new Semaphore(Race.CARS_COUNT / 2);
    private Object monitor = new Object();

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {

        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                synchronized (monitor) {
                    c.checkWinner();
                }
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}