package lesson17;

public class ThreadExt extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
