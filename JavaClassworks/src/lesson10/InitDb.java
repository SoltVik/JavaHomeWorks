package lesson10;

import java.util.Arrays;
import java.util.Collection;

public class InitDb {

    private static Collection<Employee> initData;

    static {
        initData = Arrays.asList(
                new Employee("John", "director", 1250, 45),
                new Employee("Joy", "assistant", 750, 23),
                new Employee("Mark", "engineer", 1050, 42),
                new Employee("Elza", "accountant", 950, 32),
                new Employee("Karl", "engineer", 1025, 40)
        );
    }


    public static Collection<Employee> getInitData() {
        return initData;
    }
}