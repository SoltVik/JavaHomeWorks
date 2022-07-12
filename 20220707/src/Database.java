import java.util.*;

public class Database {
    List<Employee> employees = new ArrayList<>();
    Map<String, Employee> employeeMap = new HashMap<>();
    Map<String, Employee> sortedMap = new TreeMap<>();
    Set<String> positions = new HashSet<>();

    public void init() {
        employees.addAll(InitDb.getInitData());
        /*
        employeeMap.put("John", new Employee("John", "director", 1250, 45));
        employeeMap.put("Joy", new Employee("Joy", "assistant", 750, 23));
        employeeMap.put("Mark", new Employee("Mark", "engineer", 1050, 42));
        employeeMap.put("Karl", new Employee("Karl", "engineer", 1025, 40));

        for (String key : employeeMap.keySet()) {
            Employee employee = employeeMap.get(key);
            positions.add(employee.getPosition());
        }
        */
        for (Employee employee : employees) {
            employeeMap.put(employee.getName(), employee);
            sortedMap.put(employee.getName(), employee);
            positions.add(employee.getPosition());
        }
    }

    public void create(Employee employee) {
        employeeMap.put(employee.getName(), employee);
        positions.add(employee.getPosition());
    }

    public String read() {

        StringBuffer sb = new StringBuffer();

        for (String key : employeeMap.keySet()) {
            sb.append(employeeMap.get(key) + "\n");
        }
        return sb.toString();
    }

    public void update(String name, Employee employee) {
        delete(name);
        create(employee);
    }

    public void delete(String name) {
        Employee employee = employeeMap.get(name);
        if (employee != null) {
            employeeMap.remove(name);
        }

    }

    public String find(String name) {
        Employee employee = employeeMap.get(name);
        if (employee != null) {
            return employee + "\n";
        }
        return "Not found";
    }

    public String getPositions() {
        StringBuffer sb = new StringBuffer();
        for (String position : positions) {
            sb.append(position + "\n");
        }
        return sb.toString();
    }

    public void printList() {
        /*Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //return o1.getName().compareTo(o2.getName());
                return o1.getAge() - o2.getAge();
            }
        };
        employees.sort(comparator);*/
/*
        Set<Employee> sortedSet = new TreeSet<>(employees);
        for (Employee employee : sortedSet) {
            System.out.println(employee);
        }*/
        /*for (String key : sortedMap.keySet()) {
            System.out.println(sortedMap.get(key));
        }*/
        for (Employee employee : sortedMap.values()) {
            System.out.println(employee);
        }
    }

}