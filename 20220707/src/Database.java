import java.util.*;

public class Database {
    Map<String, Employee> employeeMap = new HashMap<>();
    Set<String> positions = new HashSet<>();

    public void init() {
        employeeMap.put("John", new Employee("John", "director", 1250, 45));
        employeeMap.put("Joy", new Employee("Joy", "assistant", 750, 23));
        employeeMap.put("Mark", new Employee("Mark", "engineer", 1050, 42));
        employeeMap.put("Karl", new Employee("Karl", "engineer", 1025, 40));

        for (String key : employeeMap.keySet()) {
            Employee employee = employeeMap.get(key);
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

}