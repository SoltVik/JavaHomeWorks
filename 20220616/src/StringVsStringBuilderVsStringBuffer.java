/**
 * Java. Homework #3
 * @author Viktors Soltums
 * @version 16 Jun 2022
 *
 */
/*
Воспроизвести код теста сравнение String и StringBuilder и StringBuffer
 */
public class StringVsStringBuilderVsStringBuffer {
    public static void main(String[] args) {
        final long COUNT = 512_000;

        //using String
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < COUNT; i++) {
            str += "x";
        }
        System.out.println("String: " + (System.currentTimeMillis() - startTime));

        //using StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < COUNT; i++) {
            builder.append("x");
        }
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - startTime));

        //using StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < COUNT; i++) {
            buffer.append("x");
        }
        System.out.println("StringBuffer: " + (System.currentTimeMillis() - startTime));
    }
}