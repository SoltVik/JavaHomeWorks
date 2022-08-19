/**
 * Java. Homework #18
 *
 * @author Viktors Soltums
 * @version 19 Aug 2022
 */
/*
Необходимо написать два метода, которые делают следующее:

1) Создают одномерный длинный массив, например:
2) Заполняют этот массив единицами.
3) Засекают время выполнения: long a = System.currentTimeMillis().
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле: arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis().
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a)

Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class Homework18 {
    static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        float[] array = new float[SIZE];
        fillArrayWith(array, 1.0f);

        long startTime = System.currentTimeMillis();
        getNewValueForElements(array);

        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

        startTime = System.currentTimeMillis();
        array = splitMergeAndFillArray();

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

    }

    public static void fillArrayWith(float[] array, float value) {
        Arrays.fill(array, value);
    }

    public static void getNewValueForElements(float[] array) {
        IntStream
                .range(0, array.length)
                .forEach(i -> array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
    }

    public static float[] splitMergeAndFillArray() {
        float[] array = new float[SIZE];
        fillArrayWith(array, 1.0f);
        int length = array.length;
        int lengthLeftHalf = length / 2;
        int lengthRightHalf = length - lengthLeftHalf;

        float[] leftHalf = new float[lengthLeftHalf];
        float[] rightHalf = new float[lengthRightHalf];
        System.arraycopy(array, 0, leftHalf, 0, lengthLeftHalf);
        System.arraycopy(array, lengthLeftHalf, rightHalf, 0, lengthRightHalf);

        Thread t0 = new Thread(() -> {
            getNewValueForElements(leftHalf);
        });

        Thread t1 = new Thread(() -> {
            getNewValueForElements(rightHalf);
        });


        t0.start();
        t1.start();

        try {
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        float[] mergedArray = new float[length];
        System.arraycopy(leftHalf, 0, mergedArray, 0, lengthLeftHalf);
        System.arraycopy(rightHalf, 0, mergedArray, lengthLeftHalf, lengthRightHalf);

        return mergedArray;
    }
}