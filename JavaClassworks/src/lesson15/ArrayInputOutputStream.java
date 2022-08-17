package lesson15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.util.Arrays;

public class ArrayInputOutputStream {
    public static void main(String[] args) {
        // input stream
        byte[] input = {100, 25, 50};
        ByteArrayInputStream ais = new ByteArrayInputStream(input);
        int x;
        while ((x = ais.read()) != -1) {
            System.out.println(x + " ");
        }
        System.out.println();

        //output stream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(10);
        out.write(20);
        out.write(30);
        byte[] output = out.toByteArray();
        System.out.println(Arrays.toString(output));
    }
}
