package lesson15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputInputStream {
    public static void main(String[] args) {

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("demo.txt"))) {
            out.writeInt(128);
            out.writeLong(128L);
            out.writeBytes("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream in = new DataInputStream(new FileInputStream("demo.txt"))) {
            System.out.println(in.readInt());
            System.out.println(in.readLong());
            System.out.println(in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
