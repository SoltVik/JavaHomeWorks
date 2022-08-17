package lesson15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileInputOutputStream {
    public static void main(String[] args) {
        byte[] bw = {11, 22, 33, 44, 55};
        byte[] buffer = new byte[10];

        File file = new File("12345.bin");

        //writing to file
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(bw);
            System.out.println("Write " + bw.length + " byte(s)");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //reading from file
        try (FileInputStream in = new FileInputStream(file)) {
            int count = in.read(buffer);
            System.out.println("Read " + count + " byte(s)");
            System.out.println(Arrays.toString(buffer));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
