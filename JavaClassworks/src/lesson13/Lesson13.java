package lesson13;

import lesson10.Employee;
import lesson10.InitDb;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lesson13 {
    public static void main(String[] args) {
        Collection<Employee> employees = InitDb.getInitData();
        //int counter = 0;
        //Iterator<Employee> iterator = employees.iterator();
        //for (Employee employee : employees)
        /*while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getPosition().equals("engineer")) {
                counter++;
            }
        }*/
        /*long counter = employees.stream()
                .filter(position -> position.getPosition().equals("engineer"))
                .count();*/
        Set<String> position =
                employees.stream()
                        //.filter(e -> e.getAge() > 40)
                        .map(e -> e.getPosition().toLowerCase())
                        .collect(Collectors.toSet());
        System.out.println(position);
        //    filter(), map()
        //    count(), collect()

        //создание карты имя = сотрудник
        Map<String, Employee> eMap = employees.stream()
                .collect(Collectors.toMap(e -> e.getName(), e -> e));
        System.out.println(eMap);

        //создание карты позиция = список сотрудников
        Map<String, Set<String>> pMap = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getPosition(),
                        Collectors.mapping(e -> e.getName(), Collectors.toSet())
                ));
        System.out.println(pMap);

    }
}