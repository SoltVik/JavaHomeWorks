package lesson24;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class strClass = "Java".getClass();
        Class voidClass = void.class;

        System.out.println(strClass);
        System.out.println(voidClass);

        System.out.println(strClass.getName());
        System.out.println(strClass.getSimpleName());

        Class superClass = strClass.getSuperclass();

        System.out.println(superClass);

        Cat cat = new Cat();
        Method mMeow = Cat.class.getDeclaredMethod("voice", int.class);
        Object invoke = mMeow.invoke (cat, 0);
    }
}
