package lesson18;

public class PrintAB {
    public static void main(String[] args) {
        PrintAB pab = new PrintAB();
        new Thread(() -> pab.printA()).start();
        new Thread(() -> pab.printB()).start();
        new Thread(() -> pab.printA()).start();
        new Thread(() -> pab.printB()).start();
    }

    public void printA() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("A");
        }
    }

    public void printB() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("B");
        }
    }
}
