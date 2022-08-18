package lesson18;

import java.sql.SQLOutput;

public class BankAccount {
    private int money;

    public BankAccount(int money) {
        this.money = money;
    }

    public synchronized void pay (int amount, String name) {
        if (money >= amount) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println(name + " gets: " + amount);
        } else {
            System.out.println(name + " sorry, not enough money: " + money);
        }
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "money=" + money +
                '}';
    }
}
