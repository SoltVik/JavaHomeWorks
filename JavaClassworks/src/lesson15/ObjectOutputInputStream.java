package lesson15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectOutputInputStream {
    public static void main(String[] args) {
        byte[] byteCat = null;

        try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
             ObjectOutputStream objOut = new ObjectOutputStream(barrOut)) {
            Cat catOut = new Cat("Barsik");
            objOut.writeObject(catOut);
            byteCat = barrOut.toByteArray();
            System.out.println("Cat before serializable: " + catOut);
            System.out.println("Cat serializabled: " + Arrays.toString(byteCat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(byteCat))) {
            Cat catIn = (Cat) objIn.readObject();
            System.out.println("Cat deserializabled: " + catIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

