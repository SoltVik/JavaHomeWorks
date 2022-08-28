package lesson20;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore smp = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + w + " before semaphore");
                    smp.acquire();
                    System.out.println("Thread " + w + " got permissions");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Thread " + w + " freed the resource");
                    smp.release();
                }
            }).start();
        }
    }
}
