import java.util.*;

public class Phonebook {
    Map<String, ArrayList<String>> phoneMap = new HashMap<>();

    public void init() {
        phoneMap.computeIfAbsent("John", k ->new ArrayList<>()).add("123456");
        phoneMap.computeIfAbsent("Joy", k ->new ArrayList<>()).add("123457");
        phoneMap.computeIfAbsent("Mark", k ->new ArrayList<>()).add("123458");
        phoneMap.computeIfAbsent("Karl", k ->new ArrayList<>()).add("123459");
    }

public void add(String name, String number) {
    if (!phoneMap.get(name).contains(number)) {
        phoneMap.computeIfAbsent(name, k -> new ArrayList<>()).add(number);
    }
}

public List<String> get(String name) {
    return phoneMap.get(name);
    }

    @Override
    public String toString() {
        return "Phonebook\n" + phoneMap;
    }
}
