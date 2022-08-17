package lesson15;

import java.io.File;

public class Lesson15 {
    public static void main(String[] args) {
        File file = new File("D:\\PC\\TelRan\\JavaProjects\\JavaHomeWorks\\JavaClassworks\\12345.bin");
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.isFile());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.length());
    }
}

