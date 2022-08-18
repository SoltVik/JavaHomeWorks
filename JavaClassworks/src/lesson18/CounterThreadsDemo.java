package lesson18;

public class CounterThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter1.increment();
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter1.decrement();
            }
        });

        t0.start();
        t1.start();
        t0.join();
        t1.join();

        System.out.println(counter1);
    }


}
