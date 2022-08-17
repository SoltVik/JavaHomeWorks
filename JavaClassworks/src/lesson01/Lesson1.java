package lesson01;

public class Lesson1 {

    public static void main(String[] args) {
	    String str = new String("123");
        System.out.println(str);

        Cat cat = new Cat("Barsik", "White", 2);
        //cat.name = "Barsik";
        //cat.color = "White";
        //cat.age = 2;
        System.out.println(cat.voice());
        System.out.println(cat.name + ", " + cat.color + ", " + cat.age);
        
    }
}


class Cat {
    String name;
    String color;
    int age;

    Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    Cat() {
        System.out.println("Constructor");
    }

    String voice() {
        return "Meow!";
    }
}
