/**
 * Java. Homework #10
 * @author Viktors Soltums
 * @version 7 Jul 2022
 *
 */
import java.util.Scanner;

public class TestDatabase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        database.init();

        boolean exit = false;

        String name;

        while(!exit) {
            System.out.print("db> ");
            String command = scanner.next();
            switch (command) {
                case "x":
                    exit = true;
                    break;
                case "c":
                    System.out.print("db> create ");
                    database.create(Employee.createEmployee());
                    break;
                case "r":
                    System.out.println(database.read());
                    break;
                case "u":
                    System.out.print("db> select ");
                    String oldName = scanner.next();
                    System.out.print("db> " + oldName + " update ");
                    database.update(oldName, Employee.createEmployee());
                    break;
                case "d":
                    System.out.print("db> delete ");
                    name = scanner.next();
                    database.delete(name);
                    break;
                case "f":
                    System.out.print("db> find ");
                    name = scanner.next();
                    System.out.println(database.find(name));
                    break;
                case "p":
                    System.out.println(database.getPositions());
                    break;
            }
        }

    }
}