package lesson21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        new EchoClient();
    }

    EchoClient() {
        String msg;
        try (Socket socket = new Socket("127.0.0.1", 2048);
             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))){
            System.out.println("Connection to server...");
            Scanner scanner = new Scanner(System.in);

            do {
                msg = scanner.nextLine();
                writer.println(msg);
                writer.flush();
                //System.out.println(reader.readLine());
            } while (!msg.equals("exit"));

        } catch(IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Connection closed.");
    }
}
