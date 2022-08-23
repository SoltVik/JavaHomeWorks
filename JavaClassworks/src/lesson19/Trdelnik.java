package lesson19;

public class Trdelnik {
    private int countTrdlo = 0;
    private final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        Trdelnik trdlo = new Trdelnik();
        Thread cook = new Thread(() -> trdlo.cookTrdlo());
        Thread buy = new Thread(() -> trdlo.buyTrdlo());

        cook.start();
        buy.start();
        cook.join();
        buy.join();

        System.out.println(trdlo.countTrdlo);
    }

    private void cookTrdlo() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300);
                synchronized (monitor) {
                    if (countTrdlo == 1) {
                        monitor.wait();
                    }
                    System.out.println("Trdelnik is cooked");
                    countTrdlo++;
                    monitor.notify();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void buyTrdlo() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                synchronized (monitor) {
                    if (countTrdlo == 0) {
                        monitor.wait();
                    }
                    if (countTrdlo == 1) {
                        countTrdlo--;
                        System.out.println("Client is happy");
                    } else if (countTrdlo > 1) {
                        countTrdlo--;
                        System.out.println("Client is not so happy");
                    } else {
                        System.out.println("Client is very unhappy");
                    }
                    monitor.notify();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
