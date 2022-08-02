import java.util.*;

public class Phonebook {
    private Map<String, Set<String>> phoneMap = new HashMap<>();

    public void init() {
        phoneMap.computeIfAbsent("John", k ->new HashSet<>()).add("123456");
        phoneMap.computeIfAbsent("Joy", k ->new HashSet<>()).add("123457");
        phoneMap.computeIfAbsent("Mark", k ->new HashSet<>()).add("123458");
        phoneMap.computeIfAbsent("Karl", k ->new HashSet<>()).add("123459");
    }

public void add(String name, String number) {
    phoneMap.computeIfAbsent(name, k -> new HashSet<>()).add(number);
}

public Set<String> get(String name) {
    return phoneMap.get(name);
    }

    @Override
    public String toString() {
        return "Phonebook\n" + phoneMap;
    }
}
