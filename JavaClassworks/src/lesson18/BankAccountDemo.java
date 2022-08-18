package lesson18;

public class BankAccountDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount ba = new BankAccount(100);
        Thread u1 = new Thread(() -> ba.pay(50, "John"));
        Thread u2 = new Thread(() -> ba.pay(50, "Mike"));
        Thread u3 = new Thread(() -> ba.pay(50, "Luke"));
        Thread u4 = new Thread(() -> ba.pay(50, "Smith"));

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u1.join();
        u2.join();
        u3.join();
        u4.join();

        System.out.println(ba);
    }
}
