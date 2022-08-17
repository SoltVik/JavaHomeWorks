package lesson17;

//Multithreading
public class RunnableThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": starts");
        Thread thread0 = new Thread(new RunnableImpl());
        Thread thread1 = new Thread(new RunnableImpl());
        Thread thread2 = new ThreadExt();
        Thread thread3 = new ThreadExt();

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });

        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });

//        thread0.start();
//        thread1.start();
        thread2.start();
        thread3.start();
        thread2.join();
        thread3.join();
//        thread4.start();
//        thread5.start();
        System.out.println("END");
    }
}
