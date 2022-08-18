package lesson18;

public class PrintABWaitNotify {

    private final Object monitor = new Object();
    private char letter = 'A';
    private char nextLetter = 'A';



    public static void main(String[] args) {
        PrintABWaitNotify pab = new PrintABWaitNotify();
//        new Thread(() -> pab.printA()).start();
//        new Thread(() -> pab.printB()).start();
        new Thread(() -> pab.printLetter('A')).start();
        new Thread(() -> pab.printLetter('B')).start();
    }

    public void printLetter (char letter) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 10; i++) {
                    if (letter != nextLetter) {
                        monitor.wait();
                    }
                    Thread.sleep(500);
                    System.out.print(nextLetter);

                    if (letter == 'A') {
                        nextLetter++;
                    } else {
                        nextLetter--;
                    }
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (letter != 'A') {
                        monitor.wait();
                    }
                    Thread.sleep(500);
                    System.out.print("A");
                    letter = 'B';
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (letter != 'B') {
                        monitor.wait();
                    }
                    Thread.sleep(500);
                    System.out.print("B");
                    letter = 'A';
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
