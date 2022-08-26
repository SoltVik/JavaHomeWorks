package lesson20;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            int index = i;
            new Thread(() -> {
               try {
                   System.out.println("Prepared " + index);
                   Thread.sleep(2000 + 500 * (int) (Math.random()*10));
                   System.out.println("Ready " + index);
                   cyclicBarrier.await();
                   System.out.println("Gone " + index);
                   Thread.sleep(2000 + 500 * (int) (Math.random()*10));
                   System.out.println("Done " + index);
                   cyclicBarrier.await();
                   System.out.println("Finished " + index);
               } catch (InterruptedException | BrokenBarrierException e) {
                   e.printStackTrace();
               }
            }).start();
        }
    }

}
