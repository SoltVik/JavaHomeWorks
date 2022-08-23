package lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) {
        new HelloClient();
    }

    HelloClient() {
        try (Socket socket = new Socket("127.0.0.1", 2048);
             BufferedReader reader =
                     new BufferedReader(
                                     new InputStreamReader(socket.getInputStream()))) {
             System.out.println(reader.readLine());
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
